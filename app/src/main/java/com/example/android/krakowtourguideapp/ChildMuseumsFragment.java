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
public class ChildMuseumsFragment extends Fragment {

    public final String DETAIL_VIEW_1 = "detail_view_full";
    private AttractionAdapter attractionAdapter;
    private ArrayList<Attraction> museumsList;

    public ChildMuseumsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        Create ArrayList of objects
        museumsList = new ArrayList<Attraction>();

        museumsList.add(new Attraction(R.drawable.museum1_national_img, getString(R.string.museum1_indicator), getString(R.string.museum1_title),
                getString(R.string.museum1_description_short), getString(R.string.museum1_description), getString(R.string.museum1_address),
                getString(R.string.museum1_phone), getString(R.string.museum1_phone_intent), getString(R.string.museum1_geo),
                getString(R.string.museum1_web), DETAIL_VIEW_1));
        museumsList.add(new Attraction(R.drawable.museum2_schindler_img, getString(R.string.museum2_indicator), getString(R.string.museum2_title),
                getString(R.string.museum2_description_short), getString(R.string.museum2_description), getString(R.string.museum2_address),
                getString(R.string.museum2_phone), getString(R.string.museum2_phone_intent), getString(R.string.museum2_geo),
                getString(R.string.museum2_web), DETAIL_VIEW_1));
        museumsList.add(new Attraction(R.drawable.museum3_mocak_img, getString(R.string.museum3_indicator), getString(R.string.museum3_title),
                getString(R.string.museum3_description_short), getString(R.string.museum3_description), getString(R.string.museum3_address),
                getString(R.string.museum3_phone), getString(R.string.museum3_phone_intent), getString(R.string.museum3_geo),
                getString(R.string.museum3_web), DETAIL_VIEW_1));
        museumsList.add(new Attraction(R.drawable.museum4_sukiennice_img, getString(R.string.museum4_indicator), getString(R.string.museum4_title),
                getString(R.string.museum4_description_short), getString(R.string.museum4_description), getString(R.string.museum4_address),
                getString(R.string.museum4_phone), getString(R.string.museum4_phone_intent), getString(R.string.museum4_geo),
                getString(R.string.museum4_web), DETAIL_VIEW_1));
        museumsList.add(new Attraction(R.drawable.museum5_historyczne_img, getString(R.string.museum5_indicator), getString(R.string.museum5_title),
                getString(R.string.museum5_description_short), getString(R.string.museum5_description), getString(R.string.museum5_address),
                getString(R.string.museum5_phone), getString(R.string.museum5_phone_intent), getString(R.string.museum5_geo),
                getString(R.string.museum5_web), DETAIL_VIEW_1));

//        Create instance of custom Adapter
        attractionAdapter = new AttractionAdapter(getActivity(), museumsList, false);

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
                Attraction selectedAttraction = museumsList.get(position);

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
