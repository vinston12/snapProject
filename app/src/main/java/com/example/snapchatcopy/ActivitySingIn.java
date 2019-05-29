package com.example.snapchatcopy;


import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;


public class ActivitySingIn extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.singin_main);
        Toast.makeText(this, "Firebase podpiety!!", Toast.LENGTH_LONG).show();
    }
}
