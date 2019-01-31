package com.alexandreexample.spacexapp.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Rocket implements Serializable {

    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("active")
    @Expose
    private Boolean active;

    @SerializedName("stages")
    @Expose
    private Integer stages;

    @SerializedName("boosters")
    @Expose
    private Integer boosters;

    @SerializedName("cost_per_launch")
    @Expose
    private Integer costPerLaunch;

    @SerializedName("success_rate_pct")
    @Expose
    private Integer successRatePct;

    @SerializedName("first_flight")
    @Expose
    private String firstFlight;

    @SerializedName("country")
    @Expose
    private String country;

    @SerializedName("company")
    @Expose
    private String company;


    @SerializedName("height")
    @Expose
    private Height height;

    @SerializedName("diameter")
    @Expose
    private Diameter diameter;

    @SerializedName("mass")
    @Expose
    private Mass mass;

    @SerializedName("flickr_images")
    @Expose
    private List<String> flickrImages = null;

    @SerializedName("wikipedia")
    @Expose
    private String wikipedia;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("rocket_id")
    @Expose
    private String rocketId;

    @SerializedName("rocket_name")
    @Expose
    private String rocketName;

    @SerializedName("rocket_type")
    @Expose
    private String rocketType;

    public Integer getId() {
        return id;
    }

    public Boolean getActive() {
        return active;
    }

    public Integer getStages() {
        return stages;
    }

    public Integer getBoosters() {
        return boosters;
    }

    public Integer getCostPerLaunch() {
        return costPerLaunch;
    }

    public Integer getSuccessRatePct() {
        return successRatePct;
    }

    public String getFirstFlight() {
        return firstFlight;
    }

    public String getCountry() {
        return country;
    }

    public String getCompany() {
        return company;
    }

    public Height getHeight() {
        return height;
    }

    public Diameter getDiameter() {
        return diameter;
    }

    public Mass getMass() {
        return mass;
    }

    public List<String> getFlickrImages() {
        return flickrImages;
    }

    public String getWikipedia() {
        return wikipedia;
    }

    public String getDescription() {
        return description;
    }

    public String getRocketId() {
        return rocketId;
    }

    public String getRocketName() {
        return rocketName;
    }

    public String getRocketType() {
        return rocketType;
    }
}
