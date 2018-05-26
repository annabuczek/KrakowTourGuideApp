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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class TopAttractionsFragment extends Fragment {

    private AttractionAdapter attractionAdapter;
    private ArrayList<Attraction> topAttractionsList;
    public final String DETAIL_VIEW_1 = "detail_view_full";
    public final String DETAIL_VIEW_2 = "detail_view_less";


    public TopAttractionsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        Create ArrayList of objects
        topAttractionsList = new ArrayList<Attraction>();

        topAttractionsList.add(new Attraction(R.drawable.top1_wawel_img, getString(R.string.top1_indicator),
                getString(R.string.top1_title), getString(R.string.top1_description_short), getString(R.string.top1_description),
                getString(R.string.top1_address), getString(R.string.top1_phone), getString(R.string.top1_phone_intent),
                getString(R.string.top1_geo), getString(R.string.top1_web), DETAIL_VIEW_1));
        topAttractionsList.add(new Attraction(R.drawable.top2_rynek_img, getString(R.string.top2_indicator), getString(R.string.top2_title),
                getString(R.string.top2_description_short), getString(R.string.top2_description), getString(R.string.top2_address),
                getString(R.string.top2_geo),DETAIL_VIEW_2));
        topAttractionsList.add(new Attraction(R.drawable.top3_mariacki_img, getString(R.string.top3_indicator), getString(R.string.top3_title),
                getString(R.string.top3_description_short), getString(R.string.top3_description), getString(R.string.top3_address),
                getString(R.string.top3_phone), getString(R.string.top3_phone_intent), getString(R.string.top3_geo), getString(R.string.top3_web),
                DETAIL_VIEW_1));
        topAttractionsList.add(new Attraction(R.drawable.top4_wieliczka_img, getString(R.string.top4_indicator), getString(R.string.top4_title),
                getString(R.string.top4_description_short), getString(R.string.top4_description), getString(R.string.top4_address),
                getString(R.string.top4_phone), getString(R.string.top4_phone_intent), getString(R.string.top4_geo), getString(R.string.top4_web),
                DETAIL_VIEW_1));
        topAttractionsList.add(new Attraction(R.drawable.top5_kazimierz_img, getString(R.string.top5_indicator), getString(R.string.top5_title),
                getString(R.string.top5_description_short), getString(R.string.top5_description), getString(R.string.top5_address),
                getString(R.string.top5_geo),DETAIL_VIEW_2));

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

//        Set OnListItemClickListener to open detail activity while tapping on the list item.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Attraction selectedAttraction = topAttractionsList.get(position);

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
