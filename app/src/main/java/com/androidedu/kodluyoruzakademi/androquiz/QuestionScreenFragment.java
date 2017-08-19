package com.androidedu.kodluyoruzakademi.androquiz;


import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class QuestionScreenFragment extends Fragment implements RadioGroup.OnCheckedChangeListener, View.OnClickListener {


    private TextView txtQuestionNumber, txtQuestionText;
    private RadioButton radioFirst, radioSecond, radioThird, radioFourth;
    private RadioGroup radioGroupAnswers;
    private TextView txtUsername;
    private String username = "";
    private Button btnContinue;
    private ArrayList<Question> question;
    private Answers answers;
    private String answer = "";
    private int qCounter = 0;
    private boolean finishGame = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            username = getArguments().getString(AnyEnum.Username2.toString());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_question_screen, container, false);

        radioFirst = view.findViewById(R.id.fragment_question_screen_radioFirst);
        radioSecond = view.findViewById(R.id.fragment_question_screen_radioSecond);
        radioThird = view.findViewById(R.id.fragment_question_screen_radioThird);
        radioFourth = view.findViewById(R.id.fragment_question_screen_radioFourth);
        radioGroupAnswers = view.findViewById(R.id.fragment_question_screen_radioGroupAnswers);
        btnContinue = view.findViewById(R.id.fragment_question_screen_btnContinue);
        txtUsername = view.findViewById(R.id.fragment_question_screen_txtUsername);
        txtQuestionNumber = view.findViewById(R.id.fragment_question_screen_txtQuestionNumber);
        txtQuestionText = view.findViewById(R.id.fragment_question_screen_txtQuestionText);

        initEvent();
        return view;
    }


    private void initEvent() {
        radioGroupAnswers.setOnCheckedChangeListener(this);
        btnContinue.setOnClickListener(this);
        txtUsername.setText(username);
        answers = Answers.getInstance();
        question = QuizVM.getInstance().getQuestionList();
        printQuestion();
    }

    private void printQuestion() {
        if (qCounter < 10) {
            txtQuestionText.setText(question.get(qCounter).getqText());
            txtQuestionNumber.setText("Soru " + String.valueOf(question.get(qCounter).getqID()));
            radioFirst.setText(question.get(qCounter).getqOpt1());
            radioSecond.setText(question.get(qCounter).getqOpt2());
            radioThird.setText(question.get(qCounter).getqOpt3());
            radioFourth.setText(question.get(qCounter).getqOpt4());

            radioGroupAnswers.clearCheck();
            btnContinue.setEnabled(false);
        }

        qCounter++;

        if (finishGame) {
            //resulta geç
            ResultScreenFragment resultScreenFragment = new ResultScreenFragment();
            ResultVM resultVM = new ResultVM();
            Bundle bundle = new Bundle();
            resultVM.setUsername(username);
            resultVM.setAnswerList(Answers.getInstance().getArray());
            bundle.putParcelable("result", resultVM);
            resultScreenFragment.setArguments(bundle);

            FragmentManager manager = getActivity().getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();

            transaction.replace(R.id.activity_quiz_screen_fragmentQuestion, resultScreenFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
        if (qCounter > 9) {
            btnContinue.setText("Sonuç");
            finishGame = true;
        }


    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
        switch (i) {
            case -1:
                btnContinue.setEnabled(false);
                break;
            case R.id.fragment_question_screen_radioFirst:
                btnContinue.setEnabled(true);
                answer = radioFirst.getText().toString();
                break;
            case R.id.fragment_question_screen_radioSecond:
                btnContinue.setEnabled(true);
                answer = radioSecond.getText().toString();
                break;
            case R.id.fragment_question_screen_radioThird:
                btnContinue.setEnabled(true);
                answer = radioThird.getText().toString();
                break;
            case R.id.fragment_question_screen_radioFourth:
                btnContinue.setEnabled(true);
                answer = radioFourth.getText().toString();
                break;
            default:
                btnContinue.setEnabled(false);
                break;
        }
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.fragment_question_screen_btnContinue) {
            Answers.getInstance().addToList(answer);
            printQuestion();
        }

    }
}
