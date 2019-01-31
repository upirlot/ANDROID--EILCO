package com.alexandreexample.spacexapp.Models;


import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Core implements Serializable {

    @SerializedName("core_serial")
    @Expose
    private String coreSerial;
    @SerializedName("block")
    @Expose
    private Integer block;
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
    @SerializedName("reuse_count")
    @Expose
    private Integer reuseCount;
    @SerializedName("rtls_attempts")
    @Expose
    private Integer rtlsAttempts;
    @SerializedName("rtls_landings")
    @Expose
    private Integer rtlsLandings;
    @SerializedName("asds_attempts")
    @Expose
    private Integer asdsAttempts;
    @SerializedName("asds_landings")
    @Expose
    private Integer asdsLandings;
    @SerializedName("water_landing")
    @Expose
    private Boolean waterLanding;
    @SerializedName("details")
    @Expose
    private String details;

    public String getCoreSerial() {
        return coreSerial;
    }

    public Integer getBlock() {
        return block;
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

    public Integer getReuseCount() {
        return reuseCount;
    }

    public Integer getRtlsAttempts() {
        return rtlsAttempts;
    }

    public Integer getRtlsLandings() {
        return rtlsLandings;
    }

    public Integer getAsdsAttempts() {
        return asdsAttempts;
    }

    public Integer getAsdsLandings() {
        return asdsLandings;
    }

    public Boolean getWaterLanding() {
        return waterLanding;
    }

    public String getDetails() {
        return details;
    }
}
