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

        findViews();
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);

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

        setTitle(attrTitle);

        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mapIntent = new Intent(Intent.ACTION_VIEW);
                mapIntent.setData(Uri.parse(geolocation));
                mapIntent.setPackage("com.google.android.apps.maps");
                if (mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(mapIntent);
                }
            }
        });

        webButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent webIntent = new Intent(Intent.ACTION_VIEW);
                webIntent.setData(Uri.parse(web));
                if (webIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(webIntent);
                }
            }
        });

        phoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }

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




}
