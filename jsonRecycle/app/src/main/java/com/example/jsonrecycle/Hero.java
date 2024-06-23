package com.example.jsonrecycle;
public class Hero {
    private String name;
    private String imageurl;

    public Hero(String name, String imageurl) {
        this.name = name;
        this.imageurl = imageurl;
    }

    public String getName() {
        return name;
    }

    public String getImageurl() {
        return imageurl;
    }
}
