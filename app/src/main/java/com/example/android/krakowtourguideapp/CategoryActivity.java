package com.example.android.krakowtourguideapp;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class CategoryActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private Toolbar categoryToolbar;
    private ActionBar categoryActionBar;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

//        Find custom toolbar and set it as Action Bar
        categoryToolbar = findViewById(R.id.category_toolbar);
        setSupportActionBar(categoryToolbar);
//        Disable and set custom menu button
        categoryActionBar = getSupportActionBar();
        categoryActionBar.setDisplayHomeAsUpEnabled(true);
        categoryActionBar.setHomeAsUpIndicator(R.drawable.ic_action_menu);

        mDrawerLayout = findViewById(R.id.drawer_layout);

        navigationView = findViewById(R.id.category_navigation_drawer);
//        Set listener for navigation drawer menu items
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                Set item as selected to persist highlight
                item.setChecked(true);
//                Set title of the menu item on the action bar
                setTitle(item.getTitle());
//                Close drawer when menu item is tapped
                mDrawerLayout.closeDrawers();
                return true;
            }
        });
    }

//    Open drawer when tapping on menu icon
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
