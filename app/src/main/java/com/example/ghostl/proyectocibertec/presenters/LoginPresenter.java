package com.example.ghostl.proyectocibertec.presenters;

import android.content.Context;

public interface LoginPresenter {
    void validateCredentials(String username, String password, boolean optionSelect, Context context);

    void validateUserExist(boolean optionSelect, Context context);

    void onDestroy();

    void showDialog();

    void showPassword();

    void showRefreshTokenFCM();
}
