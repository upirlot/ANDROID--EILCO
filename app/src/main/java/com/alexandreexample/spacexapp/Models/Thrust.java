package com.alexandreexample.spacexapp.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Thrust implements Serializable {

    @SerializedName("kN")
    @Expose
    private Integer kN;
    @SerializedName("lbf")
    @Expose
    private Integer lbf;

    public Integer getkN() {
        return kN;
    }

    public Integer getLbf() {
        return lbf;
    }
}
