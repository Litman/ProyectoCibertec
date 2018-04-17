package com.example.ghostl.proyectocibertec.views.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ghostl.proyectocibertec.R;

public class ChangePasswordActivity extends AppCompatActivity {

    private String TAG = "ChangePassword";
    Toolbar mToolbar;
    Button changePassword, cancel;
    EditText etOldPwd, etNewPwd, etReNewPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        Log.d(TAG, "Enter Change Password");
        initObject();

        changePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validateData()){
                    //Connect Web Service
                    Toast.makeText(ChangePasswordActivity.this,"Se Cambio Exitosamente su Password", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });


        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private boolean validateData() {
        if(etOldPwd.getText().toString() == ""){
            return false;
        }

        if(etNewPwd.getText().toString() == ""){
            return false;
        }

        if(etReNewPwd.getText().toString() == ""){
            return false;
        }

        if(! etNewPwd.getText().toString().equals(etReNewPwd.getText().toString())){
            return false;
        }

        return true;
    }

    private void initObject() {
        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        changePassword = findViewById(R.id.bConfirm);
        cancel = findViewById(R.id.bCancel);
        etNewPwd = findViewById(R.id.eNewPassword);
        etOldPwd = findViewById(R.id.eOldPassword);
        etReNewPwd = findViewById(R.id.eRepeatNewPassword);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
