package main.services;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

public class ExceptionHandleService {

    public static void throwJsonParseExceptionResponse(){
        Response.ResponseBuilder builder = null;
        String response = "Invalid Json structure";
        builder = Response.status(Response.Status.BAD_REQUEST).entity(response);
        throw new WebApplicationException(builder.build());
    }
}
