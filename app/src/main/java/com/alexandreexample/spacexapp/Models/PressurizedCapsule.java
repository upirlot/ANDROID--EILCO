package com.alexandreexample.spacexapp.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class PressurizedCapsule implements Serializable {

    @SerializedName("payload_volume")
    @Expose
    private Volume payloadVolume;

    public Volume getPayloadVolume() {
        return payloadVolume;
    }
}
