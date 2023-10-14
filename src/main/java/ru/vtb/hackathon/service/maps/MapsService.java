package ru.vtb.hackathon.service.maps;

import ru.vtb.hackathon.entity.AtmEntity;

import java.util.List;

public interface MapsService {

    List<AtmEntity> findATMAllAround(Double latitude, Double longitude);

}
