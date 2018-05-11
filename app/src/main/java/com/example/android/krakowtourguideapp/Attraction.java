package com.example.android.krakowtourguideapp;

/**
 * Created by aania on 04.05.2018.
 */

public class Attraction {

    private String mTitle;
    private String mDescriptionShort;
    private int mImage;
    private String mIndicator;

    public Attraction(String indicator, String title, String descriptionShort, int image) {
        mIndicator = indicator;
        mTitle = title;
        mDescriptionShort = descriptionShort;
        mImage = image;
    }

    public String getIndicator() {
        return mIndicator;
    }

    public void setIndicator(String indicator) {
        this.mIndicator = indicator;
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
