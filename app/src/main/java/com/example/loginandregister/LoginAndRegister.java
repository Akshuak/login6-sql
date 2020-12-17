package com.example.loginandregister;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.loginandregister.Database.COLUMN_USER_ADRESS;
import static com.example.loginandregister.Database.COLUMN_USER_PHONENUMBER;
import static com.example.loginandregister.Database.COLUMN_USER_USERNAME;
import static com.example.loginandregister.Database.COLUMN_USER_EMAIL;
import static com.example.loginandregister.Database.COLUMN_USER_PASSWORD;
import static com.example.loginandregister.Database.TABLE_USERS;

public class LoginAndRegister extends AppCompatActivity implements View.OnClickListener {

        EditText username,email,password,adress,phone;
        Button register, login;
        StoreDatabase database;
        SQLiteDatabase sqLiteDatabase;
@Override
        protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        }
public  void initViews(){
        username = findViewById(R.id.username);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        adress = findViewById(R.id.adress);
        phone = findViewById(R.id.phone);

        register = findViewById(R.id.register);
        login = findViewById(R.id.login);

        register.setOnClickListener((this));
        login.setOnClickListener((this));

        database= new StoreDatabase(this);
        sqLiteDatabase= database.getWritableDatabase();

        }

@Override
public void onClick( View view ) {
        switch(view.getId()){
        case R.id.register:

        boolean register =true;

        if(username.getText().toString().isEmpty()){
        username.setError("Try again");
        register = false;
        }
        if(email.getText().toString().isEmpty()){
        email.setError("Try again");
        register = false;
        }
        if(password.getText().toString().isEmpty()){
        password.setError("Try again");
        register = false;
        }
                if(adress.getText().toString().isEmpty()){
                        adress.setError("Try again");
                        register = false;
                }
                if(phone.getText().toString().isEmpty()){
                        phone.setError("Try again");
                        register = false;
                }


        if(register){

                ContentValues userValue = new ContentValues();
                userValue.put(COLUMN_USER_USERNAME,username.getText().toString().isEmpty() );
                userValue.put(COLUMN_USER_EMAIL,email.getText().toString().isEmpty());
                userValue.put(COLUMN_USER_PASSWORD, password.getText().toString().isEmpty());
                userValue.put(COLUMN_USER_ADRESS,email.getText().toString().isEmpty());
                userValue.put(COLUMN_USER_PHONENUMBER, password.getText().toString().isEmpty());
                sqLiteDatabase.insert(TABLE_USERS, null, userValue);
        Toast.makeText(this,"Register success!", Toast.LENGTH_SHORT).show();
        }else {
        Toast.makeText(this,"Fill all info, try again!",Toast.LENGTH_SHORT).show();
        }
        break;
        case R.id.login:
        break;
        }

        }
        }
