package com.example.amazonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PilihNegara extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilih_negara);

    }
    public void toLogin (View v) {
        Intent openLogin = new Intent(PilihNegara.this, login.class);
        startActivity(openLogin);
    }
}