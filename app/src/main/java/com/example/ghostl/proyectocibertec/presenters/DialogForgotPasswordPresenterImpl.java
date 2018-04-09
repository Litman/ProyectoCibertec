package com.example.ghostl.proyectocibertec.presenters;

import com.example.ghostl.proyectocibertec.interactors.DialogForgotPasswordInteractor;
import com.example.ghostl.proyectocibertec.interactors.DialogForgotPasswordInteractorImpl;
import com.example.ghostl.proyectocibertec.utils.Util;
import com.example.ghostl.proyectocibertec.views.dialogs.DialogView;

public class DialogForgotPasswordPresenterImpl implements DialogForgotPasswordPresenter, DialogForgotPasswordInteractor.OnDialogForgotPasswordListener {

    DialogView dialogView;
    DialogForgotPasswordInteractor dialogInteractor;

    public DialogForgotPasswordPresenterImpl(DialogView dialogView) {
        this.dialogView = dialogView;
        this.dialogInteractor = new DialogForgotPasswordInteractorImpl();
    }

    @Override
    public void sendEmail(String email) {
        if(validateEmail(email)){
            dialogInteractor.sendEmail(email, this);
        }else{
            onEmailError("Ingrese un Email valido");
        }

    }

    private boolean validateEmail(String email) {
        return Util.isValidEmail(email);
    }

    @Override
    public void onSuccess() {
        if(dialogView != null){
            dialogView.navigateToHome();
        }
    }

    @Override
    public void onEmailError(String errorMail) {
        if(dialogView != null){
            dialogView.setErrorEmail(errorMail);
        }
    }
}
