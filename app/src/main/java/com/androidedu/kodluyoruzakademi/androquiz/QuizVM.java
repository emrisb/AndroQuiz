package com.androidedu.kodluyoruzakademi.androquiz;

import java.util.ArrayList;

/**
 * Created by emre on 8/11/2017.
 */

public class QuizVM {
    private static final QuizVM quizVM = new QuizVM();
    private ArrayList<Question> questionList = new ArrayList<>();

    private QuizVM() {

    }

    public static QuizVM getInstance() {
        return quizVM;
    }

    public void addQuestion(Question question) {
        questionList.add(question);
    }

    public ArrayList<Question> getQuestionList() {
        return questionList;
    }
}
