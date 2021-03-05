package com.example.galery;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.StatefulAdapter;

import com.example.galery.adapter.GalleryAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    private ImageInfo[] images;
    ImageInfo image1 = new ImageInfo(
            R.drawable.nito,
            "Nito",
            "12x16” (30.5x40.6 cm)",
            "Nito, the first of the dead, is one of the original Lords who found " +
                    "a Lord Soul at the dawn of the Age of Fire. His soul turned him into a" +
                    " living manifestation of illness and death, a mass of skeletons held " +
                    "together. He, along with the other Lords, waged war against the Dragons, " +
                    "and helped issue the killing blow by unleashing a miasma of death and " +
                    "disease upon them."
    );
    ImageInfo image2 = new ImageInfo(
            R.drawable.artorias,
            "Artorias",
            "12x16” (30.5x40.6 cm)",
            "Sir Artorias the Abysswalker was one of the Four Knights of Lord Gwyn." +
                    " He only makes an appearance in the past, as he is deceased by the time " +
                    "the Chosen Undead escapes the Undead Asylum."
    );
    ImageInfo image3 = new ImageInfo(
            R.drawable.ornstein,
            "Ornstein",
            "12x16” (30.5x40.6 cm)",
            "Ornstein was one of Lord Gwyn's most trusted knights, who was also" +
                    " loyal to Lord Gwyn's Firstborn. Believed to be the captain of the " +
                    "Four Knights of Gwyn, he was granted a special soul and ring by the" +
                    " Lord of Sunlight."
    );
    ImageInfo image4 = new ImageInfo(
            R.drawable.gwyn,
            "Gwyn",
            "12x16” (30.5x40.6 cm)",
            "Lord Gwyn wears an impressive set of royal drapes, with gold bands " +
                    "on his arms, and a crown atop his head. On his feet are what appear to" +
                    " be a form of moccasins and anklets, and he wields a greatsword imbued " +
                    "with the power of light and of the First Flame, which he uses to adequate " +
                    "effect. His face is that of an aged man with calm eyes, and he has an" +
                    " impressively long, grey beard and hair of the same nature. When the Chosen" +
                    " Undead fights Gwyn in the Kiln of the First Flame, Gwyn appears to be " +
                    "Hollow, evident by his haggard appearance, charred skin and missing eyes."
    );

    ImageInfo image21 = new ImageInfo(
            R.drawable.img1,
            "ArtistName",
            "12x16” (30.5x40.6 cm)",
            "Description"
    );
    ImageInfo image22 = new ImageInfo(
            R.drawable.img2,
            "ArtistName",
            "12x16” (30.5x40.6 cm)",
            "Description"
    );
    ImageInfo image23 = new ImageInfo(
            R.drawable.img3,
            "ArtistName",
            "12x16” (30.5x40.6 cm)",
            "Description"
    );
    ImageInfo image24 = new ImageInfo(
            R.drawable.img4,
            "ArtistName",
            "12x16” (30.5x40.6 cm)",
            "Description"
    );


    public ImageButton backButton;
    private RecyclerView galleryList;
    private GalleryAdapter galleryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ImageInfo[] images = {image1,image2,image3,image4};
        ImageInfo[] images2 = {image21,image22, image23,image24};

        GalleryInfo gallery1 = new GalleryInfo(
                "DS", images);
        GalleryInfo gallery2 = new GalleryInfo(
                "paintings",
                images2);

        GalleryInfo[] allGalleries = new GalleryInfo[]{gallery1, gallery2};


        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_home);
        backButton = findViewById(R.id.back_galery);
        backButton.setOnClickListener(this::onBackClick);

        initRecyclerView(allGalleries);

    }

    private void initRecyclerView(GalleryInfo[] gallery) {
        galleryList = findViewById(R.id.home_galery);
        galleryList.setLayoutManager(new LinearLayoutManager(this));
        galleryAdapter = new GalleryAdapter(this);
        galleryList.setAdapter(galleryAdapter);
        galleryAdapter.setItems(gallery);
    }

    public void onBackClick(View view){
        Intent intent = new Intent(HomeActivity.this, MainActivity.class);
        startActivity(intent);
    }

}
