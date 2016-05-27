package com.cactuscode;

/**
 * Created by Dngy on 25.5.2016..
 */
public class PaymentInformation {

    private String PmtInfId;
    private String PmtMtd;
    private String Nm;
    private String IBAN;

    public String getPmtInfId() {
        return PmtInfId;
    }

    public void setPmtInfId(String pmtInfId) {
        PmtInfId = pmtInfId;
    }

    public String getPmtMtd() {
        return PmtMtd;
    }

    public void setPmtMtd(String pmtMtd) {
        PmtMtd = pmtMtd;
    }

    public String getNm() {
        return Nm;
    }

    public void setNm(String nm) {
        Nm = nm;
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }
}
