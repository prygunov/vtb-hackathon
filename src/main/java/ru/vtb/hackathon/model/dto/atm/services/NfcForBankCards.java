package ru.vtb.hackathon.model.dto.atm.services;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.vtb.hackathon.model.dto.atm.services.AtmService;

@EqualsAndHashCode(callSuper = true)
@Data
public class NfcForBankCards extends AtmService {}