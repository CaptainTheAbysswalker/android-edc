package com.example.galery.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.galery.ImageInfo;
import com.example.galery.R;


public class CuratedAdapter extends RecyclerView.Adapter<CuratedAdapter.CuratedViewHolder> {

    private Context mContext;



    public CuratedAdapter(Context context){
        mContext = context;
    }
    @NonNull
    @Override
    public CuratedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_curated, parent, false);
        return new CuratedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CuratedViewHolder holder, int position) {

    }


    @Override
    public int getItemCount() {
        return 8;
    }



    static class CuratedViewHolder extends RecyclerView.ViewHolder{

        private TextView text;
        private ImageView image;
        public CuratedViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.gallery__preview_image);
        }

        public void bind(ImageInfo element) {
            image.setImageResource(element.getSrc());
        }


    }
}