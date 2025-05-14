package com.example.amazonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class already_costumer_login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_already_costumer_login);
    }
    public void toHome (View v) {
        Intent openHome = new Intent(already_costumer_login.this, Home.class);
        startActivity(openHome);
    }
}