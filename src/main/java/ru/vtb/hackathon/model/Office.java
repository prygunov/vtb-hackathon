package ru.vtb.hackathon.model;

import lombok.Data;

@Data
public class Office {

    private String salePointName;
    private String addressString;
    private String status;
    private OfficeTime monday;
    private OfficeTime tuesday;
    private OfficeTime wednesday;
    private OfficeTime thursday;
    private OfficeTime friday;
    private OfficeTime saturday;
    private OfficeTime sunday;

}