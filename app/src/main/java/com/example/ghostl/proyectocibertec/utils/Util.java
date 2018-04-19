package com.example.ghostl.proyectocibertec.utils;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.ghostl.proyectocibertec.model.PrincipalData;
import com.example.ghostl.proyectocibertec.views.activities.UpdateProfileActivity;

public class Util {

    static final int TYPE_WIFI = 1;
    static final int TYPE_MOBILE = 2;
    static final int TYPE_NOT_CONNECTED = 0;

    public static void saveSharedPreferenceUser(String username, Context context) {
        Log.d("SavePreference", username);
        SharedPreferences sharedPref =
                context.getSharedPreferences(Constants.PREF_NAME, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(Constants.USER_NAME_KEY, username);
        editor.commit();
    }

    public final static boolean isValidEmail(CharSequence target) {
        return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }

    public static PrincipalData addHead(){
        return new PrincipalData("", "", "", 1, 0, null, null, null);
    }

    public static boolean checkPermission(final UpdateProfileActivity updateProfileActivity, SharedPreferences permissionStatus,boolean sentToSettings) {

        final int EXTERNAL_STORAGE_PERMISSION_CONSTANT = 123;

        if (Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            if (ActivityCompat.checkSelfPermission(updateProfileActivity.getApplicationContext(), Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                Log.d("Entro Permiso", "Ok");
                if (ActivityCompat.shouldShowRequestPermissionRationale(updateProfileActivity, Manifest.permission.READ_EXTERNAL_STORAGE)) {
                    AlertDialog.Builder alertBuilder = new AlertDialog.Builder(updateProfileActivity.getApplicationContext());
                    alertBuilder.setCancelable(true);
                    alertBuilder.setTitle("Permission necessary");
                    alertBuilder.setMessage("External storage permission is necessary");
                    alertBuilder.setPositiveButton(android.R.string.yes,
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.cancel();
                                    ActivityCompat.requestPermissions(updateProfileActivity, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, EXTERNAL_STORAGE_PERMISSION_CONSTANT);

                                }
                            });
                    alertBuilder.setNegativeButton(android.R.string.no,
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.cancel();
                                }
                            });
                    alertBuilder.show();

                } else {
                    Log.d("Entro Else", "Else");
                    ActivityCompat.requestPermissions(updateProfileActivity, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, EXTERNAL_STORAGE_PERMISSION_CONSTANT);
                }
                return false;

            } else {
                return true;
            }
        }else{
            return true;
        }

    }

    public static String getConnectivityStatusString(Context context){
        String status = null;
        int connection = getConnectivityStatus(context);

        if(connection == TYPE_WIFI){
            status = Constants.CONNECT_TO_WIFI;
        }else if(connection == TYPE_MOBILE){
            Log.d("TYPE_MOBILE", ":"+Constants.CONNECT_TO_MOBILE);
            status = getNetworkClass(context);
        }else if(connection == TYPE_NOT_CONNECTED){
            status = Constants.NOT_CONNECTED;
        }
        return status;
    }

    private static String getNetworkClass(Context context) {

        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = connectivityManager.getActiveNetworkInfo();
        if(info == null || !info.isConnected()){
            return "-";
        }
        if(info.getType() == ConnectivityManager.TYPE_WIFI){
            return Constants.CONNECT_TO_WIFI;
        }
        if(info.getType() == ConnectivityManager.TYPE_MOBILE){
            int networkType = info.getSubtype();
            switch (networkType){
                case TelephonyManager.NETWORK_TYPE_HSDPA:
                    return "3G";

                case TelephonyManager.NETWORK_TYPE_LTE:
                    return "4G";
                default:
                    return "UNKNOWN";
            }

        }
        return "UNKNOWN";
    }


    public static int getConnectivityStatus(Context context){

        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activityNetwork = connectivityManager.getActiveNetworkInfo();

        if(activityNetwork != null){
            if (activityNetwork.getType()  == ConnectivityManager.TYPE_WIFI){
                return TYPE_WIFI;
            }

            if(activityNetwork.getType() == ConnectivityManager.TYPE_MOBILE){
                return TYPE_MOBILE;
            }
        }
        return TYPE_NOT_CONNECTED;
    }

}
