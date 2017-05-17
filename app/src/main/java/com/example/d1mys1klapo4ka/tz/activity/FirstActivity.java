package com.example.d1mys1klapo4ka.tz.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.d1mys1klapo4ka.tz.R;
import com.example.d1mys1klapo4ka.tz.activity.helper.Helper;

/**
 * 1. при нажатии кнопки Регистрация переход на второе активити
 * 2. по нажатию кнопки Войти проверяются введенные данные во втором активити
 * если да то переход на третье активити.
 * если нет выводим Тост или снекбак с текстом "Неверный логин и/или пароль".
 * */
public class FirstActivity extends AppCompatActivity implements View.OnClickListener{

    private Button come, registration;
    private EditText email,password;

    private Helper helper = new Helper();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        come = (Button)findViewById(R.id.bt_come);
        registration = (Button)findViewById(R.id.bt_registration);
        email = (EditText)findViewById(R.id.et_email);
        password = (EditText)findViewById(R.id.et_password);

        come.setOnClickListener(this);
        registration.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.bt_come:
                //if (helper.email.)
                intent = new Intent(FirstActivity.this, ThirdActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_registration:
                intent = new Intent(FirstActivity.this, SecondActivity.class);
                startActivity(intent);
                break;
        }
    }
}
