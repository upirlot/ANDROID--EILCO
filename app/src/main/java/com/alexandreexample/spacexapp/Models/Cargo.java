package com.alexandreexample.spacexapp.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Cargo implements Serializable {

    @SerializedName("solar_array")
    @Expose
    private Integer solarArray;
    @SerializedName("unpressurized_cargo")
    @Expose
    private Boolean unpressurizedCargo;

    public Integer getSolarArray() {
        return solarArray;
    }

    public Boolean getUnpressurizedCargo() {
        return unpressurizedCargo;
    }
}
