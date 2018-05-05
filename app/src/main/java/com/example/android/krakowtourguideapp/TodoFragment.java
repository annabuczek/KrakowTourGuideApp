package com.example.android.krakowtourguideapp;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 */
public class TodoFragment extends Fragment {


    public TodoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.items_list_tabs, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //        Find View Pager in the parent Fragment Layout file
        ViewPager viewPager = view.findViewById(R.id.view_pager);

//        Get instance of Child Fragment Manager
        FragmentManager fragmentManager = getChildFragmentManager();

//        Create new instance of custom Tabs Adapter
        TodoAdapter tabsAdapter = new TodoAdapter(getActivity(), fragmentManager);

//        Set Tabs Adapter on View Pager
        viewPager.setAdapter(tabsAdapter);

//        Find Tab Layout in the parent Fragment Layout file
        TabLayout tabLayout = view.findViewById(R.id.tabs);

//        Setup Tab Layout with View Pager
        tabLayout.setupWithViewPager(viewPager);
    }
}
