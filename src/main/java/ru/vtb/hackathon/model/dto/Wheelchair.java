
package ru.vtb.hackathon.model;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Wheelchair {

    @SerializedName("serviceCapability")
    @Expose
    private String serviceCapability;
    @SerializedName("serviceActivity")
    @Expose
    private String serviceActivity;

    public String getServiceCapability() {
        return serviceCapability;
    }

    public void setServiceCapability(String serviceCapability) {
        this.serviceCapability = serviceCapability;
    }

    public String getServiceActivity() {
        return serviceActivity;
    }

    public void setServiceActivity(String serviceActivity) {
        this.serviceActivity = serviceActivity;
    }

}
