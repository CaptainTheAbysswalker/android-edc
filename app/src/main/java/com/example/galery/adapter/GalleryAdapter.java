package com.example.galery.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.galery.R;

import java.util.ArrayList;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.GalleryViewHolder> {

    String[] elements = {"1st gal", "2st gal", "3rd gal"};


    @NonNull
    @Override
    public GalleryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.gallery_item, parent, false);
        return new GalleryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GalleryViewHolder holder, int position) {
        holder.bind(elements[position]);
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    class GalleryViewHolder extends RecyclerView.ViewHolder{

        private TextView text;
        private ImageView image;
        public GalleryViewHolder(@NonNull View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.gallery_item_text);
            image = itemView.findViewById(R.id.gallery_item_image);
        }


        public void bind(String element) {
            text.setText(element);
        }
    }
}
