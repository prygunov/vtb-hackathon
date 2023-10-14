package ru.vtb.hackathon.model.dto.atm.services;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class FeatureState {

    @JsonProperty("serviceCapability")
    @Enumerated(EnumType.ORDINAL)
    protected FeatureCapabilityState featureCapability;

    @JsonProperty("serviceActivity")
    @Enumerated(EnumType.ORDINAL)
    protected FeatureActivityState featureActivity;

}
