package com.androidedu.kodluyoruzakademi.androquiz;

import java.util.ArrayList;

/**
 * Created by emre on 8/11/2017.
 */

public class Answers {

    private static Answers ourInstance;
    private ArrayList<String> answersList = new ArrayList<>();

    private Answers() {
        answersList = new ArrayList<String>();
    }

    public static Answers getInstance() {
        if (ourInstance == null)
            ourInstance = new Answers();

        return ourInstance;
    }

    public ArrayList<String> getArray() {
        return this.answersList;
    }

    public void addToList(String answer) {
        answersList.add(answer);
    }

}
