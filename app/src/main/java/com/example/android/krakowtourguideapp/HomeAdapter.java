package com.example.android.krakowtourguideapp;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by aania on 05.05.2018.
 */

public class HomeAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public HomeAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new ChildOverviewFragment();
        } else if (position == 1) {
            return new ChildHistoryFragment();
        } else {
            return new ChildInfoFragment();
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
            return mContext.getString(R.string.tab_overview);
        } else if (position == 1) {
            return mContext.getString(R.string.tab_history);
        } else {
            return mContext.getString(R.string.tab_info);
        }

    }
}
