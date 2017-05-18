package com.example.d1mys1klapo4ka.tz.activity.settings;

import android.content.SharedPreferences;
import android.os.StrictMode;

/**
 * Created by dev on 5/18/17.
 */

public class Settings {

    public static String FILE_NAME = "settings";

    private static String USER_MAIL = "user_mail";
    private static String USER_PASS= "user_pass";


    public static void setMail(String mail, SharedPreferences sharedPreferences){

        putToPrefs(mail, USER_MAIL, sharedPreferences);
    }

    public static String getMail(SharedPreferences sharedPreferences){

        return sharedPreferences.getString(USER_MAIL, "");
    }

    private static void putToPrefs(Object o, String key, SharedPreferences sharedPreferences){


        if (o instanceof String){
            sharedPreferences.edit().putString(key, (String) o).apply();
        }


    }


}
