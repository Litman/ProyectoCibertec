package com.example.ghostl.proyectocibertec.services;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import com.example.ghostl.proyectocibertec.utils.Constants;
import com.example.ghostl.proyectocibertec.utils.Util;

public class ServiceUpdateData extends Service {

    private Context context;

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
            Toast.makeText(context, "Se Actualizaron sus datos en WS", Toast.LENGTH_LONG).show();
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
