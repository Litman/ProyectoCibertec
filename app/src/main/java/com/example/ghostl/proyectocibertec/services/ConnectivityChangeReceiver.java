package com.example.ghostl.proyectocibertec.services;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.example.ghostl.proyectocibertec.utils.Constants;
import com.example.ghostl.proyectocibertec.utils.Util;

public class ConnectivityChangeReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        if(!Util.getConnectivityStatusString(context).equals(Constants.NOT_CONNECTED)){
            Log.d("Inicio de Servicio ","/"+context.getPackageName() + "..//"+ServiceUpdateData.class.getName());
            ComponentName componentName = new ComponentName(context.getPackageName(), ServiceUpdateData.class.getName());
            context.startService((intent.setComponent(componentName)));
        }
    }
}
