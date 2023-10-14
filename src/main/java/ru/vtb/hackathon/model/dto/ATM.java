
package ru.vtb.hackathon.model.dto;

import lombok.Data;
import ru.vtb.hackathon.model.Features;

@Data
public class ATM {

    private String address;
    private Double latitude;
    private Double longitude;
    private Boolean allDay;
    private Features features;

}
