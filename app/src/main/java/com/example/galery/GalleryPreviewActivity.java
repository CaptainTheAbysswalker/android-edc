package com.example.galery;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.galery.adapter.CuratedAdapter;
import com.example.galery.adapter.PreviewAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class GalleryPreviewActivity extends AppCompatActivity {

    private RecyclerView galleryImages;
    private RecyclerView curatedList;

    private PreviewAdapter previewAdapter;
    private CuratedAdapter curatedAdapter;

    private TextView galleryName;
    private String newName;
    private String jsonImages;
    private ImageInfo[] images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_galery);

        Bundle galleryData = getIntent().getExtras();
        if (galleryData != null) {
            newName = galleryData.getString("gallery");
            jsonImages = galleryData.getString("images");

        }

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

        images = gson.fromJson(jsonImages, ImageInfo[].class);

        galleryName = findViewById(R.id.gallery_name);
        galleryName.setText(newName);
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        initCuratedRecycler();
        initRecyclerView(images);

    }

    public void initCuratedRecycler(){
        curatedList = findViewById(R.id.curated_list);
        LinearLayoutManager horizontalLayoutRecycler
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        curatedList.setLayoutManager(horizontalLayoutRecycler);
        curatedAdapter = new CuratedAdapter(this);
        curatedList.setAdapter(curatedAdapter);
    }

    public void initRecyclerView(ImageInfo[] images){
        galleryImages = findViewById(R.id.galery_list);
        GridLayoutManager gridLayoutManager =
                new GridLayoutManager(this,2, GridLayoutManager.VERTICAL,false);

        galleryImages.setLayoutManager(gridLayoutManager);

        previewAdapter = new PreviewAdapter(this);

        galleryImages.setAdapter(previewAdapter);
        previewAdapter.setItems(images);
    }

    public void onSelectGallery(View view) {
        Intent intent = new Intent(GalleryPreviewActivity.this, GalleryActivity.class);
        startActivity(intent);
    }


}
