package com.example.android.krakowtourguideapp;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by aania on 05.05.2018.
 */

public class TodoAdapter extends FragmentPagerAdapter {
    private Context mContext;

    public TodoAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new ChildMuseumsFragment();
        } else if (position == 1) {
            return new ChildActivitiesFragment();
        } else {
            return new ChildAroundFragment();
        }
    }

    @Override
    public int getCount () {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle ( int position){
        if (position == 0) {
            return mContext.getString(R.string.tab_museums);
        } else if (position == 1) {
            return mContext.getString(R.string.tab_activities);
        } else {
            return mContext.getString(R.string.tab_around);
        }

    }
}

