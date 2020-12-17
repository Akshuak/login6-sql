package com.example.loginandregister;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class Database extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Registration.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_USERS = "user_store";

    public static final String COLUMN_USER_USERNAME = "user_username";
    public static final String COLUMN_USER_EMAIL = "user_email";
    public static final String COLUMN_USER_PASSWORD = "user_password";
    public static final String COLUMN_USER_ADRESS = "user_adress";
    public static final String COLUMN_USER_PHONENUMBER = "user_phonenumber";

    Context context;

    public Database (Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context=context;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE " + TABLE_USERS + "(" +
                COLUMN_USER_USERNAME + "TEXT," +
                COLUMN_USER_EMAIL + "TEXT," +
                COLUMN_USER_PASSWORD + "TEXT" +
                COLUMN_USER_ADRESS + "TEXT" +
                COLUMN_USER_PHONENUMBER+ "TEXT)" );
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);

        onCreate(db);
    }
}