
package ru.vtb.hackathon.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import ru.vtb.hackathon.model.dto.atm.services.*;

@Data
@Embeddable
public class Features {

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "featureCapability", column = @Column(name = "wheelchair_feature_capability")),
            @AttributeOverride(name = "featureActivity", column = @Column(name = "wheelchair_feature_activity"))
    })
    private FeatureState wheelchair;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "featureCapability", column = @Column(name = "blind_feature_capability")),
            @AttributeOverride(name = "featureActivity", column = @Column(name = "blind_feature_activity"))
    })
    private FeatureState blind;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "featureCapability", column = @Column(name = "nfc_for_bank_cards_feature_capability")),
            @AttributeOverride(name = "featureActivity", column = @Column(name = "nfc_for_bank_cards_feature_activity"))
    })
    private FeatureState nfcForBankCards;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "featureCapability", column = @Column(name = "qr_read_feature_capability")),
            @AttributeOverride(name = "featureActivity", column = @Column(name = "qr_read_feature_activity"))
    })
    private FeatureState qrRead;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "featureCapability", column = @Column(name = "supports_usd_feature_capability")),
            @AttributeOverride(name = "featureActivity", column = @Column(name = "supports_usd_feature_activity"))
    })
    private FeatureState supportsUsd;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "featureCapability", column = @Column(name = "supports_charge_rub_feature_capability")),
            @AttributeOverride(name = "featureActivity", column = @Column(name = "supports_charge_rub_feature_activity"))
    })
    private FeatureState supportsChargeRub;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "featureCapability", column = @Column(name = "supports_eur_feature_capability")),
            @AttributeOverride(name = "featureActivity", column = @Column(name = "supports_eur_feature_activity"))
    })
    private FeatureState supportsEur;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "featureCapability", column = @Column(name = "supports_rub_feature_capability")),
            @AttributeOverride(name = "featureActivity", column = @Column(name = "supports_rub_feature_activity"))
    })
    private FeatureState supportsRub;

}
