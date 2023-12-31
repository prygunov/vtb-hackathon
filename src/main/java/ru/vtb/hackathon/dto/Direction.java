package ru.vtb.hackathon.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.vtb.hackathon.entity.GeoPosition;

@Data
@EqualsAndHashCode
public class Direction {

    private GeoPosition start;
    private GeoPosition end;

}
