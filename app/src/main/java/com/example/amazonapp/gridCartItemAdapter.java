package com.example.amazonapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;

public class gridCartItemAdapter extends BaseAdapter {
    // Application context
    private Context context;

    // Arrays to store data
    private String[] productTitles;
    private String[] productPrices;
    private int[] productImages;
    private boolean[] stockStatus;
    private int[] itemQuantities;

    // Constructor
    public gridCartItemAdapter(Context context, String[] productTitles, String[] productPrices,
                           int[] productImages, boolean[] stockStatus, int[] itemQuantities) {
        this.context = context;
        this.productTitles = productTitles;
        this.productPrices = productPrices;
        this.productImages = productImages;
        this.stockStatus = stockStatus;
        this.itemQuantities = itemQuantities;
    }

    // Returns the number of items
    @Override
    public int getCount() {
        return productTitles.length;
    }

    // Gets item at specific position
    @Override
    public Object getItem(int position) {
        return productTitles[position];
    }

    // Gets item ID
    @Override
    public long getItemId(int position) {
        return position;
    }

    // Creates and configures the view for each cart item
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // ViewHolder for performance optimization
        ViewHolder holder;

        // If view isn't inflated yet, inflate layout
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.grid_cart_items, parent, false);

            // Initialize holder
            holder = new ViewHolder();
            holder.cardView = convertView.findViewById(R.id.cardView);
            holder.productImage = convertView.findViewById(R.id.cartImg);
            holder.checkBox = convertView.findViewById(R.id.checkBox2);
            holder.productTitle = convertView.findViewById(R.id.cartTitle);
            holder.productPrice = convertView.findViewById(R.id.cartPrice);
            holder.returnStatus = convertView.findViewById(R.id.textView28);
            holder.stockStatus = convertView.findViewById(R.id.textView27);
            holder.quantityText = convertView.findViewById(R.id.textView22);
            holder.increaseButton = convertView.findViewById(R.id.imageView13);
            holder.decreaseButton = convertView.findViewById(R.id.imageView14);
            holder.compareButton = convertView.findViewById(R.id.itemDisc);
            holder.deleteButton = convertView.findViewById(R.id.textView30);
            holder.saveButton = convertView.findViewById(R.id.textView31);

            // Save holder to view
            convertView.setTag(holder);
        } else {
            // Use existing holder
            holder = (ViewHolder) convertView.getTag();
        }

        // Set data for each view
        holder.productImage.setImageResource(productImages[position]);
        holder.productTitle.setText(productTitles[position]);
        holder.productPrice.setText(productPrices[position]);

        // Set stock status
        if (stockStatus[position]) {
            holder.stockStatus.setText("In stock");
            holder.stockStatus.setTextColor(context.getResources().getColor(R.color.hijau));
        } else {
            holder.stockStatus.setText("Out of stock");
            holder.stockStatus.setTextColor(context.getResources().getColor(android.R.color.holo_red_dark));
        }

        // Set item quantity
        holder.quantityText.setText(String.valueOf(itemQuantities[position]));

        // Set listener for increase button
        holder.increaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (stockStatus[position]) {
                    itemQuantities[position]++;
                    holder.quantityText.setText(String.valueOf(itemQuantities[position]));
                    notifyDataSetChanged();
                } else {
                    Toast.makeText(context, "Product not available", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Set listener for decrease button
        holder.decreaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (itemQuantities[position] > 1) {
                    itemQuantities[position]--;
                    holder.quantityText.setText(String.valueOf(itemQuantities[position]));
                    notifyDataSetChanged();
                } else {
                    Toast.makeText(context, "Minimum 1 item", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Set listener for compare button
        holder.compareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Comparing " + productTitles[position] + " with similar items",
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Set listener for delete button
        holder.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Removing " + productTitles[position], Toast.LENGTH_SHORT).show();
                // Add logic to remove item from cart here
            }
        });

        // Set listener for save button
        holder.saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Saving " + productTitles[position] + " for later",
                        Toast.LENGTH_SHORT).show();
                // Add logic to save item for later here
            }
        });

        // Set checkbox
        holder.checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            // Add logic when checkbox is checked/unchecked
            if (isChecked) {
                Toast.makeText(context, productTitles[position] + " selected", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, productTitles[position] + " unselected", Toast.LENGTH_SHORT).show();
            }
        });

        return convertView;
    }

    // ViewHolder class to improve ListView performance
    private static class ViewHolder {
        CardView cardView;
        ImageView productImage;
        CheckBox checkBox;
        TextView productTitle;
        TextView productPrice;
        TextView returnStatus;
        TextView stockStatus;
        TextView quantityText;
        ImageView increaseButton;
        ImageView decreaseButton;
        TextView compareButton;
        TextView deleteButton;
        TextView saveButton;
    }
}