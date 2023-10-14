package ru.vtb.hackathon.model.dto.feature;

import org.mapstruct.Mapper;
import ru.vtb.hackathon.entity.FeaturesEmbeddable;

@Mapper(componentModel = "spring")
public interface FeaturesMapper {

    Features dto(FeaturesEmbeddable featuresEmbeddable);
}
