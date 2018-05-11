package com.example.android.krakowtourguideapp;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class TopAttractionsFragment extends Fragment {

    private AttractionAdapter attractionAdapter;

    public TopAttractionsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        Create ArrayList of objects
        ArrayList<Attraction> topAttractionsList= new ArrayList<Attraction>();

        topAttractionsList.add(new Attraction("top1", "Wawel", "Kraków Castle", R.drawable.placeholder_card_view_image));
        topAttractionsList.add(new Attraction("top2", "Wawel", "Kraków Castle", R.drawable.placeholder_card_view_image));
        topAttractionsList.add(new Attraction("top3", "Wawel", "Kraków Castle", R.drawable.placeholder_card_view_image));
        topAttractionsList.add(new Attraction("top4", "Wawel", "Kraków Castle", R.drawable.placeholder_card_view_image));
        topAttractionsList.add(new Attraction("top5", "Wawel", "Kraków Castle", R.drawable.placeholder_card_view_image));

//        Create instance of custom Adapter
        attractionAdapter = new AttractionAdapter(getActivity(), topAttractionsList);

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
