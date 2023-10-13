
package ru.vtb.hackathon.model;

import ru.vtb.hackathon.model.dto.Service;

import java.util.EnumMap;

public class ATM {

    private String address;
    private Double latitude;
    private Double longitude;
    private Boolean allDay;
    private EnumMap<Service, Services> services;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Boolean getAllDay() {
        return allDay;
    }

    public void setAllDay(Boolean allDay) {
        this.allDay = allDay;
    }

    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
    }

}
