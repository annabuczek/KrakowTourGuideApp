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
public class ChildAroundFragment extends Fragment {

    private AttractionAdapter attractionAdapter;
    private ArrayList<Attraction> aroundList;
    public final String DETAIL_VIEW_1 = "detail_view_full";
    public final String DETAIL_VIEW_2 = "detail_view_less";

    public ChildAroundFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        Create ArrayList of objects
        aroundList= new ArrayList<Attraction>();

        aroundList.add(new Attraction(R.drawable.around1_auschwitz_img, getString(R.string.around1_indicator), getString(R.string.around1_title),
                getString(R.string.around1_description_short), getString(R.string.around1_description), getString(R.string.around1_address),
                getString(R.string.around1_phone), getString(R.string.around1_phone_intent), getString(R.string.around1_geo),
                getString(R.string.around1_web), DETAIL_VIEW_1));
        aroundList.add(new Attraction(R.drawable.around2_zakopane_img, getString(R.string.around2_indicator), getString(R.string.around2_title),
                getString(R.string.around2_description_short), getString(R.string.around2_description), getString(R.string.around2_address),
                getString(R.string.around2_geo), DETAIL_VIEW_2));
        aroundList.add(new Attraction(R.drawable.around3_ojcow_img, getString(R.string.around3_indicator), getString(R.string.around3_title),
                getString(R.string.around3_description_short), getString(R.string.around3_description), getString(R.string.around3_address),
                getString(R.string.around3_geo), DETAIL_VIEW_2));
        aroundList.add(new Attraction(R.drawable.around3_tatry_img, getString(R.string.around4_indicator), getString(R.string.around4_title),
                getString(R.string.around4_description_short), getString(R.string.around4_description), getString(R.string.around4_address),
                getString(R.string.around4_phone), getString(R.string.around4_phone_intent), getString(R.string.around4_geo),
                getString(R.string.around4_web), DETAIL_VIEW_1));
        aroundList.add(new Attraction(R.drawable.around5_czestochowa_img, getString(R.string.around5_indicator), getString(R.string.around5_title),
                getString(R.string.around5_description_short), getString(R.string.around5_description), getString(R.string.around5_address),
                getString(R.string.around5_phone), getString(R.string.around5_phone_intent), getString(R.string.around5_geo),
                getString(R.string.around5_web), DETAIL_VIEW_1));

//        Create instance of custom Adapter
        attractionAdapter = new AttractionAdapter(getActivity(), aroundList);

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
                Attraction selectedAttraction = aroundList.get(position);

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
                    intent.putExtra("ATTRACTION_GEO", selectedAttraction.getGeoIntent());
                }
                startActivity(intent);
            }
        });
    }

}
