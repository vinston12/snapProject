package com.example.snapchatcopy;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.snapchatcopy.session.Session;

public class MainActivity extends AppCompatActivity {

    Button goSignIn, goSignUp;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Session session = new Session(getApplicationContext());

        if (session.get("username") != null) {
            startActivity(new Intent(getApplicationContext(), ActivitySignIn.class));
        }

        this.goSignIn = findViewById(R.id.goSignInButton);
        this.goSignUp = findViewById(R.id.goSignUpButton);

        this.goSignIn.setOnClickListener(this::goToSignIn);
        this.goSignUp.setOnClickListener(this::goToSignUp);
    }


    private void goToSignIn(View v) {
        Intent intent = new Intent(getApplicationContext(), ActivitySignIn.class);
        startActivity(intent);
    }

    private void goToSignUp(View v) {
        startActivity(new Intent(getApplicationContext(), ActivitySingUp.class));
    }
}
