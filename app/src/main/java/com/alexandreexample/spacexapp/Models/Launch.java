package com.alexandreexample.spacexapp.Models;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Launch implements Serializable {

    @SerializedName("flight_number")
    @Expose
    private Integer flightNumber;
    @SerializedName("mission_name")
    @Expose
    private String missionName;
    @SerializedName("mission_id")
    @Expose
    private List<String> missionId = null;
    @SerializedName("upcoming")
    @Expose
    private Boolean upcoming;
    @SerializedName("launch_year")
    @Expose
    private String launchYear;
    @SerializedName("launch_date_unix")
    @Expose
    private Integer launchDateUnix;
    @SerializedName("launch_date_utc")
    @Expose
    private String launchDateUtc;
    @SerializedName("launch_date_local")
    @Expose
    private String launchDateLocal;
    @SerializedName("is_tentative")
    @Expose
    private Boolean isTentative;
    @SerializedName("tentative_max_precision")
    @Expose
    private String tentativeMaxPrecision;
    @SerializedName("tbd")
    @Expose
    private Boolean tbd;
    @SerializedName("rocket")
    @Expose
    private Rocket rocket;
    @SerializedName("ships")
    @Expose
    private List<String> ships = null;
    @SerializedName("telemetry")
    @Expose
    private LaunchSite launchSite;
    @SerializedName("launch_success")
    @Expose
    private Boolean launchSuccess;
    @SerializedName("launch_failure_details")
    @Expose
    private LaunchFailureDetails launchFailureDetails;
    @SerializedName("links")
    @Expose
    private Links links;
    @SerializedName("details")
    @Expose
    private String details;
    @SerializedName("static_fire_date_utc")
    @Expose
    private String staticFireDateUtc;
    @SerializedName("static_fire_date_unix")
    @Expose
    private Integer staticFireDateUnix;

    public Integer getFlightNumber() {
        return flightNumber;
    }

    public String getMissionName() {
        return missionName;
    }

    public List<String> getMissionId() {
        return missionId;
    }

    public Boolean getUpcoming() {
        return upcoming;
    }

    public String getLaunchYear() {
        return launchYear;
    }

    public Integer getLaunchDateUnix() {
        return launchDateUnix;
    }

    public String getLaunchDateUtc() {
        return launchDateUtc;
    }

    public String getLaunchDateLocal() {
        return launchDateLocal;
    }

    public Boolean getTentative() {
        return isTentative;
    }

    public String getTentativeMaxPrecision() {
        return tentativeMaxPrecision;
    }

    public Boolean getTbd() {
        return tbd;
    }

    public Rocket getRocket() {
        return rocket;
    }

    public List<String> getShips() {
        return ships;
    }

    public LaunchSite getLaunchSite() {
        return launchSite;
    }

    public Boolean getLaunchSuccess() {
        return launchSuccess;
    }

    public LaunchFailureDetails getLaunchFailureDetails() {
        return launchFailureDetails;
    }

    public Links getLinks() {
        return links;
    }

    public String getDetails() {
        return details;
    }

    public String getStaticFireDateUtc() {
        return staticFireDateUtc;
    }

    public Integer getStaticFireDateUnix() {
        return staticFireDateUnix;
    }
}