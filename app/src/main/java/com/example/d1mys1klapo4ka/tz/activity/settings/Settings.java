package com.example.d1mys1klapo4ka.tz.activity.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.StrictMode;

/**
 * Created by dev on 5/18/17.
 */

public class Settings {

    public static String FILE_NAME = "settings";

    public static String USER_MAIL = "user_mail";
    public static String USER_PASS= "user_pass";

    private static SharedPreferences settings = null;
    private static SharedPreferences.Editor editor = null;
    private static Context context = null;

    public static void init( Context cntxt ){
        context = cntxt;
    }

    private static void init(){
        settings = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        editor = settings.edit();
        editor.apply();
    }

    public static void setEmail( String key, String value ){
        if( settings == null ){
            init();
        }
        editor.putString( key, value );
        editor.apply();
    }

    public static void setPassword( String key, String value ){
        if( settings == null ){
            init();
        }
        editor.putString( key, value );
        editor.apply();
    }

    public static String getEmail( String key ){
        if( settings == null ){
            init();
        }
        return settings.getString( key, null );
    }

    public static String getPassword( String key ){
        if( settings == null ){
            init();
        }
        return settings.getString( key, null );
    }
//    public static void setMail(String mail, SharedPreferences sharedPreferences){
//
//        putToPrefs(mail, USER_MAIL, sharedPreferences);
//    }
//
//    public static String getMail(SharedPreferences sharedPreferences){
//
//        return sharedPreferences.getString(USER_MAIL, "");
//    }
//
//    public static void setPassword(String password, SharedPreferences sharedPreferences){
//
//        putToPrefs(password, USER_PASS, sharedPreferences);
//    }
//
//    public static String getPassword(SharedPreferences sharedPreferences){
//
//        return sharedPreferences.getString(USER_PASS, "");
//    }
//
//    private static void putToPrefs(Object o, String key, SharedPreferences sharedPreferences){
//
//
//        if (o instanceof String){
//            sharedPreferences.edit().putString(key, (String) o).apply();
//
//        }
//
//
//    }


}
