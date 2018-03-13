package main.services;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import io.swagger.util.Json;
import main.Util.SessionUtil;
import main.models.RequestBody;
import main.models.ResponseWrapper;
import main.models.UserSession;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * Created by orvillelim on 18/09/2017.
 */
public class ApiService {

    private HttpURLConnection conn;
    private String authorization = "Basic bXNnOkU3bVc6JTZ7REs=";
    private String endpoint = "";


    private Gson gson = new Gson();
    private ResponseWrapper responseWrapper = new ResponseWrapper();

    public ApiService(String endpoint) {
        this.endpoint  = endpoint;
        initEndPoint();
    }

    public ApiService() {

    }

    private void initEndPoint(){

        try {
            setConnectionProperties(endpoint);

        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ResponseWrapper post(RequestBody requestBody, HttpServletRequest servletRequest) {

        try {
            UserSession userSession = SessionUtil.getUserSession( servletRequest.getSession().getId(), servletRequest);
            setEndpoint(userSession.getEndpoint(false));

            conn.setRequestMethod("POST");

            String requestJson = gson.toJson(requestBody);

            OutputStream os = conn.getOutputStream();
            os.write(requestJson.getBytes("UTF-8"));
            os.close();

            return new ResponseWrapper(conn);

        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            conn.disconnect();

        }

        return null;
    }

    public ResponseWrapper get(String url){


        try( CloseableHttpClient client = HttpClientBuilder.create().build(); ) {

            HttpGet request = new HttpGet(url);

            setConnectionProperties(request);
            HttpResponse response = client.execute(request);

            JsonObject jsonObject =  getHttpResponseContent(response);
            return new ResponseWrapper(jsonObject, response.getStatusLine().getStatusCode());

        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void setEndpoint(String endpoint){
        this.endpoint = endpoint;
        initEndPoint();
    }

    private void setConnectionProperties(String urlString) throws IOException {
        URL url = new URL(urlString);

        conn = (HttpURLConnection) url.openConnection();
        conn.setRequestProperty("Authorization", authorization);
        conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
        conn.setDoOutput(true);

    }

    private void setConnectionProperties(HttpUriRequest request) throws IOException {
        request.setHeader("Authorization", authorization);
        request.setHeader("Content-Type", "application/json;charset=UTF-8");

    }

    private JsonObject getHttpResponseContent(HttpResponse response) throws IllegalStateException, IOException {
        InputStream is = response.getEntity().getContent();
        String jsonString = IOUtils.toString(is, "UTF-8");
        JsonObject jsonObject = gson.fromJson(jsonString, JsonObject.class);

        return jsonObject;

    }


}
