package com.example.amazonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void already_acc (View v) {
        Intent openAlready = new Intent(login.this, already_costumer_login.class);
        startActivity(openAlready);
    }

    public void toRegist (View v) {
        Intent openRegist = new Intent(login.this, Register.class);
        startActivity(openRegist);
    }

    public void toSkipLogin (View v) {
        Intent openSkipLogin = new Intent(login.this, Home.class);
        startActivity(openSkipLogin);
    }


}