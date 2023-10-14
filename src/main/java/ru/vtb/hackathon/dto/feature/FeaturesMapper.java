package ru.vtb.hackathon.dto.feature;

import org.mapstruct.Mapper;
import ru.vtb.hackathon.entity.FeaturesEmbeddable;

@Mapper(componentModel = "spring")
public interface FeaturesMapper {

    Features dto(FeaturesEmbeddable featuresEmbeddable);
}
