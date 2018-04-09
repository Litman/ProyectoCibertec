package com.example.ghostl.proyectocibertec.interactors;

public interface DialogForgotPasswordInteractor {
    interface OnDialogForgotPasswordListener{

        void onSuccess();

        void onEmailError(String error);
    }

    void sendEmail(String email, DialogForgotPasswordInteractor.OnDialogForgotPasswordListener listener);

}
