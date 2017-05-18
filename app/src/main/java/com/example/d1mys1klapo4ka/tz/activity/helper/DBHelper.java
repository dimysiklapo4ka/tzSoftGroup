package com.example.d1mys1klapo4ka.tz.activity.helper;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import android.util.Log;

import java.util.Map;

/**
 * Created by d1mys1klapo4ka on 18.05.2017.
 */

public class DBHelper extends SQLiteOpenHelper{

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "user.db";
    public static final String TABLE_USERS = "users";

    public static final String ID = "_id";
    public static final String EMAIL = "email";
    public static final String PASSWORD = "password";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL("create table " + TABLE_USERS + " (" + ID + " integer primary key, " + EMAIL + " text, " +
    PASSWORD + " text " + ")");
        Log.e("###", "onCreate: table created" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("drop table if exists " + TABLE_USERS);
        onCreate(db);
    }
}
