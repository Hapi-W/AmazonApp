package com.example.amazonapp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class gridItemAdapter extends BaseAdapter {
    Context context;

    String[] title,price;
    int [] image;


    public gridItemAdapter(Context context, String[] title, String[] price, int[] image){
        this.context = context;
        this.title = title;
        this.price = price;
        this.image = image;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
