package com.cactuscode;

/**
 * Created by Dngy on 23.5.2016..
 */
public class GroupHeader {

    private String MsgId;
    private String CreDtTm;
    private int NbOfTxs;
    private String Nm; //Unutar InitgPty


    public String getMsgId() {
        return MsgId;
    }

    public void setMsgId(String msgId) {
        MsgId = msgId;
    }

    public String getCreDtTm() {
        return CreDtTm;
    }

    public void setCreDtTm(String creDtTm) {
        CreDtTm = creDtTm;
    }

    public int getNbOfTxs() {
        return NbOfTxs;
    }

    public void setNbOfTxs(int nbOfTxs) {
        NbOfTxs = nbOfTxs;
    }

    public String getNm() {
        return Nm;
    }

    public void setNm(String nm) {
        Nm = nm;
    }
}
