package com.example.d1mys1klapo4ka.tz.activity.helper;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Created by d1mys1klapo4ka on 17.05.2017.
 */

public class Helper {
    //Для хеширования паролей
    MyCustomMD5 md5 = new MyCustomMD5();
    //Хранение пароля и email в виде ключа
    Map<String,String> bd = new HashMap<>();
    //Добавление данных
    public void addBd (String email, String password){
            bd.put(email, md5.md5Custom(password));
    }
    //Проверка ввода одинаковых паролей
    public boolean equalBd(String password, String passwordConfirm){
        return md5.md5Custom(password).equals(md5.md5Custom(passwordConfirm));
    }
    //Валидатор минимальной длины пароля и email
    public boolean bdValid(String email, String password){
        return  (email.length() > 5 && password.length() > 3);
    }
    //Чистка базы данных
    public void clearBd(){
        bd.clear();
    }
    //Валидация email
    public boolean emailValid(String email){
        Pattern pattern = Pattern.compile("^[-a-z0-9!#$%&'*+/=?^_`{|}~]+" +
                "(\\.[-a-z0-9!#$%&'*+/=?^_`{|}~]+)*@([a-z0-9]([-a-z0-9]{0,61}[a-z0-9])?\\.)*" +
                "(aero|arpa|gmail|ru|ua|asia|biz|cat|com|coop|edu|gov|info|int|jobs|mil|mobi|museum|name|net" +
                "|org|pro|tel|travel|[a-z][a-z])$\n");
        if (pattern.matcher(email).matches()){
            return true;
        }
        return false;
    }
    //Проверка email на повторный ввод
    public boolean emailConfirm(String email){
//        for (int i = 0; i <bd.size();i++){
//            email.equals(bd.get(i));
//            return false;
//        }
//        return true;
        return bd.containsKey(email);
    }

    public boolean passwordConfirm(String password){
//        for (int i = 0; i <bd.size();i++){
//            password.equals(bd.);
//            return false;
//        }
//        return true;
        return bd.containsValue(password);
    }

    public boolean validConfirm(String email, String password){
        for (Map.Entry entry : bd.entrySet()) {
//            System.out.println("Key: " + entry.getKey() + " Value: "
//                    + entry.getValue());
            if (email.equals(entry.getKey()) && md5.md5Custom(password).equals(entry.getValue()));
            return false;
        }
        return true;
    }
}
