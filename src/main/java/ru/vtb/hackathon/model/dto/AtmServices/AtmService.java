package ru.vtb.hackathon.model.dto.AtmServices;

import lombok.Data;

@Data
public class AtmService {

    protected ServiceCapabilityState serviceCapability;
    protected ServiceActivityState serviceActivity;

}
