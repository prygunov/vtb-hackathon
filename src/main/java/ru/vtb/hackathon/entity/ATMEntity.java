
package ru.vtb.hackathon.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;
import ru.vtb.hackathon.model.Services;

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
    private Double latitude;
    private Double longitude;
    private Boolean allDay;
    //private Services services;

}
