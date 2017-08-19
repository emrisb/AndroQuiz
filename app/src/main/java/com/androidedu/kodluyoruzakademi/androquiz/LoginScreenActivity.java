package com.androidedu.kodluyoruzakademi.androquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginScreenActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtUsername, edtPassword;
    private Button btnLogin;
    TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            if (edtUsername.getText().toString().trim().length() >= 1 &&
                    edtPassword.getText().toString().trim().length() >= 1) {
                btnLogin.setEnabled(true);
            } else {
                btnLogin.setEnabled(false);
            }
        }

        @Override
        public void afterTextChanged(Editable editable) {
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        initView();
        initEvent();

    }

    private void initView() {
        edtUsername = (EditText) findViewById(R.id.activity_login_screen_edtUsername);
        edtPassword = (EditText) findViewById(R.id.activity_login_screen_edtPassword);
        btnLogin = (Button) findViewById(R.id.activity_login_screen_btnLogin);

    }

    private void initEvent() {
        edtPassword.addTextChangedListener(textWatcher);
        edtUsername.addTextChangedListener(textWatcher);
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.activity_login_screen_btnLogin) {
            Bundle bundle = new Bundle();
            bundle.putString(AnyEnum.Username.toString(), edtUsername.getText().toString().trim());
            Intent sendUsernameIntent = new Intent(this, QuizScreenActivity.class);
            sendUsernameIntent.putExtras(bundle);
            startActivity(sendUsernameIntent);
            finish();
        }
    }
}
