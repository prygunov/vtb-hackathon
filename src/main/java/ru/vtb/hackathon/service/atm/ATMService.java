package ru.vtb.hackathon.service.atm;

import ru.vtb.hackathon.entity.ATMEntity;

import java.util.List;

public interface ATMService {

    List<ATMEntity> findAllATMAround(Double latitude, Double longitude, Double radius);

}
