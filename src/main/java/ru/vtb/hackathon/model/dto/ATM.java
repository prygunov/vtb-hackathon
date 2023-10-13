
package ru.vtb.hackathon.model.dto;

import ru.vtb.hackathon.model.Services;

public class ATM {

    private String address;
    private Double latitude;
    private Double longitude;
    private Boolean allDay;
    private Services services;

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


}
