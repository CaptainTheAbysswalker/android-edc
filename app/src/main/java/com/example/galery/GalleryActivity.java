package com.example.galery;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.StatefulAdapter;

import com.example.galery.adapter.GalleryAdapter;

public class GalleryActivity extends AppCompatActivity {

    private ImageInfo imageInfo;
    private TextView artist;
    private TextView description;
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_image_description);

        Bundle imageData = getIntent().getExtras();
        imageInfo = (ImageInfo) imageData.getSerializable("image");

        artist = findViewById(R.id.info_artist);
        description = findViewById(R.id.info_description);
        image = findViewById(R.id.image_full);

        image.setImageResource(imageInfo.getSrc());
        artist.setText(imageInfo.getArtist());
        description.setText(imageInfo.getDescription());
    }

}
