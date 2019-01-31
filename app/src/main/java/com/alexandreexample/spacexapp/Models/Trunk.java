package com.alexandreexample.spacexapp.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Trunk implements Serializable {

    @SerializedName("trunk_volume")
    @Expose
    private Volume trunkVolume;
    @SerializedName("cargo")
    @Expose
    private Cargo cargo;

    public Volume getTrunkVolume() {
        return trunkVolume;
    }

    public Cargo getCargo() {
        return cargo;
    }
}
