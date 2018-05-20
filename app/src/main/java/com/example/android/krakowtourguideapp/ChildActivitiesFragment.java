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
public class ChildActivitiesFragment extends Fragment {

    private AttractionAdapter attractionAdapter;

    public ChildActivitiesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        Create ArrayList of objects
        ArrayList<Attraction> activitiesList= new ArrayList<Attraction>();

        activitiesList.add(new Attraction("activ1", "Activity", "Jakaś aktywność", R.drawable.placeholder_card_view_image));
        activitiesList.add(new Attraction("activ2", "Activity", "Jakaś aktywność", R.drawable.placeholder_card_view_image));
        activitiesList.add(new Attraction("activ3", "Activity", "Jakaś aktywność", R.drawable.placeholder_card_view_image));
        activitiesList.add(new Attraction("activ4", "Activity", "Jakaś aktywność", R.drawable.placeholder_card_view_image));
        activitiesList.add(new Attraction("activ5", "Activity", "Jakaś aktywność", R.drawable.placeholder_card_view_image));

//        Create instance of custom Adapter
        attractionAdapter = new AttractionAdapter(getActivity(), activitiesList);

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
                Intent intent = new Intent(getActivity(), DetailActivity.class);
                startActivity(intent);
            }
        });
    }

}
