package com.example.android.krakowtourguideapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aania on 06.05.2018.
 */

public class FavoritesFragment extends Fragment {

    public static final String FRAGMENT_ID = "favourites_fragment";
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
        favoritesList = sharedPreference.getFavorites(getActivity());

        attractionAdapter = new AttractionAdapter(getActivity(), favoritesList);

////        Create ArrayList of objects
//        ArrayList<Attraction> topAttractionsList= new ArrayList<Attraction>();
//
//        topAttractionsList.add(new Attraction("Wawel", "Kraków Castle", R.drawable.placeholder_card_view_image));
//        topAttractionsList.add(new Attraction("Wawel", "Kraków Castle", R.drawable.placeholder_card_view_image));
//        topAttractionsList.add(new Attraction("Wawel", "Kraków Castle", R.drawable.placeholder_card_view_image));
//        topAttractionsList.add(new Attraction("Wawel", "Kraków Castle", R.drawable.placeholder_card_view_image));
//        topAttractionsList.add(new Attraction("Wawel", "Kraków Castle", R.drawable.placeholder_card_view_image));

//        Create instance of custom Adapter
//        attractionAdapter = new AttractionAdapter(getActivity(), topAttractionsList);

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
        }
    }
}
