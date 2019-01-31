package com.alexandreexample.spacexapp.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class LaunchSite implements Serializable {

    @SerializedName("site_id")
    @Expose
    private String siteId;
    @SerializedName("site_name")
    @Expose
    private String siteName;
    @SerializedName("site_name_long")
    @Expose
    private String siteNameLong;

    public String getSiteId() {
        return siteId;
    }

    public String getSiteName() {
        return siteName;
    }

    public String getSiteNameLong() {
        return siteNameLong;
    }

}
