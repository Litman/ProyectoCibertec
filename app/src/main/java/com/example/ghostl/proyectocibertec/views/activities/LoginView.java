package com.example.ghostl.proyectocibertec.views.activities;

public interface LoginView {

    void showProgress();

    void hideProgress();

    void setUsernameError();

    void setPasswordError();

    void navigateToHome();

    void showPassword();

    void enabledUserText();

    void disabledUserText();

    void setUserName(String user);

    void showErrorUsernameNotExist();

    void showDialogRecoverPwd();

}
