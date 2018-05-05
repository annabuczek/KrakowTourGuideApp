package com.example.android.krakowtourguideapp;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChildBarsFragment extends Fragment {

    private AttractionAdapter attractionAdapter;

    public ChildBarsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        Create ArrayList of objects
        ArrayList<Attraction> barsList= new ArrayList<Attraction>();

        barsList.add(new Attraction("Banialuka", "Największa pijalnia", R.drawable.placeholder_card_view_image));
        barsList.add(new Attraction("Banialuka", "Największa pijalnia", R.drawable.placeholder_card_view_image));
        barsList.add(new Attraction("Banialuka", "Największa pijalnia", R.drawable.placeholder_card_view_image));
        barsList.add(new Attraction("Banialuka", "Największa pijalnia", R.drawable.placeholder_card_view_image));
        barsList.add(new Attraction("Banialuka", "Największa pijalnia", R.drawable.placeholder_card_view_image));

//        Create instance of custom Adapter
        attractionAdapter = new AttractionAdapter(getActivity(), barsList);

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