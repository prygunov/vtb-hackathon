
package ru.vtb.hackathon.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ru.vtb.hackathon.model.Features;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "atm")
public class AtmEntity {

    @Id
    @GeneratedValue
    private UUID id;
    private String address;
    private Double latitude;
    private Double longitude;
    private Boolean allDay;
    @Embedded
    @JsonProperty("services")
    private Features features;

}
