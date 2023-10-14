package ru.vtb.hackathon.dto.feature;

import lombok.Data;

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

    public FeatureState getFeatureState(Feature list) {
        return switch (list) {
            case WHEELCHAIR -> this.wheelchair;
            case BLIND -> this.blind;
            case NFC_FOR_BANK_CARDS -> this.nfcForBankCards;
            case QR_READ -> this.qrRead;
            case SUPPORTS_USD -> this.supportsUsd;
            case SUPPORTS_CHARGE_RUB -> this.supportsChargeRub;
            case SUPPORTS_EUR -> this.supportsEur;
            case SUPPORTS_RUB -> this.supportsRub;
        };
    }



}
