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
public class ChildClubsFragment extends Fragment {

    public final String DETAIL_VIEW_1 = "detail_view_full";
    private AttractionAdapter attractionAdapter;
    private ArrayList<Attraction> clubsList;

    public ChildClubsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        Create ArrayList of objects
        clubsList = new ArrayList<Attraction>();

        clubsList.add(new Attraction(R.drawable.club1_szpitalna_img, getString(R.string.club1_indicator), getString(R.string.club1_title),
                getString(R.string.club1_description_short), getString(R.string.club1_description), getString(R.string.club1_address),
                getString(R.string.club1_phone), getString(R.string.club1_phone_intent), getString(R.string.club1_geo),
                getString(R.string.club1_web), DETAIL_VIEW_1));
        clubsList.add(new Attraction(R.drawable.club2_choice_img, getString(R.string.club2_indicator), getString(R.string.club2_title),
                getString(R.string.club2_description_short), getString(R.string.club2_description), getString(R.string.club2_address),
                getString(R.string.club2_phone), getString(R.string.club2_phone_intent), getString(R.string.club2_geo),
                getString(R.string.club2_web), DETAIL_VIEW_1));
        clubsList.add(new Attraction(R.drawable.club3_four_img, getString(R.string.club3_indicator), getString(R.string.club3_title),
                getString(R.string.club3_description_short), getString(R.string.club3_description), getString(R.string.club3_address),
                getString(R.string.club3_phone), getString(R.string.club3_phone_intent), getString(R.string.club3_geo),
                getString(R.string.club3_web), DETAIL_VIEW_1));
        clubsList.add(new Attraction(R.drawable.club4_cubano_img, getString(R.string.club4_indicator), getString(R.string.club4_title),
                getString(R.string.club4_description_short), getString(R.string.club4_description), getString(R.string.club4_address),
                getString(R.string.club4_phone), getString(R.string.club4_phone_intent), getString(R.string.club4_geo),
                getString(R.string.club4_web), DETAIL_VIEW_1));

//        Create instance of custom Adapter
        attractionAdapter = new AttractionAdapter(getActivity(), clubsList);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.items_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//          Find List View within parent activity layout
        ListView listView = view.findViewById(R.id.list_view);
//        Set adapter to List View
        listView.setAdapter(attractionAdapter);

        //        Set OnListItemClickListener to open detail activity while tapping on the list item.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Attraction selectedAttraction = clubsList.get(position);

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
