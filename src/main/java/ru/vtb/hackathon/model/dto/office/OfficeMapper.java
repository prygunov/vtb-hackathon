package ru.vtb.hackathon.model.dto.office;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.vtb.hackathon.entity.OfficeEntity;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface OfficeMapper {

    @Mapping(target = "latitude", source = "entity.geoPosition.latitude")
    @Mapping(target = "longitude", source = "entity.geoPosition.longitude")
    @Mapping(target = "distance", source = "distance")
    @Mapping(target = "routeDuration", source = "routeDuration")
    OfficeDto dto(OfficeEntity entity, double distance, double routeDuration);

    @Mapping(target = "latitude", source = "entity.geoPosition.latitude")
    @Mapping(target = "longitude", source = "entity.geoPosition.longitude")
    @Mapping(target = "distance", ignore = true)
    @Mapping(target = "routeDuration", ignore = true)
    OfficeDto dto(OfficeEntity entity);

    ArrayList<OfficeDto> dto(List<OfficeEntity> entities, double distance, double routeDuration);

    ArrayList<OfficeDto> dto(List<OfficeEntity> entities);
}
