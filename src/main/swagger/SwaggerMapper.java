package main.swagger;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.swagger.config.FilterFactory;
import main.Util.SessionUtil;
import main.app.ApiEnvFilterImpl;
import main.app.AppEnvironmentUtil;
import main.models.ResponseWrapper;
import main.models.UserSession;
import main.services.ApiService;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Map;


@Path("/spec")
public class SwaggerMapper {

    @Context
    private HttpServletRequest request;
    private UserSession userSession = new UserSession();
    private ResponseWrapper responseWrapper = new ResponseWrapper();

    @Context
    ServletContext context;

    //private String devSwagger = "http://swagger-env.uksqf6erhu.us-east-2.elasticbeanstalk.com/api/swagger.json";
    private String devSwagger = "swagger.json";
    private  Gson gson = new Gson();

    @GET
    @Path("/getSwagger")
    public Response getSwagger(@QueryParam("env") String env, @QueryParam("sid") String sid) {

        String endpoint = AppEnvironmentUtil.getCurrentEndPointByString(env);
        ApiService apiService = new ApiService(endpoint);

        userSession = getUserSessionInSession();
        userSession.setEnvironment(env);
        userSession.setEndpoint(endpoint);

        // set filtering
        ApiEnvFilterImpl apiEnvFilter = new ApiEnvFilterImpl(userSession);
        FilterFactory.setFilter(apiEnvFilter);

        storeUserSessionInSession(userSession, request.getSession());

        responseWrapper = apiService.get( "http://localhost:8080/swagger/msg-swagger/" + devSwagger);

        String jsonSwagger = overWriteSid(sid, responseWrapper.getResponse());

        return Response.status(responseWrapper.getResponseCode()).entity(jsonSwagger).build();

    }

    private String overWriteSid(String sid, String response){
        if (sid  == null){
            return response;
        }

        JsonObject json  = gson.fromJson(response, JsonObject.class);

        JsonElement sidEl =  json.get("definitions");

        for (Map.Entry<String, JsonElement> element : sidEl.getAsJsonObject().entrySet()) {
            JsonObject el = element.getValue().getAsJsonObject();
            el = el.get("properties").getAsJsonObject();
            if (el.get("sid") != null){
                el = el.get("sid").getAsJsonObject();
                el.addProperty("example", sid);
            }

        }

        response = overWriteModel(json.toString());

        return response;

    }

    /**
     *
     * swagger don't support same model for different endpoint
     * let's say the model has 5 fields that being used on endpoint 1
     * but on endpoint 2 we only need the 3 fields of model
     *
     * unfortunately the "isPropertyAllowed" method in Filtering have no access
     * on Operation object which holds the method name to describe the specification.
     *
     * check here: https://github.com/OAI/OpenAPI-Specification/issues/182
     *
     * WORK around:
     * replace the definition of the endpoint in json
     *
     *
     * @param response
     * @return
     */
    private String overWriteModel(String response){
        AppEnvironmentUtil appEnvironmentUtil =  new AppEnvironmentUtil();
        appEnvironmentUtil.initializeEnvironmentApis();


        JsonObject json  = gson.fromJson(response, JsonObject.class);

        JsonElement paths =  json.get("paths");
        JsonObject modelDefinitions =  json.get("definitions").getAsJsonObject();

        // get hidden fields
        Map<String, List<String>> operationHiddenPaths = appEnvironmentUtil.getPaths();

        for (Map.Entry<String, JsonElement> path : paths.getAsJsonObject().entrySet()) {

          JsonObject element =  path.getValue().getAsJsonObject();
          JsonObject placeHolder = null;

            if (element.get("delete") != null){
                placeHolder = element.get("delete").getAsJsonObject();
            }
            if (element.get("get") != null){
                placeHolder = element.get("get").getAsJsonObject();
            }
            if (element.get("post") != null){
                placeHolder = element.get("post").getAsJsonObject();
            }

            if (element.get("put") != null){
                placeHolder = element.get("put").getAsJsonObject();
            }

            String operationId = placeHolder.get("operationId").getAsString();

            if (operationHiddenPaths != null && operationHiddenPaths.containsKey(operationId)){

                // copy the model definition & hide the necessary fields
                String referencePath = placeHolder.get("parameters").getAsJsonArray().get(0).getAsJsonObject().get("schema").getAsJsonObject().get("$ref").getAsString();
                referencePath = referencePath.substring(referencePath.lastIndexOf("/") + 1);

                JsonObject cloneDefinition =  new Gson().fromJson( modelDefinitions.get(referencePath).toString(), JsonObject.class );
                JsonObject properties = cloneDefinition.get("properties").getAsJsonObject();
                for (String field : operationHiddenPaths.get(operationId)){
                    properties.remove(field);
                }

                // append the modified definition in definition scheme
                referencePath = referencePath + "_" + operationId;
                modelDefinitions.add(referencePath, cloneDefinition);

                // replace the definition model path of the swagger path
                placeHolder.get("parameters").getAsJsonArray().get(0).getAsJsonObject().get("schema").getAsJsonObject().addProperty("$ref","#/definitions/" +referencePath);

            }

        }
        response = json.toString();
        return response;

    }

    private void storeUserSessionInSession(UserSession userSession, HttpSession session){
        session.setAttribute(session.getId() , userSession);
    }

    private UserSession getUserSessionInSession(){
        String id = request.getSession().getId();

        UserSession userSession = SessionUtil.getUserSession(id, request);

        if ( userSession != null){
            return userSession;
        }
        return  new UserSession();
    }

}
