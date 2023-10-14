package ru.vtb.hackathon.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.vtb.hackathon.model.OfficeTime;

import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "office")
@NoArgsConstructor
public class OfficeEntity {

    @Id
    @GeneratedValue
    private UUID id;
    private String salePointName;
    private String addressString;
    private String status;

    private Double latitude;
    private Double longitude;

    public String address;
    public String rko;
    public String officeType;
    public String salePointFormat;
    public String suoAvailability;
    public String hasRamp;
    public String metroStation;
    //public int distance;TODO!
    public Boolean kep;
    public Boolean myBranch;
}
