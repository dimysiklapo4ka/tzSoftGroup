package com.example.d1mys1klapo4ka.tz.activity.helper;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.example.d1mys1klapo4ka.tz.activity.SecondActivity;
import com.example.d1mys1klapo4ka.tz.activity.settings.Settings;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by d1mys1klapo4ka on 17.05.2017.
 */

public class Helper{

    //Для хеширования паролей
    private MyCustomMD5 md5 = new MyCustomMD5();
//
//    //Хранение пароля и email в виде ключа
//    Map<String,String> bd = new HashMap<>();
//
//    //Добавление данных
//    public void addUser(String email, String password){
//            bd.put(email, md5.md5Custom(password));
//    }
//
//    //Проверка ввода одинаковых паролей
//    public boolean equalPassword(String password, String passwordConfirm){
//        return md5.md5Custom(password).equals(md5.md5Custom(passwordConfirm));
//    }
//
//    //Валидатор минимальной длины пароля и email
//    public boolean verificationLength(String email, String password){
//        return  (email.length() > 5 && password.length() > 3);
//    }
//
//    //Чистка базы данных
//    public void clearBd(){
//        bd.clear();
//    }
//
//    //Валидация email
//    public final static boolean isValidEmail(CharSequence target) {
//        return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
//    }
//
//    //Проверка email на повторный ввод
//    public boolean emailConfirm(String email){
//        for (int i = 0; i <bd.size();i++){
//            email.equals(bd.get(i));
//            return false;
//        }
//        return true;
//    }
//
//    //проверка что ключ и значение совпадают с введеными на первой странице
//    public boolean userValid(String email, String password){
//        for (Map.Entry entry : bd.entrySet()) {
//
//            if (email.equals(entry.getKey()) && md5.md5Custom(password).equals(entry.getValue()));
//            return true;
//        }
//        return false;
//    }



















//    DBHelper dbHelper;// = new DBHelper(Helper.this);
//    SQLiteDatabase database;// = dbHelper.getWritableDatabase();
//    ContentValues contentValues;// = new ContentValues();
//    Cursor cursor;// = database.query(DBHelper.TABLE_USERS,null,null,null,null,null,null);


//    public Helper(Context context) {
//        try {
//            //DBHelper
//            dbHelper = new DBHelper(context);
//            Log.e("№№№", "Helper: "+dbHelper );
//            //SQLiteDatabase
//            database = dbHelper.getWritableDatabase();
//            Log.e("№№№", "database: "+database );
//
//            //ContentValues
//                    contentValues = new ContentValues(null);
//            //Cursor
//                    cursor = database.query(DBHelper.TABLE_USERS,null,null,null,null,null,null);
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//    }

//    SharedPreferences sharedPreferences;
//    SharedPreferences.Editor editor;
//    public Helper(Context context){
//        sharedPreferences = context.getSharedPreferences(Settings.FILE_NAME,Context.MODE_PRIVATE);
//        editor = sharedPreferences.edit();
//    }

                //Settings.setMail(emailRegistration.getText().toString(), sharedPreferences);
//                new Handler().postDelayed(new Runnable() {
//        @Override
//        public void run() {
//            Log.e("get mail", "run: " + Settings.getMail(sharedPreferences));
//        }
//    }, 1500);
//
//                break;

    public Helper(Context context){
        Settings.init(context);
    }


    //Добавление данных
    public void addUser1(String email, String password){

        Settings.setEmail(Settings.USER_MAIL, email);
        Settings.setPassword(Settings.USER_PASS, password);
    }

    //Проверка ввода одинаковых паролей
    public boolean equalPassword1(String password, String passwordConfirm){
        return md5.md5Custom(password).equals(md5.md5Custom(passwordConfirm));
    }

    //Валидатор минимальной длины пароля и email
    public boolean verificationLength1(String email, String password){
        return  (email.length() > 5 && password.length() > 3);
    }

    //Чистка базы данных
//    public void clearBd1(){
//        bd.clear();
//    }

    //Валидация email
    public final static boolean isValidEmail1(CharSequence target) {
        return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }

    //Проверка email на повторный ввод
    public boolean emailConfirm1(String email) {

        if (email.equals(Settings.getEmail(Settings.USER_MAIL))) {
            return false;
        }
//        Log.e("###", "emailConfirm1: "+cursor);
//        while (cursor.moveToNext()){
//            int emailIndex = cursor.getColumnIndex(DBHelper.EMAIL);
//
//            String currentEmail = cursor.getString(emailIndex);
//            email.equals(currentEmail);
//            return false;
//        }

//        for (int i = 0; i <cursor.getCount();i++){
//            currentEmail = cursor.getString(emailIndex);
//            email.equals(currentEmail);
//            return false;
//        }
//        cursor.close();
            return true;
    }

    //проверка что ключ и значение совпадают с введеными на первой странице

    public boolean userValid1(String email, String password){

        if (email.equals(Settings.getEmail(Settings.USER_MAIL))&&password.equals(Settings.getPassword(
                Settings.USER_PASS))){

            return true;
        }

//        while (cursor.moveToNext()){
//
//            int passwordIndex = cursor.getColumnIndex(DBHelper.PASSWORD);
//            int emailIndex = cursor.getColumnIndex(DBHelper.EMAIL);
//
//
//            String currentEmail = cursor.getString(emailIndex);
//            String currentPassword = cursor.getString(passwordIndex);
//
//            if (email.equals(currentEmail) && md5.md5Custom(password).equals(currentPassword));
//            return true;
//        }

//        for (int i = 0; i < cursor.getCount(); i++) {
//            currentEmail = cursor.getString(emailIndex);
//            currentPassword = cursor.getString(passwordIndex);
//
//            if (email.equals(currentEmail) && md5.md5Custom(password).equals(currentPassword));
//            return true;
//        }
//        cursor.close();
        return false;
    }
}
