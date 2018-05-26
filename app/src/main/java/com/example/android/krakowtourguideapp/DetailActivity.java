package com.example.android.krakowtourguideapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ImageView photoImageView;
    private TextView titleTextView;
    private TextView descriptionTextView;
    private TextView addressTextView;
    private TextView phoneTextView;
    private TextView timeTextView;
    private LinearLayout timeView;
    private LinearLayout phoneView;
    private Button mapButton;
    private Button webButton;
    private Button phoneButton;

    private String geolocation;
    private String web;
    private String phone;

    public final String DETAIL_VIEW_1 = "detail_view_full";
    public final String DETAIL_VIEW_2 = "detail_view_less";
    public final String DETAIL_VIEW_3 = "detail_view_event";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //Call method to find views
        findViews();
//        Set custom Action Bar
        setSupportActionBar(toolbar);
//        Enable Up button on Action Bar
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);

//        Get Extras from Intent
        Intent i = getIntent();
        int attrImage = i.getIntExtra("ATTRACTION_IMG", 0);
        String attrTitle = i.getStringExtra("ATTRACTION_TITLE");
        String attrDescription = i.getStringExtra("ATTRACTION_DESCRIPTION");
        String attrAddress = i.getStringExtra("ATTRACTION_ADDRESS");
        String detailView = i.getStringExtra("DETAIL_VIEW");
        if (detailView.equalsIgnoreCase(DETAIL_VIEW_1)) {
            String attrPhone = i.getStringExtra("ATTRACTION_PHONE");
            geolocation = i.getStringExtra("ATTRACTION_GEO");
            phone = i.getStringExtra("ATTRACTION_PHONE_INTENT");
            web = i.getStringExtra("ATTRACTION_WEB");
            setDetailViewFull(attrImage, attrTitle, attrDescription, attrAddress, attrPhone);
        }
        else if (detailView.equalsIgnoreCase(DETAIL_VIEW_2)){
            geolocation = i.getStringExtra("ATTRACTION_GEO");
            setDetailViewLess(attrImage, attrTitle, attrDescription, attrAddress);
        }
        else {
            String attrTime = i.getStringExtra("ATTRACTION_TIME");
            web = i.getStringExtra("ATTRACTION_WEB");
            setDetailViewEvent(attrImage, attrTitle, attrDescription, attrAddress, attrTime);
        }

//        Set title of Action Bar as title of Attraction
        setTitle(attrTitle);

//        Set on click listener on map button
        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Open map with location after click on map button
                Intent mapIntent = new Intent(Intent.ACTION_VIEW);
                mapIntent.setData(Uri.parse(geolocation));
                mapIntent.setPackage("com.google.android.apps.maps");
                if (mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(mapIntent);
                }
            }
        });
//          Set on click listener on web button
        webButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Open sttraction website after click on web button
                Intent webIntent = new Intent(Intent.ACTION_VIEW);
                webIntent.setData(Uri.parse(web));
                if (webIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(webIntent);
                }
            }
        });
//Set on clisk listener on phone button
        phoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Open dial window after click on phone button
                Intent phoneIntent = new Intent(Intent.ACTION_DIAL);
                phoneIntent.setData(Uri.parse(phone));
                if (phoneIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(phoneIntent);
                }
            }
        });


    }

    @Override public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
//        Finish activity after click on the up button
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }

    /**
     * Helper method for finding all the needed views in activity_detail layout
     */
    public void findViews() {
        toolbar = findViewById(R.id.detail_toolbar);
        photoImageView = findViewById(R.id.detail_image_view);
        titleTextView = findViewById(R.id.detail_title);
        descriptionTextView = findViewById(R.id.detail_description);
        addressTextView = findViewById(R.id.detail_address_text_view);
        phoneTextView = findViewById(R.id.detail_phone_text_view);
        timeTextView = findViewById(R.id.detail_time_text_view);
        phoneView = findViewById(R.id.detail_phone_view);
        timeView = findViewById(R.id.detail_time_view);
        mapButton = findViewById(R.id.detail_button_map);
        webButton = findViewById(R.id.detail_button_web);
        phoneButton = findViewById(R.id.detail_button_phone);


    }

    /**
     * Method for populating views with data coming from intent extras.
     * Also set visibility for views depending on data provided by intent.
     * Method for Detail View with all information provided.
     * @param image image of the Attraction
     * @param title the name of the Attraction
     * @param description description of the Attraction
     * @param address address of the Attraction
     * @param phone phone number for the Attraction
     */
    public void setDetailViewFull(int image, String title, String description, String address, String phone) {
        photoImageView.setImageResource(image);
        titleTextView.setText(title);
        descriptionTextView.setText(description);
        addressTextView.setText(address);

        phoneView.setVisibility(View.VISIBLE);
        phoneTextView.setText(phone);
        webButton.setVisibility(View.VISIBLE);
        phoneButton.setVisibility(View.VISIBLE);


        timeView.setVisibility(View.GONE);

    }

    /**
     * Method for populating views with data coming from intent extras.
     * Also set visibility for views depending on data provided by intent.
     * Method for Detail View without phoneButton, webButton, and phoneTextView
     *
     * @param image image of the Attraction
     * @param title the name of the Attraction
     * @param description description of the Attraction
     * @param address address of the Attraction
     */
    public void setDetailViewLess(int image, String title, String description, String address) {
        photoImageView.setImageResource(image);
        titleTextView.setText(title);
        descriptionTextView.setText(description);
        addressTextView.setText(address);

        phoneView.setVisibility(View.GONE);
        webButton.setVisibility(View.GONE);
        phoneButton.setVisibility(View.GONE);
        timeView.setVisibility(View.GONE);
    }

    /**
     * Method for populating views with data coming from intent extras.
     * Also set visibility for views depending on data provided by intent.
     * Method for Detail View without phoneButton, mapButton, and phoneTextView
     * For events only with extra TextView for time
     *
     * @param image image of the Attraction
     * @param title the name of the Attraction
     * @param description description of the Attraction
     * @param address address of the Attraction
     * @param time time when the Attraction happens
     */
    public void setDetailViewEvent(int image, String title, String description, String address, String time) {
        photoImageView.setImageResource(image);
        titleTextView.setText(title);
        descriptionTextView.setText(description);
        addressTextView.setText(address);

        timeView.setVisibility(View.VISIBLE);
        timeTextView.setText(time);

        webButton.setVisibility(View.VISIBLE);

        mapButton.setVisibility(View.GONE);
        phoneButton.setVisibility(View.GONE);
        phoneView.setVisibility(View.GONE);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
//        Finish activity if user exit activity by back button instead of up button
        finish();
    }
}
