package main.models;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by orvillelim on 26/09/2017.
 */

public class LoginRequestBody implements RequestBody {

    @ApiModelProperty(example = "login", required = true)
    String op = "";

    @ApiModelProperty(example = "TWISTUSER001", required = true)
    String uid = "";

    @ApiModelProperty(example = "loadtestaust4", required = true)
    private String user;
    @SerializedName("passwd")

    @ApiModelProperty(example = "tester123", required = true)
    @Expose
    private String passwd;


    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @ApiModelProperty(example = "au", required = true)
    @SerializedName("loc")
    @Expose
    private String loc;

    @ApiModelProperty(example = "rppipad", required = true)
    @SerializedName("appCode")
    @Expose
    private String appCode;

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }


    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

}