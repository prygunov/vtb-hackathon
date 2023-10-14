package ru.vtb.hackathon.service.office;

import ru.vtb.hackathon.entity.OfficeEntity;
import ru.vtb.hackathon.model.DirectionMode;

import java.util.List;

public interface OfficeService {

    List<OfficeEntity> findAllOfficesAround(Double latitude, Double longitude, Double radius);

    List<OfficeEntity> findNearOffices(Double latitude, Double longitude, Double radius);

    List<OfficeEntity> findNearOffices(Double latitude, Double longitude, Double radius, DirectionMode mode);
}
