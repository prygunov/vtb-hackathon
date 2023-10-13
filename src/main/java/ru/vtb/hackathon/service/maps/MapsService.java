package ru.vtb.hackathon.service.maps;

import ru.vtb.hackathon.entity.ATMEntity;

import java.util.List;

public interface MapsService {

    List<ATMEntity> findATMAllAround(Double latitude, Double longitude);

}
