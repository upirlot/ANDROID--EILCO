package com.alexandreexample.spacexapp.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Thruster implements Serializable {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("amount")
    @Expose
    private Integer amount;
    @SerializedName("pods")
    @Expose
    private Integer pods;
    @SerializedName("fuel_1")
    @Expose
    private String fuel1;
    @SerializedName("fuel_2")
    @Expose
    private String fuel2;
    @SerializedName("thrust")
    @Expose
    private Thrust thrust;

    public String getType() {
        return type;
    }

    public Integer getAmount() {
        return amount;
    }

    public Integer getPods() {
        return pods;
    }

    public String getFuel1() {
        return fuel1;
    }

    public String getFuel2() {
        return fuel2;
    }

    public Thrust getThrust() {
        return thrust;
    }
}
