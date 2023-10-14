
package ru.vtb.hackathon.model.dto.atm;

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

}
