package com.example.snapchatcopy;

import android.app.Activity;

import com.example.snapchatcopy.session.Session;

public class User {

    private String password;
    private String login;
    private Session session;
    private Activity context;

    User(Session session, String login, String password, Activity context){
        this.session = session;
        this.login = login;
        this.password = password;
        this.context = context;
    }

    public String getPassword() {
        return password;
    }

    public String getLogin() {
        return login;
    }

    public Session getSession() {
        return session;
    }
}
