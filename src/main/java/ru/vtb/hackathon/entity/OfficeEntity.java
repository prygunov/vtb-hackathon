package ru.vtb.hackathon.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.mapstruct.Mapping;

import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "office")
@NoArgsConstructor
public class OfficeEntity implements GeoObject{

    @Id
    @GeneratedValue
    private UUID id;
    private String salePointName;
    private String address;
    private String status;

    @JsonUnwrapped
    @Embedded
    private GeoPosition geoPosition;

    public String officeType;
    public String salePointFormat;
    public String suoAvailability;
    //public Boolean hasRamp;
    public String metroStation;
    private Double distance;

    //public Boolean rko;
    public Boolean kep;
    public Boolean myBranch;

    @JsonIgnore
    public void setDistance(Double distance) {
        this.distance = distance;
    }
}
