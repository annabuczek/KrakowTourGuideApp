package com.example.android.krakowtourguideapp;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by aania on 04.05.2018.
 */

public class AttractionAdapter extends ArrayAdapter<Attraction> {

    private Context context;
    SharedPreference sharedPreference;
    List<Attraction> attractionsList;
    private boolean isFavoritesList;
    private String tag;

    public AttractionAdapter(Activity context, List<Attraction> attractionsList, boolean isFavoritesList) {
        super(context, 0, attractionsList);
        this.context = context;
        this.attractionsList = attractionsList;
        this.isFavoritesList = isFavoritesList;
        sharedPreference = new SharedPreference();
    }

    @Override
    public int getCount() {
        return attractionsList.size();
    }

    @Nullable
    @Override
    public Attraction getItem(int position) {
        return attractionsList.get(position);
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        final Attraction currentAttraction = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.card_view, parent, false);
        }

        ImageView imageView = convertView.findViewById(R.id.card_image);
        TextView titleTextView = convertView.findViewById(R.id.card_title);
        TextView bodyTextView = convertView.findViewById(R.id.card_body);
        final ImageButton favoriteImageButton = convertView.findViewById(R.id.favorite_image_button);

        imageView.setImageResource(currentAttraction.getImage());
        titleTextView.setText(currentAttraction.getTitle());
        bodyTextView.setText(currentAttraction.getDescriptionShort());

//        If Attraction exist in SharedPreferences then set proper icon and tag
        if (checkFavoriteItem(currentAttraction)) {
            favoriteImageButton.setImageResource(R.drawable.ic_action_favorite);
            favoriteImageButton.setTag("full");
        } else {
            favoriteImageButton.setImageResource(R.drawable.ic_action_favorite_border);
            favoriteImageButton.setTag("empty");
        }

//        Set On Click Listener for favorite button
        favoriteImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tag = favoriteImageButton.getTag().toString();
                if (tag.equalsIgnoreCase("empty")) {
                    sharedPreference.addFavorite(context, currentAttraction);
                    favoriteImageButton.setTag("full");
                    favoriteImageButton.setImageResource(R.drawable.ic_action_favorite);
                    Toast.makeText(getContext(), "Added to Favorites", Toast.LENGTH_SHORT).show();
                } else {
                    sharedPreference.removeFavorite(context, currentAttraction);
                    favoriteImageButton.setTag("empty");
                    favoriteImageButton.setImageResource(R.drawable.ic_action_favorite_border);
//                    Make favorite attraction not displaying on the list
                    if (isFavoritesList) {
                        remove(currentAttraction);
                    }
                    Toast.makeText(getContext(), "Removed from Favorites", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return convertView;
    }

//    Check if particular Attraction exist already in Shared Preferences
    public boolean checkFavoriteItem(Attraction checkFavorite) {
        boolean check = false;
        List<Attraction> favorites = sharedPreference.getFavorites(context);
        if (favorites != null) {
            for (Attraction attraction : favorites) {
                if(attraction.getIndicator().equalsIgnoreCase(checkFavorite.getIndicator())) {
                    check = true;
                    break;
                }
            }
        }
        return check;
    }
}
