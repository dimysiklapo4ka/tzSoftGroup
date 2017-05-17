package com.example.d1mys1klapo4ka.tz.activity.helper;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by d1mys1klapo4ka on 17.05.2017.
 */

public class Helper {

    Map<String,String> bd = new HashMap<>();

    public void addBd (String email, String password){
            bd.put(email, password);
    }

    public boolean equalBd(String email, String password){
        return email.equals(password);
    }

    public boolean bdValid(String email, String password){
        return  (email.length() > 5 && password.length() > 3);
    }

    public void clearBd(){
        bd.clear();
    }
}
