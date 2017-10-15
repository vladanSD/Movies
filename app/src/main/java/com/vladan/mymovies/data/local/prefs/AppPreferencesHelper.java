package com.vladan.mymovies.data.local.prefs;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Vladan on 10/15/2017.
 */

public class AppPreferencesHelper implements PreferencesHelper {

    private final SharedPreferences sharedPreferences;

    public AppPreferencesHelper(Context context, String prefFileName) {
        sharedPreferences = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE);
    }

    @Override
    public int getCurrentTheme() {
        return 0;
    }

    @Override
    public void setCurrentTheme(int theme) {

    }
}
