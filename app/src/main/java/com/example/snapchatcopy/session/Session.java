package com.example.snapchatcopy.session;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

import java.util.List;
import java.util.Map;

public class Session {
    private final Context context;
    private final SharedPreferences prefs;
    private final SharedPreferences.Editor editor;


    @SuppressLint("CommitPrefEdits")
    public Session(Context context) {
        this.context = context;
        prefs = context.getSharedPreferences("Session", Context.MODE_PRIVATE);
        editor = prefs.edit();
    }

    public Session putString(String key, String value){
        editor.putString(key, value);
        return this;
    }

    public Session putInt(String key, int value){
        editor.putInt(key, value);
        return this;
    }

    public Session putBoolean(String key, boolean value){
        editor.putBoolean(key, value);
        return this;
    }

    public void save(){
        editor.commit();
    }

    public Object get(String key){
        Map<String, ?> values = prefs.getAll();
        if (values.containsKey(key)) {
            return values.get(key);
        }

        return null;
    }
}
