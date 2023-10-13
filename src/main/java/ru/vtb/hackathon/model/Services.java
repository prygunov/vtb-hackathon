
package ru.vtb.hackathon.model;

import lombok.Data;
import ru.vtb.hackathon.model.dto.AtmServices.*;

@Data
public class Services {

    private Wheelchair wheelchair;
    private Blind blind;
    private NfcForBankCards nfcForBankCards;
    private QrRead qrRead;
    private SupportsUsd supportsUsd;
    private SupportsChargeRub supportsChargeRub;
    private SupportsEur supportsEur;
    private SupportsRub supportsRub;

}
