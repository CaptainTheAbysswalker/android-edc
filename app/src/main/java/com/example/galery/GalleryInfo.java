package com.example.galery;

import java.io.Serializable;
import java.util.ArrayList;

public class  GalleryInfo implements Serializable {
    String name;
    ImageInfo[] images;



    GalleryInfo(String name, ImageInfo[] images){

        this.name = name;
        this.images = images;
    }

    public String getName() {
        return name;
    }

    public ImageInfo[] getImages(){
        return images;
    }
}