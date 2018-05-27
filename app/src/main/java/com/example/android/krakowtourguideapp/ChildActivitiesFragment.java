package com.example.android.krakowtourguideapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChildActivitiesFragment extends Fragment {

    public final String DETAIL_VIEW_1 = "detail_view_full";
    private AttractionAdapter attractionAdapter;
    private ArrayList<Attraction> activitiesList;

    public ChildActivitiesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        Create ArrayList of objects
        activitiesList = new ArrayList<Attraction>();

        activitiesList.add(new Attraction(R.drawable.activity1_shooting_img, getString(R.string.activity1_indicator), getString(R.string.activity1_title),
                getString(R.string.activity1_description_short), getString(R.string.activity1_description), getString(R.string.activity1_address),
                getString(R.string.activity1_phone), getString(R.string.activity1_phone_intent), getString(R.string.activity1_geo),
                getString(R.string.activity1_web), DETAIL_VIEW_1));
        activitiesList.add(new Attraction(R.drawable.activity2_axe_img, getString(R.string.activity2_indicator), getString(R.string.activity2_title),
                getString(R.string.activity2_description_short), getString(R.string.activity2_description), getString(R.string.activity2_address),
                getString(R.string.activity2_phone), getString(R.string.activity2_phone_intent), getString(R.string.activity2_geo),
                getString(R.string.activity2_web), DETAIL_VIEW_1));
        activitiesList.add(new Attraction(R.drawable.activity3_experience_img, getString(R.string.activity3_indicator), getString(R.string.activity3_title),
                getString(R.string.activity3_description_short), getString(R.string.activity3_description), getString(R.string.activity3_address),
                getString(R.string.activity3_phone), getString(R.string.activity3_phone_intent), getString(R.string.activity3_geo),
                getString(R.string.activity3_web), DETAIL_VIEW_1));
        activitiesList.add(new Attraction(R.drawable.activity4_kino_img, getString(R.string.activity4_indicator), getString(R.string.activity4_title),
                getString(R.string.activity4_description_short), getString(R.string.activity4_description), getString(R.string.activity4_address),
                getString(R.string.activity4_phone), getString(R.string.activity4_phone_intent), getString(R.string.activity4_geo),
                getString(R.string.activity4_web), DETAIL_VIEW_1));

//        Create instance of custom Adapter
        attractionAdapter = new AttractionAdapter(getActivity(), activitiesList, false);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.items_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        Find List View within parent activity layout
        ListView listView = view.findViewById(R.id.list_view);
//        Set adapter to List View
        listView.setAdapter(attractionAdapter);

        //        Set OnListItemClickListener to open detail activity while tapping on the list item.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Attraction selectedAttraction = activitiesList.get(position);

                Intent intent = new Intent(getActivity(), DetailActivity.class);
                intent.putExtra("ATTRACTION_IMG", selectedAttraction.getImage());
                intent.putExtra("ATTRACTION_TITLE", selectedAttraction.getTitle());
                intent.putExtra("ATTRACTION_DESCRIPTION", selectedAttraction.getDescription());
                intent.putExtra("ATTRACTION_ADDRESS", selectedAttraction.getAddress());
                intent.putExtra("DETAIL_VIEW", selectedAttraction.getDetailView());
                intent.putExtra("ATTRACTION_GEO", selectedAttraction.getGeoIntent());
                intent.putExtra("ATTRACTION_PHONE", selectedAttraction.getPhone());
                intent.putExtra("ATTRACTION_PHONE_INTENT", selectedAttraction.getPhoneIntent());
                intent.putExtra("ATTRACTION_WEB", selectedAttraction.getWebIntent());

                startActivity(intent);
            }
        });
    }

}
