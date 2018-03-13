package main.api;

import io.swagger.annotations.*;
import main.annotation.Environment;
import main.models.*;
import main.services.ApiService;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

/**
 *
 */

@Path("/")
@Api(description = "test")
public class MsgAuService  {

    @Context
    private HttpServletRequest servletRequest;
    private ApiService apiService = new ApiService();
    private ResponseWrapper responseWrapper = null;

    @POST
    @Path("/login_bsg")
    @ApiOperation(httpMethod = "POST",
            value = "Login",
            tags = "Services",
            notes = " ")
    @Environment(environments = {"SIT", "UAT", "PROD"})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful Operation"),
            @ApiResponse(code = 404, message = "No Operation found") })
    public Response login(@ApiParam(value = "Sample JSON request body", required = true) LoginRequestBody request) {

        responseWrapper = apiService.post(request, servletRequest);

        return Response.status(responseWrapper.getResponseCode()).entity(responseWrapper.getResponse()).build();
    }


    @POST
    @Path("/getVersion_bsg")
    @ApiOperation(
            httpMethod = "POST",
            value = "Get api version",
            tags = "Services",
            notes = "This call is used to get the current version and build date of the app.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful Operation"),
            @ApiResponse(code = 404, message = "No Operation found") })
    @Environment(environments = {"SIT", "UAT"})
    public Response getVersion(@ApiParam(value = "JSON request body, please click parameters for param description", required = true) VersionRequestBody request) {

        responseWrapper = apiService.post(request, servletRequest);

        return Response.status(responseWrapper.getResponseCode()).entity(responseWrapper.getResponse()).build();
    }


    @POST
    @Path("/getMobileProperty_bsg")
    @ApiOperation(
       httpMethod = "POST",
       tags = "Services",
       notes = "This call is used to fetch all property details of the given search string, it can be full address search, street, suburb or postcode; " +
               "it uses BSGv2’s Search method. Results can be filtered by the status of the property such as for sale, for rent or sales." +
               "When showAdditionalDataElements is true, it will use the BSGv3’s property service to show the additional fields that aren’t available on BSGv2.",
       value = "Get Mobile property")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful Operation"),
            @ApiResponse(code = 404, message = "No Operation found") })
    @Environment(environments = {"SIT", "UAT"})
    public Response getMobileProperty(@ApiParam(value = "Sample JSON request body", required = true) MobileProperty request) {

        responseWrapper = apiService.post(request, servletRequest);

        return Response.status(responseWrapper.getResponseCode()).entity(responseWrapper.getResponse()).build();
    }

    @POST
    @Path("/getMobilePropertyListFromIds_bsg")
    @ApiOperation(httpMethod = "POST",
            value = "Get Mobile property list ids",
            tags = "Services",
            notes = "This call is used to fetch all property details of the given property ids, it uses BSGv2’s Search method. Results can be filtered by the status of the property such as for sale, for rent or sales." +
                    "When showAdditionalDataElements is true, it will use the BSGv3’s property service to show the additional fields that aren’t available on BSGv2.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful Operation"),
            @ApiResponse(code = 404, message = "No Operation found") })
    @Environment(environments = {"SIT", "UAT"})
    public Response getMobilePropertyListFromIds(@ApiParam(value = "Sample JSON request body", required = true) MobilePropertyListIds request) {

        responseWrapper = apiService.post(request, servletRequest);

        return Response.status(responseWrapper.getResponseCode()).entity(responseWrapper.getResponse()).build();
    }

    @POST
    @Path("/getPhotoGalleryV3_bsg")
    @ApiOperation(httpMethod = "POST",
            value = "getPhotoGalleryV3",
            tags = "Services",
            notes="This call is used to fetch the photos using the BSGv3’s Property Detail Service (returnFields=propertyPhotoList) to display the image URLs. For aerial and topo maps, it accesses the BSGv3 Mapping Services.")
    @Environment(environments = {"SIT", "UAT"})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful Operation"),
            @ApiResponse(code = 404, message = "No Operation found") })

    public Response getPhotoGalleryV3(@ApiParam(value = "Sample JSON request body", required = true) PhotoGalleryV3 request) {

        responseWrapper = apiService.post(request, servletRequest);

        return Response.status(responseWrapper.getResponseCode()).entity(responseWrapper.getResponse()).build();
    }

    @POST
    @Path("/getPropertyIDListFromSuggestion_bsg")
    @ApiOperation(httpMethod = "POST",
            value = "getPropertyIDListFromSuggestion",
            tags = "Services",
            notes = "This call fetches a suggestion list that matches the search term; it uses suggest service under BSGv3.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful Operation"),
            @ApiResponse(code = 404, message = "No Operation found") })
    @Environment(environments = {"SIT", "UAT"})
    public Response getPropertyIDListFromSuggestion(@ApiParam(value = "Sample JSON request body", required = true) PropertyIdListFromSuggestion request) {

        responseWrapper = apiService.post(request, servletRequest);

        return Response.status(responseWrapper.getResponseCode()).entity(responseWrapper.getResponse()).build();
    }

}
