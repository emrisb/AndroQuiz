package com.androidedu.kodluyoruzakademi.androquiz;

/**
 * Created by emre on 8/12/2017.
 */

public class Question {
    private int qID;
    private String qText;
    private String qOpt1, qOpt2, qOpt3, qOpt4;
    private String qAns;

    public Question(int qID, String qText, String qOpt1, String qOpt2, String qOpt3, String qOpt4, String qAns) {
        this.qID = qID;
        this.qText = qText;
        this.qOpt1 = qOpt1;
        this.qOpt2 = qOpt2;
        this.qOpt3 = qOpt3;
        this.qOpt4 = qOpt4;
        this.qAns = qAns;
    }

    public int getqID() {
        return qID;
    }

    public void setqID(int qID) {
        this.qID = qID;
    }

    public String getqText() {
        return qText;
    }

    public void setqText(String qText) {
        this.qText = qText;
    }

    public String getqOpt1() {
        return qOpt1;
    }

    public void setqOpt1(String qOpt1) {
        this.qOpt1 = qOpt1;
    }

    public String getqOpt2() {
        return qOpt2;
    }

    public void setqOpt2(String qOpt2) {
        this.qOpt2 = qOpt2;
    }

    public String getqOpt3() {
        return qOpt3;
    }

    public void setqOpt3(String qOpt3) {
        this.qOpt3 = qOpt3;
    }

    public String getqOpt4() {
        return qOpt4;
    }

    public void setqOpt4(String qOpt4) {
        this.qOpt4 = qOpt4;
    }

    public String getqAns() {
        return qAns;
    }

    public void setqAns(String qAns) {
        this.qAns = qAns;
    }
}
