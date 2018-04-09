package com.example.ghostl.proyectocibertec.interactors;

import android.content.Context;

public interface LoginInteractor {

    interface OnMyLoginFinishedListener {
        void onUsernameError();

        void onUsernameExist();

        void onPasswordError();

        void onSuccess();

        void onSetUsername(String response);

        void onEnabledUsername();
    }

    void login(String username, String password, boolean optionSelected, Context context, OnMyLoginFinishedListener listener);

    void validateUserExist(boolean optionSelected, Context context, OnMyLoginFinishedListener listener);

}
