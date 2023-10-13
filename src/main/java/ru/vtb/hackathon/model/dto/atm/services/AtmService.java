package ru.vtb.hackathon.model.dto.atm.services;

import lombok.Data;

@Data
public class AtmService {

    protected ServiceCapabilityState serviceCapability;
    protected ServiceActivityState serviceActivity;

}
