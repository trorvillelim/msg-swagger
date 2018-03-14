
package main.models;

import com.google.gson.annotations.Expose;
import io.swagger.annotations.ApiModelProperty;
import main.annotation.DynamicData;
import main.annotation.OperationHidden;

public class Valuation  implements RequestBody {

    @Expose
    @ApiModelProperty(example = "loadtestaust4", required = true)
    @OperationHidden(operations = {"pushAdd"})
    private String userName;

    @Expose
  //  @DynamicData(methodName = "deleteValuation", type = "array")
    @OperationHidden(operations = {"sync"})
    @ApiModelProperty(example = "804269 ", required = true)
    private String valexId;

    @Expose
    @ApiModelProperty(example = "Kimbel", required = true)
    @OperationHidden(operations = {"deleteValuation", "sync"})
    private String customerSurname;

    @Expose
    @OperationHidden(operations = {"deleteValuation", "pushAdd", "sync"})
    private String asicId;

    @Expose
    @ApiModelProperty(example = "AU", required = true)
    private String loc;

    @Expose
    @OperationHidden(operations = {"pushAdd"})
    @ApiModelProperty(example = " ", required = true)
    private String sid;

    @ApiModelProperty(example = "lender ", required = false)
    @OperationHidden(operations = {"addValuation", "deleteValuation", "sync"})
    private String lender;

    @ApiModelProperty(example = " ", required = false)
    @OperationHidden(operations = {"addValuation", "deleteValuation", "sync"})
    private String userMobile;

    @OperationHidden(operations = {"addValuation", "deleteValuation"})
    @ApiModelProperty(example = "hub", required = true)
    private String source;

    @OperationHidden(operations = {"addValuation", "deleteValuation"})
    @ApiModelProperty(example = "", required = true)
    private String userEmail;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getValexId() {
        return valexId;
    }

    public void setValexId(String valexId) {
        this.valexId = valexId;
    }

    public String getCustomerSurname() {
        return customerSurname;
    }

    public void setCustomerSurname(String customerSurname) {
        this.customerSurname = customerSurname;
    }

    public String getAsicId() {
        return asicId;
    }

    public void setAsicId(String asicId) {
        this.asicId = asicId;
    }


    public String getLender() {
        return lender;
    }

    public void setLender(String lender) {
        this.lender = lender;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

}