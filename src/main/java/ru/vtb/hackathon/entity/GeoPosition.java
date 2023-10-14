package ru.vtb.hackathon.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class GeoPosition implements GeoObject {
    private Double latitude;
    private Double longitude;

    @Override
    public GeoPosition getGeoPosition() {
        return this;
    }
}
