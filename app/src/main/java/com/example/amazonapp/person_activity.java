package com.example.amazonapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

public class person_activity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);

        // Mengatur warna status bar (opsional)
        if(Build.VERSION.SDK_INT >= 21){
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.stBar));
        }

        // Setup Bottom Navigation
        bottomNavigationView = findViewById(R.id.bottomNavigationView4);
        bottomNavigationView.setSelectedItemId(R.id.person); // menandai tab 'person' aktif

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();

                if (itemId == R.id.home) {
                    Intent homeIntent = new Intent(person_activity.this, DetailItem.class);
                    startActivity(homeIntent);
                    return true;
                } else if (itemId == R.id.person) {
                    // Sudah di halaman ini
                    return true;
                } else if (itemId == R.id.cart) {
                    Intent cartIntent = new Intent(person_activity.this, Cart_Activity.class);
                    startActivity(cartIntent);
                    return true;
                } else if (itemId == R.id.list) {
                    Intent settingIntent = new Intent(person_activity.this, Setting.class);
                    startActivity(settingIntent);
                    return true;
                }
                return false;
            }
        });
    }
}
