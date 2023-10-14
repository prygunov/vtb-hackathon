package ru.vtb.hackathon.model.dto.atm;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.vtb.hackathon.entity.AtmEntity;
import ru.vtb.hackathon.entity.FeaturesEmbeddable;
import ru.vtb.hackathon.model.dto.feature.Features;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AtmMapper {

    @Mapping(target = "latitude", source = "entity.geoPosition.latitude")
    @Mapping(target = "longitude", source = "entity.geoPosition.longitude")
    @Mapping(target = "features", source = "entity.featuresEmbeddable")
    Atm dto(AtmEntity entity);

    List<Atm> dto(List<AtmEntity> entities);
}
