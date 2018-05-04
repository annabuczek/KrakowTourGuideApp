package com.example.android.krakowtourguideapp;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

public class CategoryActivity extends AppCompatActivity {

    private Toolbar categoryToolbar;
    private ActionBar categoryActionBar;
    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        findViews();
//      Set Support Action Bar as created earlier ToolBar
        setSupportActionBar(categoryToolbar);
//      Enable and set custom menu button
        categoryActionBar = getSupportActionBar();
        categoryActionBar.setDisplayHomeAsUpEnabled(true);
        categoryActionBar.setHomeAsUpIndicator(R.drawable.ic_action_menu);

        setupNavigationDrawerContent(mNavigationView);
    }

    /**
     * Helper method for finding views
     */
    public void findViews() {
//      Find custom Toolbar within activity_category
        categoryToolbar = findViewById(R.id.category_toolbar);
//      Find Drawer Layout within activity_category
        mDrawerLayout = findViewById(R.id.drawer_layout);
//      Find Navigation View with categories within activity_category
        mNavigationView = findViewById(R.id.category_navigation_drawer);
    }


    //    Open Navigation Drawer when tapping on the menu button withing Action Bar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupNavigationDrawerContent(NavigationView navigationView) {
//        Set listener for Navigation Drawer menu items
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                selectNavigationDrawerContent(item);
                return true;
            }
        });
    }

    /**
     * Helper method for setting the behaviour when item from Navigation Drawer is selected.
     * @param menuItem is one of the menu items from Navigation Drawer
     */
    private void selectNavigationDrawerContent(MenuItem menuItem) {
        android.support.v4.app.Fragment fragment = null;

        switch(menuItem.getItemId()) {
//            Attach TopAttractionsFragment when menu item is selected by the user
            case R.id.nav_drawer_item_1:
                fragment = new TopAttractionsFragment();
                Log.v("CategoryActivity", "Switched to TopAttractionsFragment");
                break;
            case R.id.nav_drawer_item_2:
                fragment = new SightsFragment();
                Log.v("CategoryActivity", "Switched to SightsFragment");
                break;
            case R.id.nav_drawer_item_3:
                fragment = new FoodDrinkFragment();
                Log.v("CategoryActivity", "Switched to FoodDrinkFragment");
                break;
            case R.id.nav_drawer_item_4:
                fragment = new EventsFragment();
                Log.v("CategoryActivity", "Switched to EventsFragment");
                break;
            case R.id.nav_drawer_item_5:
                fragment = new TodoFragment();
                Log.v("CategoryActivity", "Switched to TodoFragment");
                break;
            case R.id.nav_drawer_item_6:
                break;
            case R.id.nav_drawer_item_7:
                break;
            default:
                fragment = new TopAttractionsFragment();
        }

//        Set Fragment as a content of selected menu item
            android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
            android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.category_fragment_content_frame, fragment);
            fragmentTransaction.commit();


//      Set item as selected to persist highlight
        menuItem.setChecked(true);
//      Set title of the menu item on the action bar
        setTitle(menuItem.getTitle());
//      Close drawer when menu item is tapped
        mDrawerLayout.closeDrawers();
    }
}
