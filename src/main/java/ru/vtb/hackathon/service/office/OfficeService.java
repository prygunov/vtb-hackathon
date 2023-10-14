package ru.vtb.hackathon.service.office;

import ru.vtb.hackathon.entity.OfficeEntity;
import ru.vtb.hackathon.model.DirectionMode;
import ru.vtb.hackathon.model.dto.office.OfficeDto;

import java.util.List;

public interface OfficeService {

    List<OfficeDto> findAllOfficesAround(Double latitude, Double longitude, Double radius);

    List<OfficeDto> findNearOffices(Double latitude, Double longitude, Double radius, DirectionMode mode);
}
