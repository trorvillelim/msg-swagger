package main.models;

/**
 * Created by orvillelim on 14/09/2017.
 */

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Version")
@ApiModel(value = "Parameter Descriptions", description = "")
public class VersionRequestBody extends AuthRequestBody implements RequestBody {


    @ApiModelProperty(example = "getVersion", required = true)
    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }



}
