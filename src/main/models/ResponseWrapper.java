package main.models;


import com.google.gson.JsonObject;
import org.apache.commons.io.IOUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

public class ResponseWrapper {

    private String response;
    private int responseCode;

    public ResponseWrapper(HttpURLConnection conn){
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
             this.response =  IOUtils.toString(br);
             this.responseCode  = conn.getResponseCode();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ResponseWrapper(JsonObject jsonObject, int httpCode){
        this.responseCode = httpCode;
        this.response = jsonObject.toString();
    }

    public ResponseWrapper( ){
      this.responseCode = 500;
      this.response = "";
    }

    public int getResponseCode(){

        return responseCode;
    }

    public String getResponse(){

        return response;
    }



}
