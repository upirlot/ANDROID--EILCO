package com.alexandreexample.spacexapp.Models;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Ship implements Serializable {

    @SerializedName("ship_id")
    @Expose
    private String shipId;
    @SerializedName("ship_name")
    @Expose
    private String shipName;
    @SerializedName("ship_model")
    @Expose
    private Object shipModel;
    @SerializedName("ship_type")
    @Expose
    private String shipType;
    @SerializedName("roles")
    @Expose
    private List<String> roles = null;
    @SerializedName("active")
    @Expose
    private Boolean active;
    @SerializedName("imo")
    @Expose
    private Integer imo;
    @SerializedName("mmsi")
    @Expose
    private Integer mmsi;
    @SerializedName("abs")
    @Expose
    private Object abs;
    @SerializedName("class")
    @Expose
    private Object _class;
    @SerializedName("weight_lbs")
    @Expose
    private Object weightLbs;
    @SerializedName("weight_kg")
    @Expose
    private Object weightKg;
    @SerializedName("year_built")
    @Expose
    private Integer yearBuilt;
    @SerializedName("home_port")
    @Expose
    private String homePort;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("speed_kn")
    @Expose
    private Double speedKn;
    @SerializedName("course_deg")
    @Expose
    private Object courseDeg;
    @SerializedName("position")
    @Expose
    private Position position;
    @SerializedName("successful_landings")
    @Expose
    private Object successfulLandings;
    @SerializedName("attempted_landings")
    @Expose
    private Object attemptedLandings;
    @SerializedName("missions")
    @Expose
    private List<Mission> missions = null;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("image")
    @Expose
    private String image;

    public String getShipId() {
        return shipId;
    }

    public String getShipName() {
        return shipName;
    }

    public Object getShipModel() {
        return shipModel;
    }

    public String getShipType() {
        return shipType;
    }

    public List<String> getRoles() {
        return roles;
    }

    public Boolean getActive() {
        return active;
    }

    public Integer getImo() {
        return imo;
    }

    public Integer getMmsi() {
        return mmsi;
    }

    public Object getAbs() {
        return abs;
    }

    public Object get_class() {
        return _class;
    }

    public Object getWeightLbs() {
        return weightLbs;
    }

    public Object getWeightKg() {
        return weightKg;
    }

    public Integer getYearBuilt() {
        return yearBuilt;
    }

    public String getHomePort() {
        return homePort;
    }

    public String getStatus() {
        return status;
    }

    public Double getSpeedKn() {
        return speedKn;
    }

    public Object getCourseDeg() {
        return courseDeg;
    }

    public Position getPosition() {
        return position;
    }

    public Object getSuccessfulLandings() {
        return successfulLandings;
    }

    public Object getAttemptedLandings() {
        return attemptedLandings;
    }

    public List<Mission> getMissions() {
        return missions;
    }

    public String getUrl() {
        return url;
    }

    public String getImage() {
        return image;
    }
}
