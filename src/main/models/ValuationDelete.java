
package main.models;

import com.google.gson.annotations.Expose;
import io.swagger.annotations.ApiModelProperty;
import main.annotation.OperationHidden;

public class ValuationDelete implements RequestBody {

    @Expose
    @ApiModelProperty(example = "loadtestaust4", required = true)
    @OperationHidden(operations = {"pushAdd"})
    private String userName;

    @Expose
  //  @DynamicData(methodName = "deleteValuation", type = "array")
    @OperationHidden(operations = {"sync"})
   // @ApiModelProperty(example = "804269 ", required = true)
    private String[] valexId;

    @Expose
    @ApiModelProperty(example = "Kimbel", required = true)
    @OperationHidden(operations = {"deleteValuation", "sync"})
    private String customerSurname;


    @Expose
    @ApiModelProperty(example = "AU", required = true)
    private String loc;

    @Expose
    @OperationHidden(operations = {"pushAdd"})
    @ApiModelProperty(example = " ", required = true)
    private String sid;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String[] getValexId() {
        return valexId;
    }

    public void setValexId(String[] valexId) {
        this.valexId = valexId;
    }

    public String getCustomerSurname() {
        return customerSurname;
    }

    public void setCustomerSurname(String customerSurname) {
        this.customerSurname = customerSurname;
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