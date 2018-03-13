
package main.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

public class MobileProperty  extends AuthRequestBody implements RequestBody {

    @SerializedName("maxResult")
    @Expose
    private String maxResult;
    @SerializedName("parking")
    @Expose
    private String parking;
    @SerializedName("other")
    @Expose
    private boolean other;
    @SerializedName("commercial")
    @Expose
    private boolean commercial;
    @SerializedName("pageNumber")
    @Expose
    private int pageNumber;
    @ApiModelProperty(example = "6", required = true)
    @SerializedName("pageSize")
    @Expose
    private int pageSize;
    @SerializedName("appCode")
    @Expose
    private String appCode;
    @SerializedName("house")
    @Expose
    private boolean house;
    @SerializedName("landSize")
    @Expose
    private int landSize;
    @SerializedName("land")
    @Expose
    private boolean land;
    @SerializedName("sortBy")
    @Expose
    private int sortBy;
    @SerializedName("others")
    @Expose
    private boolean others;
    @SerializedName("forSale")
    @Expose
    private boolean forSale;
    @SerializedName("showAdditionalDataElements")
    @Expose
    private boolean showAdditionalDataElements;
    @SerializedName("bathrooms")
    @Expose
    private int bathrooms;
    @SerializedName("recentlySold")
    @Expose
    private boolean recentlySold;
    @SerializedName("forRent")
    @Expose
    private boolean forRent;
    @SerializedName("bedrooms")
    @Expose
    private int bedrooms;
    @SerializedName("searchString")
    @Expose
    private String searchString;
    @SerializedName("unit")
    @Expose
    private boolean unit;
    @SerializedName("sortOrder")
    @Expose
    private String sortOrder;
    @SerializedName("category")
    @Expose
    private String category;


    @ApiModelProperty(example = "getMobileProperty", required = true)
    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }


    public String getMaxResult() {
        return maxResult;
    }

    public void setMaxResult(String maxResult) {
        this.maxResult = maxResult;
    }

    public MobileProperty withMaxResult(String maxResult) {
        this.maxResult = maxResult;
        return this;
    }

    public String getParking() {
        return parking;
    }

    public void setParking(String parking) {
        this.parking = parking;
    }

    public MobileProperty withParking(String parking) {
        this.parking = parking;
        return this;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public MobileProperty withLoc(String loc) {
        this.loc = loc;
        return this;
    }

    public boolean isOther() {
        return other;
    }

    public void setOther(boolean other) {
        this.other = other;
    }

    public MobileProperty withOther(boolean other) {
        this.other = other;
        return this;
    }

    public boolean isCommercial() {
        return commercial;
    }

    public void setCommercial(boolean commercial) {
        this.commercial = commercial;
    }

    public MobileProperty withCommercial(boolean commercial) {
        this.commercial = commercial;
        return this;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public MobileProperty withPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
        return this;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public MobileProperty withPageSize(int pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public MobileProperty withAppCode(String appCode) {
        this.appCode = appCode;
        return this;
    }

    public boolean isHouse() {
        return house;
    }

    public void setHouse(boolean house) {
        this.house = house;
    }

    public MobileProperty withHouse(boolean house) {
        this.house = house;
        return this;
    }

    public int getLandSize() {
        return landSize;
    }

    public void setLandSize(int landSize) {
        this.landSize = landSize;
    }

    public MobileProperty withLandSize(int landSize) {
        this.landSize = landSize;
        return this;
    }

    public boolean isLand() {
        return land;
    }

    public void setLand(boolean land) {
        this.land = land;
    }

    public MobileProperty withLand(boolean land) {
        this.land = land;
        return this;
    }

    public int getSortBy() {
        return sortBy;
    }

    public void setSortBy(int sortBy) {
        this.sortBy = sortBy;
    }

    public MobileProperty withSortBy(int sortBy) {
        this.sortBy = sortBy;
        return this;
    }

    public boolean isOthers() {
        return others;
    }

    public void setOthers(boolean others) {
        this.others = others;
    }

    public MobileProperty withOthers(boolean others) {
        this.others = others;
        return this;
    }

    public boolean isForSale() {
        return forSale;
    }

    public void setForSale(boolean forSale) {
        this.forSale = forSale;
    }

    public MobileProperty withForSale(boolean forSale) {
        this.forSale = forSale;
        return this;
    }

    public boolean isShowAdditionalDataElements() {
        return showAdditionalDataElements;
    }

    public void setShowAdditionalDataElements(boolean showAdditionalDataElements) {
        this.showAdditionalDataElements = showAdditionalDataElements;
    }

    public MobileProperty withShowAdditionalDataElements(boolean showAdditionalDataElements) {
        this.showAdditionalDataElements = showAdditionalDataElements;
        return this;
    }

    public int getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(int bathrooms) {
        this.bathrooms = bathrooms;
    }

    public MobileProperty withBathrooms(int bathrooms) {
        this.bathrooms = bathrooms;
        return this;
    }

    public boolean isRecentlySold() {
        return recentlySold;
    }

    public void setRecentlySold(boolean recentlySold) {
        this.recentlySold = recentlySold;
    }

    public MobileProperty withRecentlySold(boolean recentlySold) {
        this.recentlySold = recentlySold;
        return this;
    }

    public boolean isForRent() {
        return forRent;
    }

    public void setForRent(boolean forRent) {
        this.forRent = forRent;
    }

    public MobileProperty withForRent(boolean forRent) {
        this.forRent = forRent;
        return this;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }

    public MobileProperty withBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
        return this;
    }

    public String getSearchString() {
        return searchString;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }

    public MobileProperty withSearchString(String searchString) {
        this.searchString = searchString;
        return this;
    }

    public boolean isUnit() {
        return unit;
    }

    public void setUnit(boolean unit) {
        this.unit = unit;
    }

    public MobileProperty withUnit(boolean unit) {
        this.unit = unit;
        return this;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    public MobileProperty withSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public MobileProperty withCategory(String category) {
        this.category = category;
        return this;
    }

}