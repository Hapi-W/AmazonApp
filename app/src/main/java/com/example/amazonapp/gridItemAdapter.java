package com.example.amazonapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class gridItemAdapter extends BaseAdapter{
    Context context;

    String[] disc, time;

    int[] image;
    LayoutInflater inflater;

    public gridItemAdapter(Context context, String[] time, String[] disc, int[] image) {
        this.context = context;
        this.time = time;
        this.disc = disc;
        this.image = image;
    }
    @Override
    public int getCount() {
        return disc.length;
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
        if(inflater == null)
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(convertView == null)
            convertView = inflater.inflate(R.layout.grid_item_layout, null);

        ImageView itemImg = convertView.findViewById(R.id.itemImg);
        TextView itemDisc = convertView.findViewById(R.id.itemDisc);
        TextView timeEnd = convertView.findViewById(R.id.timeEnd);

        itemImg.setImageResource(image[position]);
        itemDisc.setText(disc[position]);
        timeEnd.setText(time[position]);

        return convertView;
    }
}
