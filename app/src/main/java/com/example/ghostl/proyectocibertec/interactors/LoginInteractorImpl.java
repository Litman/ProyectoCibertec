package com.example.ghostl.proyectocibertec.interactors;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.text.TextUtils;

import com.example.ghostl.proyectocibertec.utils.Constants;
import com.example.ghostl.proyectocibertec.utils.Util;

public class LoginInteractorImpl implements  LoginInteractor {
    @Override
    public void login(final String username, final String password, boolean optionSelected, final Context context, final OnMyLoginFinishedListener listener) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                boolean error=false;
                if(TextUtils.isEmpty(username)){
                    listener.onUsernameError();
                    error=true;
                }
                if(TextUtils.isEmpty(password)){
                    listener.onPasswordError();
                    error=true;
                }
                if(!error){
                    listener.onSuccess();
                    Util.saveSharedPreferenceUser(username, context);

                }
            }
        }, 2000);
    }

    @Override
    public void validateUserExist(boolean optionSelected, Context context, OnMyLoginFinishedListener listener) {
        if (optionSelected){
            SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.PREF_NAME, Context.MODE_PRIVATE);
            String response = sharedPreferences.getString(Constants.USER_NAME_KEY, "");

            if (response.trim().length() == 0 || response == null || response.isEmpty() || response.equals("null")) {

                listener.onUsernameExist();

            } else {

                listener.onSetUsername(response);
                //return response;
            }

        }else{
            listener.onEnabledUsername();
        }
    }
}
