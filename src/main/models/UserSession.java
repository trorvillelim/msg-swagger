package main.models;

import main.app.AppEnvironmentUtil;

/**
 * Created by orvillelim on 28/09/2017.
 */
public class UserSession {

    String auToken = "";
    String nzToken = "";
    String endpoint = "";
    String environment = "";

    public String getAuToken() {
        return auToken;
    }

    public void setAuToken(String auToken) {
        this.auToken = auToken;
    }

    public String getNzToken() {
        return nzToken;
    }

    public void setNzToken(String nzToken) {
        this.nzToken = nzToken;
    }

    public String getEndpoint(boolean isPath) {
        return isPath ? endpoint.replace("?", "") : endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public  String getCurrentEndpoint() {

        if (environment.equals(AppEnvironmentUtil.ENVIRONMENTS.PROD.toString())) {
            return  AppEnvironmentUtil.ENVIRONMENTS.getProdEndPoints();
        } else if (environment.equals(AppEnvironmentUtil.ENVIRONMENTS.UAT.toString())) {
            return AppEnvironmentUtil.ENVIRONMENTS.getUatEndPoint();
        } else {
            return AppEnvironmentUtil.ENVIRONMENTS.getSITendPoints();
        }
    }


}
