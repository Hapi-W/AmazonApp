package com.example.amazonapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Cart_Activity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        // Set status bar color
        if(Build.VERSION.SDK_INT >= 21){
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.stBar));
        }

        // Initialize cart data
        String[] productTitles = {
                "Buzz Lightyear Action Figure",
                "Woody Sheriff Doll",
                "RC Remote Control Car"
        };

        String[] productPrices = {
                "$25.99",
                "$19.99",
                "$35.50"
        };

        int[] productImages = {
                R.drawable.item_1,
                R.drawable.item_2,
                R.drawable.item_3
        };

        boolean[] stockStatus = {
                true,
                true,
                false
        };

        int[] itemQuantities = {
                1,
                2,
                1
        };

        // Initialize ListView
        ListView listViewCart = findViewById(R.id.listViewCart);
        gridCartItemAdapter adapter = new gridCartItemAdapter(
                this, productTitles, productPrices, productImages, stockStatus, itemQuantities);
        listViewCart.setAdapter(adapter);

        // Setup bottom navigation
        bottomNavigationView = findViewById(R.id.bottomNavigationView3);
        bottomNavigationView.setSelectedItemId(R.id.cart); // Set Cart as selected

        // Set up navigation item selection listener
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();

                if (itemId == R.id.home) {
                    Intent homeIntent = new Intent(Cart_Activity.this, Home.class);
                    startActivity(homeIntent);
                    return true;
                } else if (itemId == R.id.person) {
                    Intent profileIntent = new Intent(Cart_Activity.this, person_activity.class);
                    startActivity(profileIntent);
                    return true;
                } else if (itemId == R.id.cart) {
                    // Already on cart screen, do nothing
                    return true;
                } else if (itemId == R.id.list) {
                    Intent notificationIntent = new Intent(Cart_Activity.this, Setting.class);
                    startActivity(notificationIntent);
                    return true;
                }
                return false;
            }
        });
    }
}