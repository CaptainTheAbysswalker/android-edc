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
        RecyclerView galleryList = findViewById(R.id.home_galery);
        galleryList.setLayoutManager(new LinearLayoutManager(this));
    }

    public void onBackClick(View view){
        Intent intent = new Intent(HomeActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public void onSelectGallery(View view) {
        Intent intent = new Intent(HomeActivity.this, GalleryActivity.class);
        startActivity(intent);
    }
}
