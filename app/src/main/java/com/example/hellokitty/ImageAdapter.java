package com.example.hellokitty;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hellokitty.model.Image;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {
    private ArrayList<Image> images;

    public ImageAdapter() {
        images = new ArrayList<>();
    }

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView sourceUrlTextView;
        public ImageView imageView;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            sourceUrlTextView = (TextView) itemView.findViewById(R.id.textview);
            imageView = (ImageView) itemView.findViewById(R.id.imageview);
        }
    }

    // Usually involves inflating a layout from XML and returning the holder
    @Override
    public ImageAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View imageView = inflater.inflate(R.layout.item_layout, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(imageView);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(ImageAdapter.ViewHolder viewHolder, int position) {
        // Get the data model based on position
        Image image = images.get(position);

        TextView sourceUrlTextView = viewHolder.sourceUrlTextView;
        sourceUrlTextView.setText(image.getSourceUrl());

        ImageView imageView = viewHolder.imageView;
        Picasso.with(imageView.getContext()).load(image.getUrl()).into(imageView);
    }

    // Return the total count of items
    @Override
    public int getItemCount() {
        return images.size();
    }

    public void addImage(Image image) {
        images.add(image);
        notifyItemInserted(getItemCount());
    }
}
