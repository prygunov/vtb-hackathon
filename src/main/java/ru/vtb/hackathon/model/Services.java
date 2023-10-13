
package ru.vtb.hackathon.model;

import ru.vtb.hackathon.model.dto.Blind;

public class Services {

    private Wheelchair wheelchair;
    private Blind blind;
    private NfcForBankCards nfcForBankCards;
    private QrRead qrRead;
    private SupportsUsd supportsUsd;
    private SupportsChargeRub supportsChargeRub;
    private SupportsEur supportsEur;
    private SupportsRub supportsRub;

    public Wheelchair getWheelchair() {
        return wheelchair;
    }

    public void setWheelchair(Wheelchair wheelchair) {
        this.wheelchair = wheelchair;
    }

    public Blind getBlind() {
        return blind;
    }

    public void setBlind(Blind blind) {
        this.blind = blind;
    }

    public NfcForBankCards getNfcForBankCards() {
        return nfcForBankCards;
    }

    public void setNfcForBankCards(NfcForBankCards nfcForBankCards) {
        this.nfcForBankCards = nfcForBankCards;
    }

    public QrRead getQrRead() {
        return qrRead;
    }

    public void setQrRead(QrRead qrRead) {
        this.qrRead = qrRead;
    }

    public SupportsUsd getSupportsUsd() {
        return supportsUsd;
    }

    public void setSupportsUsd(SupportsUsd supportsUsd) {
        this.supportsUsd = supportsUsd;
    }

    public SupportsChargeRub getSupportsChargeRub() {
        return supportsChargeRub;
    }

    public void setSupportsChargeRub(SupportsChargeRub supportsChargeRub) {
        this.supportsChargeRub = supportsChargeRub;
    }

    public SupportsEur getSupportsEur() {
        return supportsEur;
    }

    public void setSupportsEur(SupportsEur supportsEur) {
        this.supportsEur = supportsEur;
    }

    public SupportsRub getSupportsRub() {
        return supportsRub;
    }

    public void setSupportsRub(SupportsRub supportsRub) {
        this.supportsRub = supportsRub;
    }

}
