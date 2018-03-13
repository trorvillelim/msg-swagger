package main.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


public class AuthRequestBody implements RequestBody {

    String sid, uid, op, loc;
    @ApiModelProperty(example = "au", required = false,  value = "AU or NZ")
    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    @ApiModelProperty(example = "193951-951d9d458a1b5492b1d75e40f051e57e", value = "MSG Session Token", required = true)
    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }
    @ApiModelProperty(example = "TWISTUSER001", value = "uid", required = true)
    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

}
