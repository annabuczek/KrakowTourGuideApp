package com.example.android.krakowtourguideapp;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
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
    private BottomNavigationView bottomNavigationView;
    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;
    private android.support.v4.app.Fragment contentFragment;

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

//        Set listeners for Navigation Drawer and Bottom Navigation View
        setupNavigationDrawerContent(mNavigationView);
        setBottomNavigation();

        if (savedInstanceState == null) {
            contentFragment = new HomeFragment();
            replaceFragment(contentFragment);

        }

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
//        Find Bottom Navigation View
        bottomNavigationView = findViewById(R.id.bottom_nv_view);
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

        switch(menuItem.getItemId()) {
//            Attach TopAttractionsFragment when menu item is selected by the user
            case R.id.nav_drawer_item_1:
                contentFragment = new TopAttractionsFragment();
                Log.v("CategoryActivity", "Switched to TopAttractionsFragment");
                break;
            case R.id.nav_drawer_item_2:
                contentFragment = new SightsFragment();
                Log.v("CategoryActivity", "Switched to SightsFragment");
                break;
            case R.id.nav_drawer_item_3:
                contentFragment = new FoodDrinkFragment();
                Log.v("CategoryActivity", "Switched to FoodDrinkFragment");
                break;
            case R.id.nav_drawer_item_4:
                contentFragment = new EventsFragment();
                Log.v("CategoryActivity", "Switched to EventsFragment");
                break;
            case R.id.nav_drawer_item_5:
                contentFragment = new TodoFragment();
                Log.v("CategoryActivity", "Switched to TodoFragment");
                break;
            case R.id.nav_drawer_item_6:

                break;
            case R.id.nav_drawer_item_7:
                break;
            default:
                contentFragment = new TopAttractionsFragment();
        }

//        Set Fragment as a content of selected menu item
            replaceFragment(contentFragment);
            setActionBarTitle(menuItem);

    }

    public void setBottomNavigation() {
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_bottom_item_1:
                        contentFragment = new HomeFragment();
                        break;
                    case R.id.nav_bottom_item_2:
                        contentFragment = new FavoritesFragment();
                        break;

                }
                replaceFragment(contentFragment);
                setActionBarTitle(item);
                return true;
            }
        });
    }

    /**
     * Helper method for displaying Fragment on the screen
     * @param fragment is instance of Fragment class
     */
    public void replaceFragment(Fragment fragment) {

        android.support.v4.app.FragmentManager fragmentManager;
        android.support.v4.app.FragmentTransaction fragmentTransaction;
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.category_fragment_content_frame, fragment);
        fragmentTransaction.commit();
    }

    public void setActionBarTitle (MenuItem menuItem) {
        //      Set item as selected to persist highlight
        menuItem.setChecked(true);
        //      Set title of the menu item on the action bar
        setTitle(menuItem.getTitle());
//      Close drawer when menu item is tapped
        mDrawerLayout.closeDrawers();
    }
}
