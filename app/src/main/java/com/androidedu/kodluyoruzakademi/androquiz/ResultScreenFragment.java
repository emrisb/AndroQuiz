package com.androidedu.kodluyoruzakademi.androquiz;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;


public class ResultScreenFragment extends Fragment {

    ArrayList<String> answers;
    TextView txtUsername;
    String username;
    ArrayList<Question> question;
    LinearLayout linearLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            ResultVM resultVM = getArguments().getParcelable("result");
            username = resultVM.getUsername();
            answers = resultVM.getAnswerList();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_result_screen, container, false);

        txtUsername = view.findViewById(R.id.fragment_result_screen_txtUsername);
        txtUsername.setText(username);
        linearLayout = view.findViewById(R.id.fragment_result_screen);

        initView();
        printAnswers();
        return view;
    }

    private void initView() {
        question = QuizVM.getInstance().getQuestionList();
    }

    private void printAnswers() {

        for (int i = 0; i < question.size(); i++) {
            TextView txtAns = new TextView(getActivity());
            if (answers.get(i).equalsIgnoreCase(question.get(i).getqAns())) {
                txtAns.setText("Soru " + (i + 1) + ": Doğru");
                txtAns.setTextColor(Color.GREEN);
                linearLayout.addView(txtAns);
            } else {
                txtAns.setText("Soru " + (i + 1) + ": Yanlış");
                txtAns.setTextColor(Color.RED);
                linearLayout.addView(txtAns);
            }
        }
    }
}
