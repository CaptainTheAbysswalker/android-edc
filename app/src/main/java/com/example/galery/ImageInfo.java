package com.example.galery;

import java.io.Serializable;

public class ImageInfo implements Serializable {
    Integer src;
    String artist;
    String size;
    String description;

    public ImageInfo(Integer src, String artist, String size, String description){
        this.src = src;
        this.artist = artist;
        this.size = size;
        this.description = description;
    }

    public Integer getSrc() {
        return src;
    }

    public String getArtist() {
        return artist;
    }

    public String getDescription() {
        return description;
    }

    public String getSize() {
        return size;
    }
}
