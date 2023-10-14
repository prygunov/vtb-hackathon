
package ru.vtb.hackathon.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.*;
import ru.vtb.hackathon.model.Features;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "atm")
@Getter
@Setter
@NoArgsConstructor
public class AtmEntity implements GeoObject, Commentable {

    @Id
    @GeneratedValue
    protected UUID id;

    private String address;
    private Boolean allDay;

    @Embedded
    private GeoPosition geoPosition;

    @OneToMany
    Set<CommentEntity> comments;
    
    
    @Embedded
    @JsonProperty("services")
    private Features features;

}
