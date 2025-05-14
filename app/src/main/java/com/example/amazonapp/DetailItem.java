package com.example.amazonapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailItem extends AppCompatActivity {
    TextView detailTittle, detailDisc,detailEnd;
    ImageView detailImg;

    private BottomNavigationView bottomNavigationView; // ✅ Dideklarasikan di sini

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_item);

        if(Build.VERSION.SDK_INT >= 21){
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.stBar));
        }
        //identifier
        detailImg = findViewById(R.id.detailImg);
        detailTittle = findViewById(R.id.detailTittle);
        detailDisc = findViewById(R.id.detailDisc);
        detailEnd = findViewById(R.id.detailEnd);



        String name = getIntent().getStringExtra("name");
        String disc = getIntent().getStringExtra("disc");
        int image = getIntent().getIntExtra("image",0);
        String time = getIntent().getStringExtra("time");

        detailImg.setImageResource(image);
        detailTittle.setText(name);
        detailDisc.setText(disc);
        detailEnd.setText(time);

        // Setup bottom navigation
        bottomNavigationView = findViewById(R.id.bottomNavigationView3);
        bottomNavigationView.setSelectedItemId(R.id.home); // Set Home as selected

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();

                if (itemId == R.id.home) {
                    // Sudah di halaman DetailItem (bisa dianggap Home)
                    return true;
                } else if (itemId == R.id.person) {
                    Intent profileIntent = new Intent(DetailItem.this, person_activity.class); // ✅ Fix
                    startActivity(profileIntent);
                    return true;
                } else if (itemId == R.id.cart) {
                    Intent cartIntent = new Intent(DetailItem.this, Cart_Activity.class); // ✅ Fix
                    startActivity(cartIntent);
                    return true;
                } else if (itemId == R.id.list) {
                    Intent notificationIntent = new Intent(DetailItem.this, Setting.class); // ✅ Fix
                    startActivity(notificationIntent);
                    return true;
                }
                return false;
            }
        });
    }

    public void toastAdd(View v) {
        Toast.makeText(DetailItem.this, "Telah Ditambahkan", Toast.LENGTH_SHORT).show();
    }

    public void backHome(View v){
        Intent toHome = new Intent(DetailItem.this, Home.class);
        startActivity(toHome);
    }
}
