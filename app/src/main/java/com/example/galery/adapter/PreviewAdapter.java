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
import com.example.galery.GalleryPreviewActivity;
import com.example.galery.R;



public class PreviewAdapter extends RecyclerView.Adapter<PreviewAdapter.PreviewViewHolder> {

    private Context mContext;
    String[] elements = {"1st gal", "2st gal", "3rd gal"};




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
        holder.bind(elements[position]);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, GalleryActivity.class);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 3;
    }



    class PreviewViewHolder extends RecyclerView.ViewHolder{

        private TextView text;
        private ImageView image;
        public PreviewViewHolder(@NonNull View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.gallery_item_text);
            image = itemView.findViewById(R.id.gallery_item_image);
        }


        public void bind(String element) {

        }


    }
}