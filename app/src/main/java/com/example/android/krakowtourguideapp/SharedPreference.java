package com.example.android.krakowtourguideapp;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.w3c.dom.Attr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by aania on 06.05.2018.
 */

public class SharedPreference {

    public static final String PREFERENCES_NAME = "favorite_preferences";
    public static final String PREFERENCES_FAVORITES_LIST = "favorites_list";

    public SharedPreference() {
        super();
    }

    public void saveFavorites(Context context, List<Attraction> favorites) {

        SharedPreferences preferences;
        SharedPreferences.Editor preferencesEditor;

        preferences = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
        preferencesEditor = preferences.edit();

        Gson gson = new Gson();
        String jsonFavorites = gson.toJson(favorites);

        preferencesEditor.putString(PREFERENCES_FAVORITES_LIST, jsonFavorites);
        preferencesEditor.commit();
    }

    public void addFavorite(Context context, Attraction favoriteAttraction) {
        List<Attraction> favorites = getFavorites(context);

        if (favorites == null) {
            favorites = new ArrayList<Attraction>(); }
        favorites.add(favoriteAttraction);
        saveFavorites(context, favorites);
    }

    public void removeFavorite(Context context, int index) {
        ArrayList<Attraction> favorites = getFavorites(context);
        if (favorites != null) {
            Log.v("SharedPreference", "Value of index is" + index);
            favorites.remove(index);
            saveFavorites(context, favorites);
        }
    }

    public ArrayList<Attraction> getFavorites(Context context) {

        SharedPreferences preferences;
        List<Attraction> favorites;

        preferences  = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);

        if (preferences.contains(PREFERENCES_FAVORITES_LIST)) {
            String jsonFavorites = preferences.getString(PREFERENCES_FAVORITES_LIST, null);
            Gson gson = new Gson();
            Attraction[] favoriteItems = gson.fromJson(jsonFavorites, Attraction[].class);

            favorites = Arrays.asList(favoriteItems);
            favorites = new ArrayList<Attraction>(favorites);

        } else {
            return null;
        }
        return (ArrayList<Attraction>) favorites;
    }


}
