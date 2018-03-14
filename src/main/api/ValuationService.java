package main.api;

import io.swagger.annotations.*;
import main.Util.SessionUtil;
import main.annotation.Environment;
import main.models.ResponseWrapper;
import main.models.UserSession;
import main.models.Valuation;
import main.models.ValuationDelete;
import main.services.ApiService;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

/**
 * Created by orvillelim on 08/03/2018.
 */

@Path("ttsvr/msg/valuations")
@Api(description = "Valuation Services")
public class ValuationService {

    @Context
    private HttpServletRequest servletRequest;
    private ApiService apiService = new ApiService();
    private ResponseWrapper responseWrapper = null;

    @POST
    @Path("/")
    @ApiOperation(httpMethod = "POST",
            value = "Add Valuation",
            tags = "Valuation Service",
            notes = " ")
    @Environment(environments = {"SIT", "UAT"})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful Operation"),
            @ApiResponse(code = 404, message = "No Operation found") })
    public Response addValuation(@ApiParam(value = "Sample JSON request body", required = true) Valuation request) {

        responseWrapper = apiService.post(request, servletRequest);

        return Response.status(responseWrapper.getResponseCode()).entity(responseWrapper.getResponse()).build();
    }

    @GET
    @Path("/")
    @ApiOperation(httpMethod = "GET",
            value = "Get user Valuations",
            tags = "Valuation Service",
            notes = " ")
    @Environment(environments = {"SIT", "UAT"})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful Operation"),
            @ApiResponse(code = 404, message = "No Operation found")})
    public Response getValuation(@ApiParam(value ="username of user ") @QueryParam("userName") String username,
                                 @ApiParam(value ="location") @QueryParam("loc") String loc,
                                 @ApiParam(value ="authentication token") @QueryParam("sid") String sid) {

        String queryString = String.valueOf(servletRequest.getQueryString());
        String path = "/valuations?" + queryString;

        UserSession userSession = SessionUtil.getUserSession( servletRequest.getSession().getId(), servletRequest);
        String url =  userSession.getEndpoint(true) + path;

        responseWrapper = apiService.get(url);

        return Response.status(responseWrapper.getResponseCode()).entity(responseWrapper.getResponse()).build();
    }

    @GET
    @Path("/getValuationByUserName")
    @ApiOperation(httpMethod = "GET",
            value = "Get user Valuation id by username",
            tags = "Valuation Service",
            notes = " ")
    @Environment(environments = {"SIT", "UAT"})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful Operation"),
            @ApiResponse(code = 404, message = "No Operation found")})
    public Response getValuationByUserName(@ApiParam(value ="username of user ") @QueryParam("userName") String username,
                                 @ApiParam(value ="location") @QueryParam("loc") String loc,
                                 @ApiParam(value ="authentication token") @QueryParam("sid") String sid) {

        String queryString = String.valueOf(servletRequest.getQueryString());
        String path = "/valuations/valexIds?" + queryString;

        UserSession userSession = SessionUtil.getUserSession( servletRequest.getSession().getId(), servletRequest);
        String url =  userSession.getEndpoint(true) + path;

        responseWrapper = apiService.get(url);

        return Response.status(responseWrapper.getResponseCode()).entity(responseWrapper.getResponse()).build();
    }


    @DELETE
    @Path("/")
    @ApiOperation(httpMethod = "DELETE",
            value = "DELETE user Valuation ",
            tags = "Valuation Service",
            notes = " ")
    @Environment(environments = {"SIT", "UAT"})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful Operation"),
            @ApiResponse(code = 404, message = "No Operation found")})
    public Response deleteValuation(@ApiParam(value = "Sample JSON request body", required = true) ValuationDelete request) {
        String path = "/valuations?";

        UserSession userSession = SessionUtil.getUserSession( servletRequest.getSession().getId(), servletRequest);
        String url = userSession.getEndpoint(true) + path;

        responseWrapper = apiService.delete(request, url);

        return Response.status(responseWrapper.getResponseCode()).entity(responseWrapper.getResponse()).build();
    }

    @POST
    @Path("/push")
    @ApiOperation(httpMethod = "POST",
            value = "Push Valuation to user with source",
            tags = "Valuation Service",
            notes = " ")
    @Environment(environments = {"SIT", "UAT"})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful Operation"),
            @ApiResponse(code = 404, message = "No Operation found") })
    public Response pushAdd(@ApiParam(value = "Sample JSON request body", required = true) Valuation request) {

        responseWrapper = apiService.post(request, servletRequest);

        return Response.status(responseWrapper.getResponseCode()).entity(responseWrapper.getResponse()).build();
    }


    @GET
    @Path("/push/sync")
    @ApiOperation(httpMethod = "GET",
            value = "Get user association status",
            tags = "Valuation Service",
            notes = " ")
    @Environment(environments = {"SIT", "UAT"})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful Operation"),
            @ApiResponse(code = 404, message = "No Operation found")})
    public Response getUserAssociationStatus(@ApiParam(value ="username of user ") @QueryParam("userName") String username,
                                 @ApiParam(value ="location") @QueryParam("loc") String loc,
                                 @ApiParam(value ="authentication token") @QueryParam("sid") String sid,
                                 @ApiParam(value ="hub") @QueryParam("source") String source) {

        String queryString = String.valueOf(servletRequest.getQueryString());
        String path = "/valuations/push/sync?" + queryString;

        UserSession userSession = SessionUtil.getUserSession( servletRequest.getSession().getId(), servletRequest);
        String url =  userSession.getEndpoint(true) + path;

        responseWrapper = apiService.get(url);

        return Response.status(responseWrapper.getResponseCode()).entity(responseWrapper.getResponse()).build();
    }


    @DELETE
    @Path("/push/sync")
    @ApiOperation(httpMethod = "DELETE",
            value = "Cancel user association with source ",
            tags = "Valuation Service",
            notes = " ")
    @Environment(environments = {"SIT", "UAT"})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful Operation"),
            @ApiResponse(code = 404, message = "No Operation found")})
    public Response cancelSync(@ApiParam(value ="username of user ") @QueryParam("userName") String username,
                               @ApiParam(value ="location") @QueryParam("loc") String loc,
                               @ApiParam(value ="authentication token") @QueryParam("sid") String sid,
                               @ApiParam(value ="hub") @QueryParam("source") String source) {

        String queryString = String.valueOf(servletRequest.getQueryString());
        String path = "/valuations/push/sync?" + queryString;

        UserSession userSession = SessionUtil.getUserSession( servletRequest.getSession().getId(), servletRequest);
        String url =  userSession.getEndpoint(true) + path;
        responseWrapper = apiService.delete(url);

        return Response.status(responseWrapper.getResponseCode()).entity(responseWrapper.getResponse()).build();
    }



    @POST
    @Path("/push/sync")
    @ApiOperation(httpMethod = "POST",
            value = "Sync user to source",
            tags = "Valuation Service",
            notes = " ")
    @Environment(environments = {"SIT", "UAT"})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful Operation"),
            @ApiResponse(code = 404, message = "No Operation found") })
    public Response sync(@ApiParam(value = "Sample JSON request body", required = true) Valuation request) {

        responseWrapper = apiService.post(request, servletRequest);

        return Response.status(responseWrapper.getResponseCode()).entity(responseWrapper.getResponse()).build();
    }

}
