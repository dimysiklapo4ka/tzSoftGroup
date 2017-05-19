package com.example.d1mys1klapo4ka.tz.activity.settings;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by dev on 5/18/17.
 */

public class HelperSP {

    private static HelperSP helperSP;

    private HelperSP(){}

    public static HelperSP initialization(){
        if (helperSP == null){

            helperSP = new HelperSP();
        }
        return helperSP;
    }

    private String FILE_NAME = "settings";

    private SharedPreferences settings = null;
    private SharedPreferences.Editor editor = null;
    private Context context = null;

    public void init(Context cntxt){
        context = cntxt;
    }

    private void init(){
        settings = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        editor = settings.edit();
        editor.apply();
    }

    public void setUser( String key, String value ){
        if( settings == null ){
            init();
        }
        editor.putString( key, value );
        editor.apply();
    }

//    public static void setPassword( String key, String value ){
//        if( settings == null ){
//            init();
//        }
//        editor.putString( key, value );
//        editor.apply();
//    }

    public String getUser( String key ){
        if( settings == null ){
            init();
        }
        return settings.getString( key, "###########" );
    }

//    public static String getPassword( String key ){
//        if( settings == null ){
//            init();
//        }
//        return settings.getString( key, "###########" );
//    }

    public boolean settingSearch(String key){
        if( settings == null ){
            init();
        }
        return settings.contains(key);
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
