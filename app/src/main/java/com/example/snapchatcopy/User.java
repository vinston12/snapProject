package com.example.snapchatcopy;

import android.app.Activity;
import android.view.View;

import com.example.snapchatcopy.session.Session;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class User {

    private String password;
    private String login;
    private Session session;
    private Activity context;
    private FirebaseFirestore firebaseApp = FirebaseFirestore.getInstance();

    public User(Session session, String login, String password){
        this.session = session;
        this.login = login;
        this.password = password;
    }

    public void SignIn(View view) {
        CollectionReference reference = firebaseApp.collection("users");
        reference.whereEqualTo("Name", login).whereEqualTo("Pass", password)
                .limit(1)
                .get()
                .addOnSuccessListener(query -> {
                    this.session.putString("username", login);
                });

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
