package com.alexandreexample.spacexapp.Models;


import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Capsule implements Serializable {

    @SerializedName("capsule_serial")
    @Expose
    private String capsuleSerial;
    @SerializedName("capsule_id")
    @Expose
    private String capsuleId;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("original_launch")
    @Expose
    private Object originalLaunch;
    @SerializedName("original_launch_unix")
    @Expose
    private Object originalLaunchUnix;
    @SerializedName("missions")
    @Expose
    private List<Mission> missions = null;
    @SerializedName("landings")
    @Expose
    private Integer landings;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("details")
    @Expose
    private String details;
    @SerializedName("reuse_count")
    @Expose
    private Integer reuseCount;

    public String getCapsuleSerial() {
        return capsuleSerial;
    }

    public String getCapsuleId() {
        return capsuleId;
    }

    public String getStatus() {
        return status;
    }

    public Object getOriginalLaunch() {
        return originalLaunch;
    }

    public Object getOriginalLaunchUnix() {
        return originalLaunchUnix;
    }

    public List<Mission> getMissions() {
        return missions;
    }

    public Integer getLandings() {
        return landings;
    }

    public String getType() {
        return type;
    }

    public String getDetails() {
        return details;
    }

    public Integer getReuseCount() {
        return reuseCount;
    }
}