package com.example.amazonapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

public class Setting extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        // Setup bottom navigation
        bottomNavigationView = findViewById(R.id.bottomNavigationView5);
        bottomNavigationView.setSelectedItemId(R.id.list); // Menandai tab 'list' sebagai aktif

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();

                if (itemId == R.id.home) {
                    Intent homeIntent = new Intent(Setting.this, DetailItem.class);
                    startActivity(homeIntent);
                    return true;
                } else if (itemId == R.id.person) {
                    Intent profileIntent = new Intent(Setting.this, person_activity.class);
                    startActivity(profileIntent);
                    return true;
                } else if (itemId == R.id.cart) {
                    Intent cartIntent = new Intent(Setting.this, Cart_Activity.class);
                    startActivity(cartIntent);
                    return true;
                } else if (itemId == R.id.list) {
                    // Sudah di halaman Setting
                    return true;
                }
                return false;
            }
        });
    }
}
