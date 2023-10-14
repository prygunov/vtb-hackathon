package ru.vtb.hackathon.service.atm;

import ru.vtb.hackathon.entity.AtmEntity;

import java.util.List;

public interface AtmService {

    List<AtmEntity> findAllAtmAround(Double latitude, Double longitude, Double radius);

}
