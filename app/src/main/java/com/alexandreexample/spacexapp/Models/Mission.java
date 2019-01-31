package com.alexandreexample.spacexapp.Models;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Mission implements Serializable {

    @SerializedName("mission_name")
    @Expose
    private String missionName;
    @SerializedName("mission_id")
    @Expose
    private String missionId;
    @SerializedName("manufacturers")
    @Expose
    private List<String> manufacturers = null;
    @SerializedName("payload_ids")
    @Expose
    private List<String> payloadIds = null;
    @SerializedName("wikipedia")
    @Expose
    private String wikipedia;
    @SerializedName("website")
    @Expose
    private String website;
    @SerializedName("twitter")
    @Expose
    private String twitter;
    @SerializedName("description")
    @Expose
    private String description;

    public String getMissionName() {
        return missionName;
    }

    public String getMissionId() {
        return missionId;
    }

    public List<String> getManufacturers() {
        return manufacturers;
    }

    public List<String> getPayloadIds() {
        return payloadIds;
    }

    public String getWikipedia() {
        return wikipedia;
    }

    public String getWebsite() {
        return website;
    }

    public String getTwitter() {
        return twitter;
    }

    public String getDescription() {
        return description;
    }
}
