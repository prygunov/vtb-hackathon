package ru.vtb.hackathon.model.dto.office;

import java.util.ArrayList;

public class OfficeDto {

    public String salePointName;
    public String address;
    public String status;
    public ArrayList<OpenHour> openHours;
    public String rko;
    public ArrayList<OpenHoursIndividual> openHoursIndividual;
    public String officeType;
    public String salePointFormat;
    public String suoAvailability;
    public String hasRamp;
    public double latitude;
    public double longitude;
    public String metroStation;

    public int distance;
    public int routeDuration;

    public Boolean kep;
    public Boolean myBranch;

}