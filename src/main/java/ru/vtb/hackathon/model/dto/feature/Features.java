package ru.vtb.hackathon.model.dto.feature;

import lombok.Data;
import ru.vtb.hackathon.entity.FeaturesEmbeddable;

@Data
public class Features {
    private FeatureState wheelchair;
    private FeatureState blind;
    private FeatureState nfcForBankCards;
    private FeatureState qrRead;
    private FeatureState supportsUsd;
    private FeatureState supportsChargeRub;
    private FeatureState supportsEur;
    private FeatureState supportsRub;

}
