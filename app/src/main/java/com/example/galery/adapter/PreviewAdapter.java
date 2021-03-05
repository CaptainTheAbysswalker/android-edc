package com.example.galery.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.galery.GalleryActivity;
import com.example.galery.ImageInfo;
import com.example.galery.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class PreviewAdapter extends RecyclerView.Adapter<PreviewAdapter.PreviewViewHolder> {
    private List<ImageInfo> imgData = new ArrayList<>();
    private Context mContext;
    private ImageInfo imageElement;


    public PreviewAdapter(Context context){
        mContext = context;
    }
    @NonNull
    @Override
    public PreviewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_galery_images, parent, false);
        return new PreviewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PreviewViewHolder holder, int position) {
        holder.bind(imgData.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageElement = imgData.get(position);
                Intent intent = new Intent(mContext, GalleryActivity.class);
                intent.putExtra("image", imageElement);
                mContext.startActivity(intent);
            }
        });
    }

    public void setItems(ImageInfo[] images){
        Collections.addAll(imgData, images);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return imgData.size();
    }



    class PreviewViewHolder extends RecyclerView.ViewHolder{

        private TextView text;
        private ImageView image;
        public PreviewViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.gallery__preview_image);
        }

        public void bind(ImageInfo element) {
           image.setImageResource(element.getSrc());
        }


    }
}