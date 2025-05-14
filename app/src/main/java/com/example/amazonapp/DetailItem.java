package com.example.amazonapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class DetailItem extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_item);

        BottomNavigationView bot_nav = findViewById(R.id.bottomNavigationView);
        bot_nav.setSelectedItemId(R.id.home);

        bot_nav.setOnNavigationItemSelectedListener(item -> {
            if (item.getItemId() == R.id.home) {
                startActivity(new Intent(DetailItem.this, Home.class));
                finish();
                return true;
            } else if (item.getItemId() == R.id.person) {
                return true;
            } else if (item.getItemId() == R.id.cart) {
                startActivity(new Intent(DetailItem.this, Cart_Activity.class));
                finish();
                return true;
            } else {
                startActivity(new Intent(DetailItem.this, Setting.class));
                finish();
                return true;
            }
        });
    }

    public void toastAdd(View v) {
        Toast.makeText(DetailItem.this, "Telah Ditambahkan", Toast.LENGTH_SHORT).show();
    }
}
