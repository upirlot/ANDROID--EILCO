package com.alexandreexample.spacexapp.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Mass implements Serializable {

    @SerializedName("kg")
    @Expose
    private float kg;

    @SerializedName("lb")
    @Expose
    private float lb;

    public float getKg() {
        return kg;
    }

    public float getLb() {
        return lb;
    }
}
