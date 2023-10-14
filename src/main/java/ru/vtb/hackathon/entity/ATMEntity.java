
package ru.vtb.hackathon.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;
import ru.vtb.hackathon.model.Features;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "atm")
public class ATMEntity {

    @Id
    @GeneratedValue
    private UUID id;
    private String address;
    private Boolean allDay;

    @Embedded
    private GeoPosition geoPosition;
    
    
    @Embedded
    @JsonProperty("services")
    private Features features;

}
