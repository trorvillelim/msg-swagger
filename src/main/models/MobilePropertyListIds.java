package main.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class MobilePropertyListIds extends AuthRequestBody implements RequestBody{

    @SerializedName("ids")
    @Expose
    private List<Integer> ids = null;
    @SerializedName("showAdditionalDataElements")
    @Expose
    private boolean showAdditionalDataElements;

    @ApiModelProperty( value = "expected values: [123,4123]", required = true, position = 2, allowableValues = "1")
    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }


    @ApiModelProperty(example = "true", required = true)
    public boolean isShowAdditionalDataElements() {
        return showAdditionalDataElements;
    }

    public void setShowAdditionalDataElements(boolean showAdditionalDataElements) {
        this.showAdditionalDataElements = showAdditionalDataElements;
    }

    @ApiModelProperty(example = "getMobilePropertyListFromIds", required = true)
    public String getOp() {
        return op;
    }

}