package com.example.mdarifur.product_info;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by MD.Arifur on 7/25/2016.
 */
public class Preference {
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private Context context;
    private static final String NAME_KEY = "status";

    public Preference(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences("Login", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void saveUserData(String data) {

        editor.putString(NAME_KEY, data);
        editor.commit();

    }

    public String getUserData() {
        String dataTobeShown = sharedPreferences.getString(NAME_KEY, "false");
        return dataTobeShown;

    }
}
