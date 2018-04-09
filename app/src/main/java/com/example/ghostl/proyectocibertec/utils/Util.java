package com.example.ghostl.proyectocibertec.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class Util {

    public static void saveSharedPreferenceUser(String username, Context context) {
        SharedPreferences sharedPref =
                context.getSharedPreferences(Constants.PREF_NAME, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(Constants.USER_NAME_KEY, username);
        editor.commit();
    }

}
