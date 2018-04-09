package com.example.ghostl.proyectocibertec.presenters;

import android.content.Context;

import com.example.ghostl.proyectocibertec.interactors.LoginInteractor;
import com.example.ghostl.proyectocibertec.interactors.LoginInteractorImpl;
import com.example.ghostl.proyectocibertec.views.activities.LoginView;

public class LoginPresenterImpl implements LoginPresenter, LoginInteractor.OnMyLoginFinishedListener {
    LoginView mLoginview;
    LoginInteractor mLoginInteractor;

    public LoginPresenterImpl(LoginView loginView){
        this.mLoginview = loginView;
        this.mLoginInteractor = new LoginInteractorImpl();
    }

    @Override
    public void validateCredentials(String username, String password, boolean optionSelect, Context context) {
        if(mLoginview != null){
            mLoginview.showProgress();
        }
        mLoginInteractor.login(username, password, optionSelect, context, this);

    }

    @Override
    public void validateUserExist(boolean optionSelect, Context context) {
        mLoginInteractor.validateUserExist(optionSelect, context, this);
    }

    @Override
    public void onDestroy() {
        mLoginview = null;
    }

    @Override
    public void onUsernameError() {
        if(mLoginview != null){
            mLoginview.setUsernameError();
            mLoginview.hideProgress();
        }
    }

    @Override
    public void onUsernameExist() {
        if(mLoginview != null){
            mLoginview.showErrorUsernameNotExist();
        }

    }

    @Override
    public void onPasswordError() {
        if(mLoginview != null){
            mLoginview.setPasswordError();
            mLoginview.hideProgress();
        }
    }

    @Override
    public void onSuccess() {
        if(mLoginview != null){
            mLoginview.navigateToHome();
        }
    }

    @Override
    public void onSetUsername(String response) {
        if(mLoginview != null){
            mLoginview.setUsernameError();
            mLoginview.disabledUserText();
        }
    }

    @Override
    public void onEnabledUsername() {
        if(mLoginview != null){
            mLoginview.enabledUserText();
        }
    }
}
