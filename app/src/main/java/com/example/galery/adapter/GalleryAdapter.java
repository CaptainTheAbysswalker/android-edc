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

import com.example.galery.GalleryInfo;
import com.example.galery.GalleryPreviewActivity;
import com.example.galery.ImageInfo;
import com.example.galery.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.GalleryViewHolder> {
    private List<GalleryInfo> galData = new ArrayList<>();
    private Context mContext;
    private String galleryName;
    private ImageInfo[] galleryImages;

    @NonNull
    @Override
    public GalleryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.gallery_item, parent, false);
        return new GalleryViewHolder(view);
    }

    public GalleryAdapter(Context context){
        mContext= context;
    }

    @Override
    public void onBindViewHolder(@NonNull GalleryViewHolder holder, int position) {
        holder.bind(galData.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                galleryName = galData.get(position).getName();
                galleryImages = galData.get(position).getImages();

                GsonBuilder builder = new GsonBuilder();
                Gson gson = builder.create();


                Intent intent = new Intent(mContext, GalleryPreviewActivity.class);
                intent.putExtra("gallery", galleryName);
                intent.putExtra("images", gson.toJson(galleryImages));
                mContext.startActivity(intent);
            }
        });
    }


    public void setItems(GalleryInfo[] galleries){
        Collections.addAll(galData, galleries);
    }


    @Override
    public int getItemCount() {
        return galData.size();
    }

    class GalleryViewHolder extends RecyclerView.ViewHolder{

        private TextView text;
        private ImageView preview;
        private ImageView preview_2;
        private ImageView preview_3;
        public GalleryViewHolder(@NonNull View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.gallery_item_text);
            preview = itemView.findViewById(R.id.gallery__preview_image);
            preview_2=itemView.findViewById(R.id.gallery_preview_image_2);
            preview_3=itemView.findViewById(R.id.gallery_preview_image_3);
        }


        public void bind(GalleryInfo element) {

            text.setText(element.getName());
            preview.setImageResource(element.getImages()[0].getSrc());
            preview_2.setImageResource(element.getImages()[1].getSrc());
            preview_3.setImageResource(element.getImages()[2].getSrc());
        }
    }
}
