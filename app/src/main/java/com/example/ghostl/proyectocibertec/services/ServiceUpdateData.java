package com.example.ghostl.proyectocibertec.services;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import com.example.ghostl.proyectocibertec.controllers.PrincipalApi;
import com.example.ghostl.proyectocibertec.controllers.PrincipalControllerApi;
import com.example.ghostl.proyectocibertec.model.UserData;
import com.example.ghostl.proyectocibertec.utils.Constants;
import com.example.ghostl.proyectocibertec.utils.Util;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ServiceUpdateData extends Service {

    private Context context;
    private static PrincipalApi principalApi;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("Entro Service", "Servicio in Action");
        context = this;
        Iniciar();
    }

    private void Iniciar() {
        Log.d("Entro Service", "Servicio in Action");
        if(!Util.getConnectivityStatusString(getApplicationContext()).equals(Constants.NOT_CONNECTED)){

            principalApi = PrincipalControllerApi.getClient().create(PrincipalApi.class);

            Call<UserData> call = principalApi.getDataCountry(2);

            call.enqueue(new Callback<UserData>() {
                @Override
                public void onResponse(Call<UserData> call, Response<UserData> response) {
                    Log.d("Service Ok ", "OK");
                    Toast.makeText(context, response.body().toString(), Toast.LENGTH_LONG).show();
                    stopSelf();
                }

                @Override
                public void onFailure(Call<UserData> call, Throwable t) {
                    Log.d("Show Error", "//:"+t.getMessage());
                    stopSelf();
                }
            });

            stopSelf();
        }
    }

    private void notConnected() {


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
