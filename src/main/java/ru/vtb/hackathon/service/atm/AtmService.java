package ru.vtb.hackathon.service.atm;

import ru.vtb.hackathon.entity.AtmEntity;
import ru.vtb.hackathon.model.dto.atm.Atm;
import ru.vtb.hackathon.model.dto.feature.Feature;
import ru.vtb.hackathon.model.dto.feature.FeatureState;

import java.util.List;
import java.util.Map;

public interface AtmService {

    List<Atm> findAllAtmAround(Double latitude, Double longitude, Double radius);

    List<Atm> FilterByFeatures(List<Atm> atms, Map<Feature, Boolean> features);

}
