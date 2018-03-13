
package main.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import main.annotation.OperationHidden;

public class Valuation  implements RequestBody {

    @SerializedName("userName")
    @Expose
    private String userName;
    @SerializedName("valexId")
    @Expose
    private String valexId;
    @SerializedName("customerSurname")
    @Expose
    private String customerSurname;
    @SerializedName("asicId")
    @Expose
    @OperationHidden(operations = {"deleteValuation"})
    private String asicId;
    @SerializedName("loc")
    @Expose
    private String loc;
    @SerializedName("sid")
    @Expose
    private String sid;

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