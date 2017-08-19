package com.androidedu.kodluyoruzakademi.androquiz;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

public class QuizScreenActivity extends AppCompatActivity {

    ArrayList<String> answerses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_screen);

        initView();
        initQuestions();
    }

    private void initView() {
        getQuestionFragment();
        answerses = new ArrayList<>();
    }

    private void getQuestionFragment() {
        QuestionScreenFragment questionScreenFragment = new QuestionScreenFragment();
        Bundle bundle = getIntent().getExtras();
        Bundle bundle1 = new Bundle();
        bundle1.putString(AnyEnum.Username2.toString(), bundle.getString(AnyEnum.Username.toString()));
        questionScreenFragment.setArguments(bundle1);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.activity_quiz_screen_fragmentQuestion, questionScreenFragment);
        fragmentTransaction.commit();

    }

    private void initQuestions() {

        QuizVM quizVM = QuizVM.getInstance();
        Question q1 = new Question(1, "İngilizcede Elma?", "Apple", "Peach", "Apricot", "Melon", "Apple");
        Question q2 = new Question(2, "İngilizcede Kedi?", "Cat", "Dog", "Giraffe", "Elephant", "Cat");
        Question q3 = new Question(3, "İngilizcede Köpek?", "Cat", "Dog", "Giraffe", "Elephant", "Dog");
        Question q4 = new Question(4, "İngilizcede Bilgisayar?", "Computer", "Printer", "Keyboard", "Mouse", "Computer");
        Question q5 = new Question(5, "İngilizcede Yazıcı?", "Computer", "Printer", "Keyboard", "Mouse", "Printer");
        Question q6 = new Question(6, "İngilizcede Klavye?", "Computer", "Printer", "Keyboard", "Mouse", "Keyboard");
        Question q7 = new Question(7, "İngilizcede Fare?", "Computer", "Printer", "Keyboard", "Mouse", "Mouse");
        Question q8 = new Question(8, "İngilizcede Elma?", "Apple", "Peach", "Apricot", "Melon", "Apple");
        Question q9 = new Question(9, "İngilizcede Kedi?", "Cat", "Dog", "Giraffe", "Elephant", "Cat");
        Question q10 = new Question(10, "İngilizcede Köpek?", "Cat", "Dog", "Giraffe", "Elephant", "Dog");

        quizVM.addQuestion(q1);
        quizVM.addQuestion(q2);
        quizVM.addQuestion(q3);
        quizVM.addQuestion(q4);
        quizVM.addQuestion(q5);
        quizVM.addQuestion(q6);
        quizVM.addQuestion(q7);
        quizVM.addQuestion(q8);
        quizVM.addQuestion(q9);
        quizVM.addQuestion(q10);

    }
}
