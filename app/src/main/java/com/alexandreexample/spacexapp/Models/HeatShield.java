package com.alexandreexample.spacexapp.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class HeatShield implements Serializable {

    @SerializedName("material")
    @Expose
    private String material;
    @SerializedName("size_meters")
    @Expose
    private Double sizeMeters;
    @SerializedName("temp_degrees")
    @Expose
    private Integer tempDegrees;
    @SerializedName("dev_partner")
    @Expose
    private String devPartner;

    public String getMaterial() {
        return material;
    }

    public Double getSizeMeters() {
        return sizeMeters;
    }

    public Integer getTempDegrees() {
        return tempDegrees;
    }

    public String getDevPartner() {
        return devPartner;
    }
}
