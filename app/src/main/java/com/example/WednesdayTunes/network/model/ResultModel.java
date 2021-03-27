package com.example.WednesdayTunes.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResultModel {

    @SerializedName("artistName")
    @Expose
    private String artistName;
    @SerializedName("trackName")
    @Expose
    private String trackName;
    @SerializedName("previewUrl")
    @Expose
    private String previewUrl;
    @SerializedName("artworkUrl100")
    @Expose
    private String artworkUrl100;

    public String getArtistName() {
        return artistName;
    }

    public String getTrackName() {
        return trackName;
    }

    public String getPreviewUrl() {
        return previewUrl;
    }

    public String getArtworkUrl100() {
        return artworkUrl100;
    }

}