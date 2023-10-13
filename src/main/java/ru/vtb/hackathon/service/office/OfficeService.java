package ru.vtb.hackathon.service.office;

import ru.vtb.hackathon.entity.ATMEntity;

import java.util.List;

public interface OfficeService {

    List<ATMEntity> findAllATMAround(Double latitude, Double longitude, Double radius);

}
