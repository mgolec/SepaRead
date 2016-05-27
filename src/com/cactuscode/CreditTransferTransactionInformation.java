package com.cactuscode;

/**
 * Created by Dngy on 25.5.2016..
 */
public class CreditTransferTransactionInformation {

    private String EndToEndId;
    private Double InstdAmt;
    private String Nm;
    private String IBAN;

    public String getEndToEndId() {
        return EndToEndId;
    }

    public void setEndToEndId(String endToEndId) {
        EndToEndId = endToEndId;
    }

    public Double getInstdAmt() {
        return InstdAmt;
    }

    public void setInstdAmt(Double instdAmt) {
        InstdAmt = instdAmt;
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
