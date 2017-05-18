package com.example.d1mys1klapo4ka.tz.activity.helper;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;

import com.example.d1mys1klapo4ka.tz.activity.SecondActivity;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Created by d1mys1klapo4ka on 17.05.2017.
 */

public class Helper extends Activity{

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











    DBHelper dbHelper = new DBHelper(Helper.this);
    SQLiteDatabase database = dbHelper.getWritableDatabase();
    ContentValues contentValues = new ContentValues();
    Cursor cursor = database.query(DBHelper.TABLE_USERS,null,null,null,null,null,null);

    //Добавление данных
    public void addUser1(String email, String password){

        contentValues.put(DBHelper.EMAIL, email);
        contentValues.put(DBHelper.PASSWORD, md5.md5Custom(password));

        database.insert(DBHelper.TABLE_USERS,null,contentValues);
        cursor.close();
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


    public boolean emailConfirm1(String email){

        int emailIndex = cursor.getColumnIndex(DBHelper.EMAIL);

        while (cursor.moveToNext()){

            String currentEmail = cursor.getString(emailIndex);
            email.equals(currentEmail);
            return false;
        }

//        for (int i = 0; i <cursor.getCount();i++){
//            currentEmail = cursor.getString(emailIndex);
//            email.equals(currentEmail);
//            return false;
//        }
        cursor.close();
        return true;
    }

    //проверка что ключ и значение совпадают с введеными на первой странице

    public boolean userValid1(String email, String password){

        int passwordIndex = cursor.getColumnIndex(DBHelper.PASSWORD);
        int emailIndex = cursor.getColumnIndex(DBHelper.EMAIL);

        while (cursor.moveToNext()){

            String currentEmail = cursor.getString(emailIndex);
            String currentPassword = cursor.getString(passwordIndex);

            if (email.equals(currentEmail) && md5.md5Custom(password).equals(currentPassword));
            return true;
        }

//        for (int i = 0; i < cursor.getCount(); i++) {
//            currentEmail = cursor.getString(emailIndex);
//            currentPassword = cursor.getString(passwordIndex);
//
//            if (email.equals(currentEmail) && md5.md5Custom(password).equals(currentPassword));
//            return true;
//        }
        cursor.close();
        return false;
    }
}
