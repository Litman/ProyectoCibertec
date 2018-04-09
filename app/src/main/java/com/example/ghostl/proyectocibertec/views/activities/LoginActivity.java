package com.example.ghostl.proyectocibertec.views.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.SwitchCompat;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.example.ghostl.proyectocibertec.R;
import com.example.ghostl.proyectocibertec.presenters.LoginPresenter;
import com.example.ghostl.proyectocibertec.presenters.LoginPresenterImpl;

public class LoginActivity extends AppCompatActivity implements LoginView, View.OnClickListener{

    private static final String TAG = "Login";
    Button btEnter;
    AppCompatEditText etUser, etPwd;
    ProgressBar progressBar;
    RelativeLayout rProgresBar;
    SwitchCompat swRememberUser;
    LoginPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        presenter = new LoginPresenterImpl(this);
        initObjects();

    }

    private void initObjects() {

        etUser = findViewById(R.id.eUsername);
        etPwd = findViewById(R.id.ePassword);
        progressBar = findViewById(R.id.pProgressBar);
        rProgresBar = findViewById(R.id.rRelativeProgress);
        swRememberUser = findViewById(R.id.swRememberUser);
        findViewById(R.id.bLogin).setOnClickListener(this);
        findViewById(R.id.img_showPass).setOnClickListener(this);
        findViewById(R.id.tForgotPassword).setOnClickListener(this);
        swRememberUser.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Log.d("Main", "//" + b);
                presenter.validateUserExist(b, getApplicationContext());
            }
        });
    }

    @Override
    public void showProgress() {
        rProgresBar.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideProgress() {
        rProgresBar.setVisibility(View.GONE);
    }

    @Override
    public void setUsernameError() {
        etUser.setError(getString(R.string.username_error));
    }

    @Override
    public void setPasswordError() {
        etPwd.setError(getString(R.string.password_error));
    }

    @Override
    public void navigateToHome() {

        startActivity(new Intent(this, HomeActivity.class));
    }

    @Override
    public void showPassword() {
        if(etPwd.getInputType() == 129 ){
            etPwd.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
        }else {
            etPwd.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        }
    }

    @Override
    public void enabledUserText() {

    }

    @Override
    public void disabledUserText() {
        etUser.setEnabled(true);
        etUser.setText("");
    }

    @Override
    public void setUserName(String user) {
        etUser.setEnabled(false);
    }

    @Override
    public void showErrorUsernameNotExist() {
        etUser.setError(getString(R.string.username_not_exist));
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.bLogin:
                presenter.validateCredentials(etUser.getText().toString(), etPwd.getText().toString(), swRememberUser.isSelected(), getApplicationContext());

                break;
            case R.id.img_showPass:
                showPassword();
                break;

        }
    }
}
