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

/**
 * A simple {@link Fragment} subclass.
 */
public class SightsFragment extends Fragment {

    private AttractionAdapter attractionAdapter;

    public SightsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        Create ArrayList of objects
        ArrayList<Attraction> sightsList= new ArrayList<Attraction>();

        sightsList.add(new Attraction("sights1", "Jakiś kopiec", "Tu będą atrakcje", R.drawable.placeholder_card_view_image));
        sightsList.add(new Attraction("sights2", "Jakiś kopiec", "Tu będą atrakcje", R.drawable.placeholder_card_view_image));
        sightsList.add(new Attraction("sights3", "Jakiś kopiec", "Tu będą atrakcje", R.drawable.placeholder_card_view_image));
        sightsList.add(new Attraction("sights4", "Jakiś kopiec", "Tu będą atrakcje", R.drawable.placeholder_card_view_image));
        sightsList.add(new Attraction("sights5", "Jakiś kopiec", "Tu będą atrakcje", R.drawable.placeholder_card_view_image));

//        Create instance of custom Adapter
        attractionAdapter = new AttractionAdapter(getActivity(), sightsList);

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
    }

}
