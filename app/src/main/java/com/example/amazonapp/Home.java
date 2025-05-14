package com.example.amazonapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Home extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Set status bar color
        if(Build.VERSION.SDK_INT >= 21){
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.stBar));
        }

        // Setup bottom navigation
        bottomNavigationView = findViewById(R.id.bottomNavigationView2);
        bottomNavigationView.setSelectedItemId(R.id.home); // Set Home as selected by default

        // Set up navigation item selection listener
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();

                if (itemId == R.id.home) {
                    // Already on home screen, do nothing or refresh
                    return true;
                } else if (itemId == R.id.person) {
                    // Navigate to Profile/Person screen
                    Intent profileIntent = new Intent(Home.this, person_activity.class);
                    startActivity(profileIntent);
                    return true;
                } else if (itemId == R.id.cart) {
                    // Navigate to Cart screen
                    Intent cartIntent = new Intent(Home.this, Cart_Activity.class);
                    startActivity(cartIntent);
                    return true;
                } else if (itemId == R.id.list) {
                    // Navigate to Notifications/List screen
                    Intent notificationIntent = new Intent(Home.this, Setting.class);
                    startActivity(notificationIntent);
                    return true;
                }
                return false;
            }
        });

        // Set up grid items
        int[] cimg ={
                R.drawable.item_1,
                R.drawable.item_2,
                R.drawable.item_4,
                R.drawable.item_5,
        };
        String[] cname = {
                "Buzz",
                "Woody",
                "Boneka",
                "Robot",
        };
        String[] cdisc = {
                "30% off",
                "25% off",
                "20% off",
                "15% off",
        };
        String[] ctime = {
                "Ends in 16:07:01",
                "Ends in 12:08:01",
                "Ends in 7:09:01",
                "Ends in 3:10:01",
        };

        gridItemAdapter gridItemAdapter = new gridItemAdapter(Home.this, cdisc, ctime, cimg);
        GridView gridItem = findViewById(R.id.griditem);

        gridItem.setAdapter(gridItemAdapter);

        // Handle grid item clicks
        gridItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent openItem = new Intent(Home.this, DetailItem.class);

                openItem.putExtra("image", cimg[position]);
                openItem.putExtra("name", cname[position]);
                openItem.putExtra("disc", cdisc[position]);
                openItem.putExtra("time", ctime[position]);

                startActivity(openItem);
            }
        });
    }

    // This method is kept for backward compatibility with any existing onClick attributes
    public void openCart(View v){
        Intent toCart = new Intent(Home.this, Cart_Activity.class);
        startActivity(toCart);
    }
}