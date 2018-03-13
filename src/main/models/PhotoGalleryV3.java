package main.models;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by orvillelim on 20/09/2017.
 */
public class PhotoGalleryV3 extends AuthRequestBody implements RequestBody{

    @ApiModelProperty(example = "6403028", required = true)
    String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    @ApiModelProperty(example = "getPhotoGalleryV3", required = true)
    public String getOp() {
        return super.getOp();
    }
}
