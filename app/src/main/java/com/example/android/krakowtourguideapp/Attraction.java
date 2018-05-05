package com.example.android.krakowtourguideapp;

/**
 * Created by aania on 04.05.2018.
 */

public class Attraction {

    private String mTitle;
    private String mDescriptionShort;
    private int mImage;

    public Attraction(String title, String descriptionShort, int image) {
        mTitle = title;
        mDescriptionShort = descriptionShort;
        mImage = image;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getDescriptionShort() {
        return mDescriptionShort;
    }

    public void setDescriptionShort(String descriptionShort) {
        mDescriptionShort = descriptionShort;
    }

    public int getImage() {
        return mImage;
    }

    public void setImage(int image) {
        mImage = image;
    }
}
