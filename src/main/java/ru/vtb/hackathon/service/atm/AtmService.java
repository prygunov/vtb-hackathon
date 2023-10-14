package ru.vtb.hackathon.service.atm;

import ru.vtb.hackathon.dto.atm.AtmDto;
import ru.vtb.hackathon.dto.feature.Feature;

import java.util.List;
import java.util.Map;

public interface AtmService {

    List<AtmDto> findAllAtmAround(Double latitude, Double longitude, Double radius);

    List<AtmDto> filterByFeatures(List<AtmDto> atms, Map<Feature, Boolean> features);

}
