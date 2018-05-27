package com.example.android.krakowtourguideapp;

import android.content.Intent;
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

import java.util.Set;

public class CategoryActivity extends AppCompatActivity {

    private Toolbar categoryToolbar;
    private ActionBar categoryActionBar;
    private BottomNavigationView bottomNavigationView;
    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;
    private android.support.v4.app.Fragment contentFragment;

    int navDrawerMenuItemId;
    int bottomNavMenuItemPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

//        Call method to find views
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

//        If there is no saved instance state, open HomeFragment
        if (savedInstanceState == null) {
            contentFragment = new HomeFragment();
            replaceFragment(contentFragment);
        }
//        else if (savedInstanceState != null) {
//            menuItemId = savedInstanceState.getInt("MENU_ITEM_ID");
//            mNavigationView.getMenu().findItem(menuItemId).setChecked(true);
//            setTitle(mNavigationView.getMenu().findItem(menuItemId).getTitle());
//        }

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

//      Get menuItem ID for further use
        navDrawerMenuItemId = menuItem.getItemId();
        switch(menuItem.getItemId()) {
//            Attach TopAttractionsFragment when menu item is selected by the user
            case R.id.nav_drawer_item_1:

//                Update content fragment variable
                contentFragment = new TopAttractionsFragment();
//                Set Fragment as a content of selected menu item
                replaceFragment(contentFragment);
//                Set title of Action Bar as the name of MenuItem
                setActionBarTitle(menuItem);
                break;

            case R.id.nav_drawer_item_2:

//                Update content fragment variable
                contentFragment = new SightsFragment();
//                Set Fragment as a content of selected menu item
                replaceFragment(contentFragment);
//                Set title of Action Bar as the name of MenuItem
                setActionBarTitle(menuItem);
                break;

            case R.id.nav_drawer_item_3:

//                Update content fragment variable
                contentFragment = new FoodDrinkFragment();
//                Set Fragment as a content of selected menu item
                replaceFragment(contentFragment);
//                Set title of Action Bar as the name of MenuItem
                setActionBarTitle(menuItem);
                break;

            case R.id.nav_drawer_item_4:

//                Update content fragment variable
                contentFragment = new EventsFragment();
//                Set Fragment as a content of selected menu item
                replaceFragment(contentFragment);
//                Set title of Action Bar as the name of MenuItem
                setActionBarTitle(menuItem);
                break;

            case R.id.nav_drawer_item_5:

//                Update content fragment variable
                contentFragment = new TodoFragment();
//                Set Fragment as a content of selected menu item
                replaceFragment(contentFragment);
//                Set title of Action Bar as the name of MenuItem
                setActionBarTitle(menuItem);
                break;

            case R.id.nav_drawer_item_6:

//                Update content fragment variable
                contentFragment = new AboutFragment();
//                Set Fragment as a content of selected menu item
                replaceFragment(contentFragment);
//                Set title of Action Bar as the name of MenuItem
                setActionBarTitle(menuItem);
                break;

            case R.id.nav_drawer_item_7:
//              Finish current activity
                finish();
                break;
        }

    }

    public void setBottomNavigation() {
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_bottom_item_1:

                        contentFragment = new HomeFragment();
                        bottomNavMenuItemPosition = 0;
//                        Remove highlight from Navigation Drawer Menu Item when HomeFragment is selected
                        mNavigationView.getMenu().findItem(navDrawerMenuItemId).setChecked(false);
                        break;
                    case R.id.nav_bottom_item_2:

                        bottomNavMenuItemPosition = 1;
                        contentFragment = new FavoritesFragment();
//                        Remove highlight from Navigation Drawer Menu Item when FavoriteFragment is selected
                        mNavigationView.getMenu().findItem(navDrawerMenuItemId).setChecked(false);
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

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("MENU_ITEM_ID", navDrawerMenuItemId);


    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        navDrawerMenuItemId = savedInstanceState.getInt("MENU_ITEM_ID");

//        Check which is actual content Fragment
        contentFragment = getSupportFragmentManager().findFragmentById(R.id.category_fragment_content_frame);
//        Set title and highlight on navDrawer depending on current fragment
        if (contentFragment instanceof HomeFragment) {
            setTitle(bottomNavigationView.getMenu().getItem(0).getTitle());
            mNavigationView.getMenu().findItem(navDrawerMenuItemId).setChecked(false);
        } else if (contentFragment instanceof FavoritesFragment) {
            mNavigationView.getMenu().findItem(navDrawerMenuItemId).setChecked(false);
            setTitle(bottomNavigationView.getMenu().getItem(1).getTitle());
        } else {
            mNavigationView.getMenu().findItem(navDrawerMenuItemId).setChecked(true);
            setTitle(mNavigationView.getMenu().findItem(navDrawerMenuItemId).getTitle());
        }
    }
}
