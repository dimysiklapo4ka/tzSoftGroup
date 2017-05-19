package com.example.d1mys1klapo4ka.tz.activity.helper;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.example.d1mys1klapo4ka.tz.activity.settings.HelperSP;

/**
 * Created by d1mys1klapo4ka on 17.05.2017.
 */

public class Helper{

    //Для хеширования паролей
//    private MyCustomMD5 md5 = new MyCustomMD5();
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
//        sharedPreferences = context.getSharedPreferences(HelperSP.FILE_NAME,Context.MODE_PRIVATE);
//        editor = sharedPreferences.edit();
//    }

                //HelperSP.setMail(emailRegistration.getText().toString(), sharedPreferences);
//                new Handler().postDelayed(new Runnable() {
//        @Override
//        public void run() {
//            Log.e("get mail", "run: " + HelperSP.getMail(sharedPreferences));
//        }
//    }, 1500);
//
//                break;



    HelperSP helperSP = HelperSP.initialization();

    public Helper(Context context){
        helperSP.init(context);
    }
    //Добавление данных
    public void addUser1(String email, String password){

        helperSP.setUser(email, MyCustomMD5.md5Custom(password) );
    }

    //Проверка ввода одинаковых паролей
    public boolean equalPassword1(String password, String passwordConfirm){

        return MyCustomMD5.md5Custom(password).equals(MyCustomMD5.md5Custom(passwordConfirm));
    }

    //Валидатор минимальной длины пароля и email
    public boolean verificationLength1(String email, String password){

        return  (email.length() > 5 && password.length() > 3);
    }

    //Валидация email
    public final static boolean isValidEmail1(CharSequence target) {
        return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }

    //Проверка email на повторный ввод
    public boolean emailConfirm1(String email) {

        if (helperSP.settingSearch(email)) {

            return false;
        }

        return true;
    }

    //проверка что ключ и значение совпадают с введеными на первой странице
    public boolean userValid1(String email, String password){

        if (MyCustomMD5.md5Custom(password).equals(helperSP.getUser(email))){

            return true;
        }

        return false;
    }
}
