package com.example.android.krakowtourguideapp;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by aania on 04.05.2018.
 */

public class AttractionAdapter extends ArrayAdapter<Attraction> {

    public AttractionAdapter(Activity context, ArrayList<Attraction> attractionsList) {
        super(context, 0, attractionsList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Attraction currentAttraction = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.card_view, parent, false);
        }

        ImageView imageView = convertView.findViewById(R.id.card_image);
        TextView titleTextView = convertView.findViewById(R.id.card_title);
        TextView bodyTextView = convertView.findViewById(R.id.card_body);

        imageView.setImageResource(currentAttraction.getImage());
        titleTextView.setText(currentAttraction.getTitle());
        bodyTextView.setText(currentAttraction.getDescriptionShort());

        return convertView;
    }
}
