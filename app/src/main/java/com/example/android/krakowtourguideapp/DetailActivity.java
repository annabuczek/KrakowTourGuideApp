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
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ImageView photoImageView;
    private TextView titleTextView;
    private TextView descriptionTextView;
    private TextView addressTextView;
    private TextView phoneTextView;
    private Button mapButton;
    private Button webButton;
    private Button phoneButton;

    private String geolocation;
    private String web;
    private String phone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        findViews();
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);

        geolocation = "geo:50.054249,19.935402";
        web = "https://wawel.krakow.pl";
        phone = "tel:124225155";



        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mapIntent = new Intent(Intent.ACTION_VIEW);
                mapIntent.setData(Uri.parse(geolocation));
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

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
        mapButton = findViewById(R.id.detail_button_map);
        webButton = findViewById(R.id.detail_button_web);
        phoneButton = findViewById(R.id.detail_button_phone);

    }

    public void fillViews() {
            }




}
