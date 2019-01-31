package com.alexandreexample.spacexapp.Models;


import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Dragon implements Serializable {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("active")
    @Expose
    private Boolean active;
    @SerializedName("crew_capacity")
    @Expose
    private Integer crewCapacity;
    @SerializedName("sidewall_angle_deg")
    @Expose
    private Integer sidewallAngleDeg;
    @SerializedName("orbit_duration_yr")
    @Expose
    private Integer orbitDurationYr;
    @SerializedName("dry_mass_kg")
    @Expose
    private Integer dryMassKg;
    @SerializedName("dry_mass_lb")
    @Expose
    private Integer dryMassLb;
    @SerializedName("first_flight")
    @Expose
    private String firstFlight;
    @SerializedName("heat_shield")
    @Expose
    private HeatShield heatShield;
    @SerializedName("thrusters")
    @Expose
    private List<Thruster> thrusters = null;
    @SerializedName("launch_payload_mass")
    @Expose
    private Mass launchPayloadMass;
    @SerializedName("launch_payload_vol")
    @Expose
    private Volume launchPayloadVol;
    @SerializedName("return_payload_mass")
    @Expose
    private Mass returnPayloadMass;
    @SerializedName("return_payload_vol")
    @Expose
    private Volume returnPayloadVol;
    @SerializedName("pressurized_capsule")
    @Expose
    private PressurizedCapsule pressurizedCapsule;
    @SerializedName("trunk")
    @Expose
    private Trunk trunk;
    @SerializedName("height_w_trunk")
    @Expose
    private Height heightWTrunk;
    @SerializedName("diameter")
    @Expose
    private Diameter diameter;
    @SerializedName("flickr_images")
    @Expose
    private List<String> flickrImages = null;
    @SerializedName("wikipedia")
    @Expose
    private String wikipedia;
    @SerializedName("description")
    @Expose
    private String description;
}
