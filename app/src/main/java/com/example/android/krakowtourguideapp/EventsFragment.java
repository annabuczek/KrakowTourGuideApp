package com.example.android.krakowtourguideapp;


import android.app.Activity;
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
public class EventsFragment extends Fragment {


    public final String DETAIL_VIEW_3 = "detail_view_event";
    private AttractionAdapter attractionAdapter;
    private ArrayList<Attraction> eventsList;

    public EventsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        Create ArrayList of objects
        eventsList = new ArrayList<Attraction>();

        eventsList.add(new Attraction(R.drawable.event1_muzeum_img, getString(R.string.event1_indicator), getString(R.string.event1_title),
                getString(R.string.event1_description_short), getString(R.string.event1_description), getString(R.string.event1_address),
                getString(R.string.event1_time), getString(R.string.event1_web), DETAIL_VIEW_3));
        eventsList.add(new Attraction(R.drawable.event2_juwenalia_img, getString(R.string.event2_indicator), getString(R.string.event2_title),
                getString(R.string.event2_description_short), getString(R.string.event2_description), getString(R.string.event2_address),
                getString(R.string.event2_time), getString(R.string.event2_web), DETAIL_VIEW_3));
        eventsList.add(new Attraction(R.drawable.event3_marathon_img, getString(R.string.event3_indicator), getString(R.string.event3_title),
                getString(R.string.event3_description_short), getString(R.string.event3_description), getString(R.string.event3_address),
                getString(R.string.event3_time), getString(R.string.event3_web), DETAIL_VIEW_3));
        eventsList.add(new Attraction(R.drawable.event4_film_img, getString(R.string.event4_indicator), getString(R.string.event4_title),
                getString(R.string.event4_description_short), getString(R.string.event4_description), getString(R.string.event4_address),
                getString(R.string.event4_time), getString(R.string.event4_web), DETAIL_VIEW_3));
        eventsList.add(new Attraction(R.drawable.event5_jewish_img, getString(R.string.event5_indicator), getString(R.string.event5_title),
                getString(R.string.event5_description_short), getString(R.string.event5_description), getString(R.string.event5_address),
                getString(R.string.event5_time), getString(R.string.event5_web), DETAIL_VIEW_3));

//        Create instance of custom Adapter
        attractionAdapter = new AttractionAdapter(getActivity(), eventsList, false);

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
                Attraction selectedAttraction = eventsList.get(position);

                Intent intent = new Intent(getActivity(), DetailActivity.class);
                intent.putExtra("ATTRACTION_IMG", selectedAttraction.getImage());
                intent.putExtra("ATTRACTION_TITLE", selectedAttraction.getTitle());
                intent.putExtra("ATTRACTION_DESCRIPTION", selectedAttraction.getDescription());
                intent.putExtra("ATTRACTION_ADDRESS", selectedAttraction.getAddress());
                intent.putExtra("DETAIL_VIEW", selectedAttraction.getDetailView());
                intent.putExtra("ATTRACTION_WEB", selectedAttraction.getWebIntent());
                intent.putExtra("ATTRACTION_TIME", selectedAttraction.getTime());

                startActivity(intent);
            }
        });
    }

}
