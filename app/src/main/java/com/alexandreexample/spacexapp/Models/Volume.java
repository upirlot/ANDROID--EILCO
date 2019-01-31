package com.alexandreexample.spacexapp.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Volume implements Serializable {

    @SerializedName("cubic_meters")
    @Expose
    private Integer cubicMeters;
    @SerializedName("cubic_feet")
    @Expose
    private Integer cubicFeet;

    public Integer getCubicMeters() {
        return cubicMeters;
    }

    public Integer getCubicFeet() {
        return cubicFeet;
    }
}
