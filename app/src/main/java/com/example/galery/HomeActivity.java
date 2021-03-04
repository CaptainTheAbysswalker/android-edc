package com.example.galery;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.StatefulAdapter;

import com.example.galery.adapter.GalleryAdapter;

public class HomeActivity extends AppCompatActivity {

    public ImageButton backButton;
    public LinearLayout selectGal;
    private RecyclerView galleryList;
    private GalleryAdapter galleryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_home);

        backButton = findViewById(R.id.back_galery);
        backButton.setOnClickListener(this::onBackClick);
        selectGal = findViewById(R.id.item);

        selectGal.setOnClickListener(this::onSelectGallery);
        initRecyclerView();

    }

    private void initRecyclerView() {
        galleryList = findViewById(R.id.home_galery);
        galleryList.setLayoutManager(new LinearLayoutManager(this));
        galleryAdapter = new GalleryAdapter();
        galleryList.setAdapter(galleryAdapter);
    }

    public void onBackClick(View view){
        Intent intent = new Intent(HomeActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public void onSelectGallery(View view) {
        Intent intent = new Intent(HomeActivity.this, GalleryPreviewActivity.class);
        startActivity(intent);
    }
}
