package com.example.amazonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridView;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        if(Build.VERSION.SDK_INT >= 21){
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        int[] cimg ={
                R.drawable.item_1,
                R.drawable.item_2,
                R.drawable.item_4,
                R.drawable.item_5,

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

        gridItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent openItem = new Intent(Home.this, DetailItem.class);

                openItem.putExtra("image", cimg[position]);
                openItem.putExtra("disc", cdisc[position]);
                openItem.putExtra("time", ctime[position]);

                startActivity(openItem);
            }
        });
    }
    public void openCart(View v){
        Intent toCart = new Intent(Home.this,Cart_Activity.class);
        startActivity(toCart);
    }
}