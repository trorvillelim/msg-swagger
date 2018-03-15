package main.api;


import io.swagger.annotations.*;
import main.Util.SessionUtil;
import main.annotation.Environment;
import main.models.ResponseWrapper;
import main.models.UserSession;
import main.services.ApiService;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

@Path("/services")
@Api(description = "test")
public class SuggestService {

    @Context
    private HttpServletRequest servletRequest;
    private ApiService apiService = new ApiService();
    private ResponseWrapper responseWrapper = null;

    @GET
    @Path("/suggest")
    @ApiOperation(httpMethod = "GET",
            value = "Get suggestion types V3",
            tags = "Suggest Service",
            notes = "suggestion types\n" +
                    "1. school or schools\n" +
                    "2. locality\n" +
                    "3. postcode\n" +
                    "4. street\n" +
                    "5. address ")
    @Environment(environments = {"SIT", "UAT"})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful Operation"),
            @ApiResponse(code = 404, message = "No Operation found")})
    public Response getValuationByUserName(@ApiParam(value ="sop ") @QueryParam("searchTerm") String searchTerm,
                                           @ApiParam(value ="locality") @QueryParam("suggestionTypes") String suggestionTypes,
                                           @ApiParam(value ="true") @QueryParam("includeUnits") String includeUnits,
                                           @ApiParam(value ="sid") @QueryParam("sid") String sid,
                                           @ApiParam(value ="10") @QueryParam("limit") String limit,
                                           @ApiParam(value ="Au") @QueryParam("loc") String loc) {

        String queryString = String.valueOf(servletRequest.getQueryString());
        String path = "/services/suggest?" + queryString;

        UserSession userSession = SessionUtil.getUserSession( servletRequest.getSession().getId(), servletRequest);
        String url =  userSession.getEndpoint(true) + path;

        responseWrapper = apiService.get(url);

        return Response.status(responseWrapper.getResponseCode()).entity(responseWrapper.getResponse()).build();
    }
}
