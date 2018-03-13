package main.services;

import com.sun.jersey.api.container.ContainerException;
import com.sun.jersey.core.util.ReaderWriter;
import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerRequestFilter;
import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class JerseyInterceptor implements ContainerRequestFilter {

    @Override
    public ContainerRequest filter(ContainerRequest request) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        InputStream in = request.getEntityInputStream();
        try {
            if (in.available() > 0) {
                ReaderWriter.writeTo(in, out);

                byte[] requestEntity = out.toByteArray();

                request.setEntityInputStream(new ByteArrayInputStream(requestEntity));

                String json = IOUtils.toString(new ByteArrayInputStream(requestEntity), "UTF-8");
                //System.out.println(json);

                if (!isValidObjectToJSon(json)){
                    ExceptionHandleService.throwJsonParseExceptionResponse();
                }
            }

            return request;
        } catch (IOException ex) {
            throw new ContainerException(ex);
        }
    }

    private boolean isValidObjectToJSon(String requestBody){
        try {
            JSONObject o = new JSONObject(requestBody);
            return  true;
        } catch (JSONException e) {
            return false;
        }
    }


}
