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

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class SightsFragment extends Fragment {

    private AttractionAdapter attractionAdapter;
    private ArrayList<Attraction> sightsList;
    public final String DETAIL_VIEW_1 = "detail_view_full";
    public final String DETAIL_VIEW_2 = "detail_view_less";

    public SightsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        Create ArrayList of objects
        sightsList= new ArrayList<Attraction>();

        sightsList.add(new Attraction(R.drawable.sight1_barbakan_img, getString(R.string.sight1_indicator), getString(R.string.sight1_title),
                getString(R.string.sight1_description_short), getString(R.string.sight1_description), getString(R.string.sight1_address),
                getString(R.string.sight1_phone), getString(R.string.sight1_phone_intent), getString(R.string.sight1_geo),
                getString(R.string.sight1_web), DETAIL_VIEW_1));
        sightsList.add(new Attraction(R.drawable.sight2_brama_img, getString(R.string.sight2_indicator), getString(R.string.sight2_title),
                getString(R.string.sight2_description_short), getString(R.string.sight2_description), getString(R.string.sight2_address),
                getString(R.string.sight2_geo), DETAIL_VIEW_2));
        sightsList.add(new Attraction(R.drawable.sight3_mound_img, getString(R.string.sight3_indicator), getString(R.string.sight3_title),
                getString(R.string.sight3_description_short), getString(R.string.sight3_description), getString(R.string.sight3_address),
                getString(R.string.sight3_phone), getString(R.string.sight3_phone_intent), getString(R.string.sight3_geo),
                getString(R.string.sight3_web), DETAIL_VIEW_1));
        sightsList.add(new Attraction(R.drawable.sight4_dragon_img, getString(R.string.sight4_indicator), getString(R.string.sight4_title),
                getString(R.string.sight4_description_short), getString(R.string.sight4_description), getString(R.string.sight4_address),
                getString(R.string.sight4_geo), DETAIL_VIEW_2));

//        Create instance of custom Adapter
        attractionAdapter = new AttractionAdapter(getActivity(), sightsList, false);

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
                Attraction selectedAttraction = sightsList.get(position);

                Intent intent = new Intent(getActivity(), DetailActivity.class);
                intent.putExtra("ATTRACTION_IMG", selectedAttraction.getImage());
                intent.putExtra("ATTRACTION_TITLE", selectedAttraction.getTitle());
                intent.putExtra("ATTRACTION_DESCRIPTION", selectedAttraction.getDescription());
                intent.putExtra("ATTRACTION_ADDRESS", selectedAttraction.getAddress());
                intent.putExtra("DETAIL_VIEW", selectedAttraction.getDetailView());
                if (selectedAttraction.getDetailView().equalsIgnoreCase(DETAIL_VIEW_1)) {
                    intent.putExtra("ATTRACTION_GEO", selectedAttraction.getGeoIntent());
                    intent.putExtra("ATTRACTION_PHONE", selectedAttraction.getPhone());
                    intent.putExtra("ATTRACTION_PHONE_INTENT", selectedAttraction.getPhoneIntent());
                    intent.putExtra("ATTRACTION_WEB", selectedAttraction.getWebIntent());
                }
                else {
                    intent.putExtra("ATTRACTION_GEO", selectedAttraction.getGeoIntent());}

                startActivity(intent);
            }
        });
    }

}
