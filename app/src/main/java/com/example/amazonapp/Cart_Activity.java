package com.example.amazonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;

public class Cart_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        if(Build.VERSION.SDK_INT >= 21){
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.stBar));
        }

        // Initialize data
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
                R.drawable.buzz_light,
                R.drawable.woody,
                R.drawable.rc_car
        };

        boolean[] stockStatus = {
                true,  // Buzz in stock
                true,  // Woody in stock
                false  // RC Car out of stock
        };

        int[] itemQuantities = {
                1, // Quantity of Buzz
                2, // Quantity of Woody
                1  // Quantity of RC Car
        };

        // Initialize ListView
        ListView listViewCart = findViewById(R.id.listViewCart);
        gridCartItemAdapter adapter = new gridCartItemAdapter(
                this, productTitles, productPrices, productImages, stockStatus, itemQuantities);
        listViewCart.setAdapter(adapter);
    }
}