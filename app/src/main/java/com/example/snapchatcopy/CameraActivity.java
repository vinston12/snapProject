package com.example.snapchatcopy;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

class CameraActivity extends AppCompatActivity {

    @Override
    public void onCreate( Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.photo_snap);
    }
}
