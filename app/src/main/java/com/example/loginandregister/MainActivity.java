package com.example.loginandregister;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText username,email,password;
    Button register, login;

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

        register = findViewById(R.id.register);
        login = findViewById(R.id.login);

        register.setOnClickListener((this));
        login.setOnClickListener((this));
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


                if(register){
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