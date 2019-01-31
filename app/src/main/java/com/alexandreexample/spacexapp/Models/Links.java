package com.alexandreexample.spacexapp.Models;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Links implements Serializable {

    @SerializedName("mission_patch")
    @Expose
    private String missionPatch;
    @SerializedName("mission_patch_small")
    @Expose
    private String missionPatchSmall;
    @SerializedName("article_link")
    @Expose
    private String articleLink;
    @SerializedName("wikipedia")
    @Expose
    private String wikipedia;
    @SerializedName("video_link")
    @Expose
    private String videoLink;
    @SerializedName("flickr_images")
    @Expose
    private List<Object> flickrImages = null;
    @SerializedName("presskit")
    @Expose
    private String presskit;

    public String getMissionPatch() {
        return missionPatch;
    }

    public String getMissionPatchSmall() {
        return missionPatchSmall;
    }

    public String getArticleLink() {
        return articleLink;
    }

    public String getWikipedia() {
        return wikipedia;
    }

    public String getVideoLink() {
        return videoLink;
    }

    public List<Object> getFlickrImages() {
        return flickrImages;
    }

    public String getPresskit() {
        return presskit;
    }

}