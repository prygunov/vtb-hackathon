
package ru.vtb.hackathon.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import jakarta.persistence.*;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

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

    @JsonUnwrapped
    @Embedded
    private GeoPosition geoPosition;

    @OneToMany
    Set<CommentEntity> comments;
    
    @Embedded
    @JsonProperty("services")
    private FeaturesEmbeddable featuresEmbeddable;

}
