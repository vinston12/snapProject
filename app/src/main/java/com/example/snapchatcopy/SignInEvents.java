package com.example.snapchatcopy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.example.snapchatcopy.session.Session;

public class SignInEvents {
    private Context context;
    private SignInUI ui;
    private User user;
    private Session session;

    SignInEvents(Activity context){
        this.context = context;
        this.ui = new SignInUI(context);
        this.session = new Session(context.getApplicationContext());
        this.user = new User(session, ui.getLoginText(), ui.getPasswordText());
    }

    public void attach(){
        (ui.getBackButton()).setOnClickListener(this::goBack);
        (ui.getLoginButton()).setOnClickListener(this.user::SignIn);
    }

    private void goBack(View v) {
        context.startActivity(new Intent(context.getApplicationContext(), MainActivity.class));
    }
}