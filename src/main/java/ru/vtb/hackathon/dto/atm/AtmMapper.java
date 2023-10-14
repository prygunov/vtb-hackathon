package ru.vtb.hackathon.dto.atm;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.vtb.hackathon.entity.AtmEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AtmMapper {

    @Mapping(target = "latitude", source = "entity.geoPosition.latitude")
    @Mapping(target = "longitude", source = "entity.geoPosition.longitude")
    @Mapping(target = "features", source = "entity.featuresEmbeddable")
    AtmDto dto(AtmEntity entity);

    List<AtmDto> dto(List<AtmEntity> entities);
}
