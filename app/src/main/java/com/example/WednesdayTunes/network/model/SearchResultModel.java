package com.example.WednesdayTunes.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SearchResultModel {

    @SerializedName("resultCount")
    @Expose
    private int resultCount;
    @SerializedName("results")
    @Expose
    private List<ResultModel> resultModels = null;

    public int getResultCount() {
        return resultCount;
    }

    public void setResultCount(int resultCount) {
        this.resultCount = resultCount;
    }

    public List<ResultModel> getResultModels() {
        return resultModels;
    }

    public void setResultModels(List<ResultModel> resultModels) {
        this.resultModels = resultModels;
    }

}
