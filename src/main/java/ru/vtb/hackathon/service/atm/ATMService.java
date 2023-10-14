package ru.vtb.hackathon.service.atm;

import ru.vtb.hackathon.entity.AtmEntity;

import java.util.List;

public interface ATMService {

    List<AtmEntity> findAllATMAround(Double latitude, Double longitude, Double radius);

}
