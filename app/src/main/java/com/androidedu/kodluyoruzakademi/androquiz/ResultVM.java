package com.androidedu.kodluyoruzakademi.androquiz;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by emre on 8/18/2017.
 */

public class ResultVM implements Parcelable {
    public static final Creator<ResultVM> CREATOR = new Creator<ResultVM>() {
        @Override
        public ResultVM createFromParcel(Parcel in) {
            return new ResultVM(in);
        }

        @Override
        public ResultVM[] newArray(int size) {
            return new ResultVM[size];
        }
    };
    private ArrayList<String> answerList;
    private String username;

    public ResultVM(ArrayList<String> answerList, String username) {
        this.answerList = answerList;
        this.username = username;
    }


    public ResultVM() {
    }

    protected ResultVM(Parcel in) {
        answerList = in.createStringArrayList();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ArrayList<String> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(ArrayList<String> answerList) {
        this.answerList = answerList;
        this.username = username;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStringList(answerList);
    }
}
