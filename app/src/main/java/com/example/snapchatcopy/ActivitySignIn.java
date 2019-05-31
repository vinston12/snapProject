package com.example.snapchatcopy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class ActivitySignIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.singin_main);

        SignInEvents events = new SignInEvents(this);
        events.attach();
    }
}
