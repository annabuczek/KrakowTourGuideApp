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
public class ChildRestaurantsFragment extends Fragment {

    public final String DETAIL_VIEW_1 = "detail_view_full";
    private AttractionAdapter attractionAdapter;
    private ArrayList<Attraction> restaurantsList;

    public ChildRestaurantsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        Create ArrayList of objects
        restaurantsList = new ArrayList<Attraction>();

        restaurantsList.add(new Attraction(R.drawable.top1_wawel_img, getString(R.string.restaurant1_indicator), getString(R.string.restaurant1_title),
                getString(R.string.restaurant1_description_short), getString(R.string.restaurant1_description), getString(R.string.restaurant1_address),
                getString(R.string.restaurant1_phone), getString(R.string.restaurant1_phone_intent), getString(R.string.restaurant1_geo),
                getString(R.string.restaurant1_web), DETAIL_VIEW_1));
        restaurantsList.add(new Attraction(R.drawable.top1_wawel_img, getString(R.string.restaurant2_indicator), getString(R.string.restaurant2_title),
                getString(R.string.restaurant2_description_short), getString(R.string.restaurant2_description), getString(R.string.restaurant2_address),
                getString(R.string.restaurant2_phone), getString(R.string.restaurant2_phone_intent), getString(R.string.restaurant2_geo),
                getString(R.string.restaurant2_web), DETAIL_VIEW_1));
        restaurantsList.add(new Attraction(R.drawable.top1_wawel_img, getString(R.string.restaurant3_indicator), getString(R.string.restaurant3_title),
                getString(R.string.restaurant3_description_short), getString(R.string.restaurant3_description), getString(R.string.restaurant3_address),
                getString(R.string.restaurant3_phone), getString(R.string.restaurant3_phone_intent), getString(R.string.restaurant3_geo),
                getString(R.string.restaurant3_web), DETAIL_VIEW_1));
        restaurantsList.add(new Attraction(R.drawable.top1_wawel_img, getString(R.string.restaurant4_indicator), getString(R.string.restaurant4_title),
                getString(R.string.restaurant4_description_short), getString(R.string.restaurant4_description), getString(R.string.restaurant4_address),
                getString(R.string.restaurant4_phone), getString(R.string.restaurant4_phone_intent), getString(R.string.restaurant4_geo),
                getString(R.string.restaurant4_web), DETAIL_VIEW_1));

//        Create instance of custom Adapter
        attractionAdapter = new AttractionAdapter(getActivity(), restaurantsList);

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
                Attraction selectedAttraction = restaurantsList.get(position);

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
