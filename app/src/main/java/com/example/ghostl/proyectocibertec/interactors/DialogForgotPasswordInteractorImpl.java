package com.example.ghostl.proyectocibertec.interactors;

import android.os.Handler;
import android.text.TextUtils;

import com.example.ghostl.proyectocibertec.utils.Util;

public class DialogForgotPasswordInteractorImpl implements DialogForgotPasswordInteractor {
    @Override
    public void sendEmail(final String email, final OnDialogForgotPasswordListener listener) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                boolean error=false;
                if(TextUtils.isEmpty(email)){
                    listener.onEmailError("Ingrese un Email");
                    error=true;
                }
                if(!error){

                    listener.onSuccess();

                }
            }
        }, 2000);
    }
}
