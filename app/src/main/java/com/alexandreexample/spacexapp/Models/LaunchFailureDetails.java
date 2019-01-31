package com.alexandreexample.spacexapp.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class LaunchFailureDetails implements Serializable {

    @SerializedName("time")
    @Expose
    private Integer time;
    @SerializedName("altitude")
    @Expose
    private Integer altitude;
    @SerializedName("reason")
    @Expose
    private String reason;

    public Integer getTime() {
        return time;
    }

    public Integer getAltitude() {
        return altitude;
    }

    public String getReason() {
        return reason;
    }

}

