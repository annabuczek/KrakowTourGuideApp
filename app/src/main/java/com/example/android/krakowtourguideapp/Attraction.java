package com.example.android.krakowtourguideapp;

/**
 * Created by aania on 04.05.2018.
 */

public class Attraction {

    private String mIndicator;
    private String mTitle;
    private String mDescriptionShort;
    private String mDescription;
    private String mAddress;
    private String mPhone;
    private String mTime;
    private String mPhoneIntent;
    private String mGeoIntent;
    private String mWebIntent;
    private String mDetailView;
    private int mImage;


    public Attraction(int image, String indicator, String title, String descriptionShort,
                      String description, String address, String phone, String phoneIntent,
                      String geoIntent, String webIntent, String detailView) {
        mImage = image;
        mIndicator = indicator;
        mTitle = title;
        mDescriptionShort = descriptionShort;
        mDescription = description;
        mAddress = address;
        mPhone = phone;
        mPhoneIntent = phoneIntent;
        mGeoIntent = geoIntent;
        mWebIntent = webIntent;
        mDetailView = detailView;
    }

    public Attraction(int image, String indicator, String title, String descriptionShort,
                      String description, String address, String geoIntent, String detailView) {
        mImage = image;
        mIndicator = indicator;
        mTitle = title;
        mDescriptionShort = descriptionShort;
        mDescription = description;
        mAddress = address;
        mGeoIntent = geoIntent;
        mDetailView = detailView;
    }

    public Attraction(int image, String indicator, String title, String descriptionShort,
                      String description, String address, String time,
                      String webIntent, String detailView) {
        mImage = image;
        mIndicator = indicator;
        mTitle = title;
        mDescriptionShort = descriptionShort;
        mDescription = description;
        mAddress = address;
        mTime = time;
        mWebIntent = webIntent;
        mDetailView = detailView;
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

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public String getAddress() {
        return mAddress;
    }

    public void setAddress(String address) {
        mAddress = address;
    }

    public String getPhone() {
        return mPhone;
    }

    public void setPhone(String phone) {
        mPhone = phone;
    }

    public String getTime() {
        return mTime;
    }

    public void setTime(String time) {
        mTime = time;
    }

    public String getPhoneIntent() {
        return mPhoneIntent;
    }

    public void setPhoneIntent(String phoneIntent) {
        mPhoneIntent = phoneIntent;
    }

    public String getGeoIntent() {
        return mGeoIntent;
    }

    public void setGeoIntent(String geoIntent) {
        mGeoIntent = geoIntent;
    }

    public String getWebIntent() {
        return mWebIntent;
    }

    public void setWebIntent(String webIntent) {
        mWebIntent = webIntent;
    }

    public String getDetailView() {
        return mDetailView;
    }

    public void setDetailView(String detailView) {
        mDetailView = detailView;
    }
}
