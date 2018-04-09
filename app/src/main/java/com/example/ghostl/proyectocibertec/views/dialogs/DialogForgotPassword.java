package com.example.ghostl.proyectocibertec.views.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;

import android.app.DialogFragment;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ghostl.proyectocibertec.R;
import com.example.ghostl.proyectocibertec.presenters.DialogForgotPasswordPresenter;
import com.example.ghostl.proyectocibertec.presenters.DialogForgotPasswordPresenterImpl;

public class DialogForgotPassword extends DialogFragment implements DialogView{

    private String title;
    private String content;
    private Button btnOk, btnCancelar;
    TextView etTitleDialog;
    EditText etMessage;
    DialogForgotPasswordPresenter presenter;

    AlertDialog.Builder builder;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        presenter = new DialogForgotPasswordPresenterImpl(this);
        builder = new AlertDialog.Builder(getActivity());

        LayoutInflater layoutInflater = getActivity().getLayoutInflater();

        View dialogLayout = layoutInflater.inflate(R.layout.dialog_forgot, null);
        initObjects(dialogLayout);


        builder.setView(dialogLayout);


        return builder.create();
        
    }

    private void initObjects(View dialogLayout) {
        etTitleDialog = dialogLayout.findViewById(R.id.tTitleDialog);
        etMessage = dialogLayout.findViewById(R.id.etDialog);
        btnOk = dialogLayout.findViewById(R.id.bSendDialog);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.sendEmail(etMessage.getText().toString());
            }
        });
    }

    @Override
    public void setErrorEmail(String message) {
        etMessage.setError(message);
    }

    @Override
    public void closeDialog() {
        getActivity().finish();
    }

    @Override
    public void navigateToHome() {
        dismiss();
    }
}
