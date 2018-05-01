package com.example.android.krakowtourguideapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LaunchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);

//        Find button in activity_launch layout
        Button startButton = findViewById(R.id.launch_ac_button);
//        Set OnClickListener for performing an action
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Start CategoryActivity by clicking on the button
                Intent i = new Intent(LaunchActivity.this, CategoryActivity.class);
                startActivity(i);
            }
        });
    }
}
