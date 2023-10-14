
package ru.vtb.hackathon.dto.atm;

import lombok.Data;
import ru.vtb.hackathon.dto.feature.Features;

@Data
public class AtmDto {

    private String address;
    private Double latitude;
    private Double longitude;
    private Boolean allDay;
    private Features features;

}
