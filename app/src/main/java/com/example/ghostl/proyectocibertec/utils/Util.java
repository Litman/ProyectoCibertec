package com.example.ghostl.proyectocibertec.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;

import com.example.ghostl.proyectocibertec.model.PrincipalData;

public class Util {

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
        return new PrincipalData("", "", "", 1);
    }

}
