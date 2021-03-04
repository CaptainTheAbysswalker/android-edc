package com.example.galery;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.galery.adapter.PreviewAdapter;

public class GalleryPreviewActivity extends AppCompatActivity {

    private RecyclerView galleryImages;
    private PreviewAdapter previewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_galery);
        initRecyclerView();

    }

    public void initRecyclerView(){
        galleryImages = findViewById(R.id.galery_list);
        galleryImages.setLayoutManager(new LinearLayoutManager(this));

        previewAdapter = new PreviewAdapter(this);

        galleryImages.setAdapter(previewAdapter);

    }

    public void onSelectGallery(View view) {
        Intent intent = new Intent(GalleryPreviewActivity.this, GalleryActivity.class);
        startActivity(intent);
    }


}
