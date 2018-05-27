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
import java.util.List;

/**
 * Created by aania on 06.05.2018.
 */

public class FavoritesFragment extends Fragment {

    public static final String FRAGMENT_ID = "favourites_fragment";
    public final String DETAIL_VIEW_1 = "detail_view_full";
    public final String DETAIL_VIEW_2 = "detail_view_less";
    SharedPreference sharedPreference;
    List<Attraction> favoritesList;
    private AttractionAdapter attractionAdapter;

    public FavoritesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sharedPreference = new SharedPreference();
//        Get favorite list of objects from saved with shared preferences
        favoritesList = sharedPreference.getFavorites(getActivity());

//        Create an instance of custom adapter
        attractionAdapter = new AttractionAdapter(getActivity(), favoritesList, true);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.items_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        if (favoritesList != null) {
//        Find List View within parent activity layout
            ListView listView = view.findViewById(R.id.list_view);
//        Set adapter to List View
            listView.setAdapter(attractionAdapter);

            //Set OnListItemClickListener to open detail activity while tapping on the list item.
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Attraction selectedAttraction = favoritesList.get(position);

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
                    } else if (selectedAttraction.getDetailView().equalsIgnoreCase(DETAIL_VIEW_2)) {
                        intent.putExtra("ATTRACTION_GEO", selectedAttraction.getGeoIntent());
                    } else {
                        intent.putExtra("ATTRACTION_WEB", selectedAttraction.getWebIntent());
                        intent.putExtra("ATTRACTION_TIME", selectedAttraction.getTime());
                    }
                    startActivity(intent);
                }
            });
        }
    }
}
