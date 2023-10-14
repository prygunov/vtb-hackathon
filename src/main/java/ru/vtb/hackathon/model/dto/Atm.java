
package ru.vtb.hackathon.model.dto;

import lombok.Data;
import ru.vtb.hackathon.entity.AtmEntity;
import ru.vtb.hackathon.model.dto.feature.Features;

@Data
public class Atm {

    private String address;
    private Double latitude;
    private Double longitude;
    private Boolean allDay;
    private Features features;

    public Atm(AtmEntity atmEntity) {
        this.address = atmEntity.getAddress();
        this.latitude = atmEntity.getGeoPosition().getLatitude();
        this.longitude = atmEntity.getGeoPosition().getLongitude();
        this.allDay = atmEntity.getAllDay();
        this.features = new Features(atmEntity.getFeaturesEmbeddable());
    }
}
