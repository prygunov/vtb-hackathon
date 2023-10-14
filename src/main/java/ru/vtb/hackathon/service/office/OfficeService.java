package ru.vtb.hackathon.service.office;

import ru.vtb.hackathon.dto.DirectionMode;
import ru.vtb.hackathon.dto.office.OfficeDto;

import java.util.List;

public interface OfficeService {

    List<OfficeDto> findAllOfficesAround(Double latitude, Double longitude, Double radius);

    List<OfficeDto> findNearOffices(Double latitude, Double longitude, Double radius, DirectionMode mode);
}
