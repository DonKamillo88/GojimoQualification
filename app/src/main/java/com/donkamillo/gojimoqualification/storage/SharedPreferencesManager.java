package com.donkamillo.gojimoqualification.storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.donkamillo.gojimoqualification.ui.model.QualificationModel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DonKamillo on 13.05.2016.
 */
public class SharedPreferencesManager {
    private static final String HISTORY_DATA = "history_data";

    static public void saveHistoryData(List<QualificationModel> list, Context context) {
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPrefs.edit();
        Gson gson = new Gson();

        String json = gson.toJson(list);

        editor.putString(HISTORY_DATA, json);
        editor.apply();
    }

    static public List<QualificationModel> loadHistoryData(Context context) {
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        Gson gson = new Gson();
        String json = sharedPrefs.getString(HISTORY_DATA, null);
        Type type = new TypeToken<ArrayList<QualificationModel>>() {
        }.getType();
        return gson.fromJson(json, type);
    }

}
