package com.example.amazonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_already_costumer_login);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent openHome = new Intent(MainActivity.this,PilihNegara.class);
                startActivity(openHome);
                finish();
            }
        },3000);
    }
}