package com.example.snapchatcopy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;

public class ActivitySignIn extends FragmentActivity {

    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.singin_main);

        SignInEvents events = new SignInEvents(this);
        events.attach();

        this.button = findViewById(R.id.backButton);

        this.button.setOnClickListener(this::buttonOnClick);



    }
    public void buttonOnClick(View v){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
}
