package main.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by orvillelim on 20/09/2017.
 */
public class PropertyIdListFromSuggestion extends AuthRequestBody implements RequestBody {


        @SerializedName("searchTerm")
        @Expose
        @ApiModelProperty(example = "nun", required = true)
        private String searchTerm;
        @SerializedName("suggestionTypes")
        @Expose
        @ApiModelProperty(example = "address,street,locality,postcode,councilArea,state,country", required = true)
        private String suggestionTypes;
        @SerializedName("includeUnits")
        @Expose
        @ApiModelProperty(example = "true", required = true)
        private String includeUnits;
        @SerializedName("limit")
        @Expose
        @ApiModelProperty(example = "100", required = true)
        private String limit;

        @Override
        @ApiModelProperty(example = "getPropertyIDListFromSuggestion", required = true)
        public String getOp() {
            return super.getOp();
        }

        public String getSearchTerm() {
            return searchTerm;
        }

        public void setSearchTerm(String searchTerm) {
            this.searchTerm = searchTerm;
        }

        public String getSuggestionTypes() {
            return suggestionTypes;
        }

        public void setSuggestionTypes(String suggestionTypes) {
            this.suggestionTypes = suggestionTypes;
        }

        public String getIncludeUnits() {
            return includeUnits;
        }

        public void setIncludeUnits(String includeUnits) {
            this.includeUnits = includeUnits;
        }

        public String getLimit() {
            return limit;
        }

        public void setLimit(String limit) {
            this.limit = limit;
        }

}
