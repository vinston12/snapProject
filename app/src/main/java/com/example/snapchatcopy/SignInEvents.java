package com.example.snapchatcopy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.example.snapchatcopy.session.Session;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

class SignInEvents {
    private Context context;
    private SignInUI ui;
    private User user;
    private Session session;
    private FirebaseFirestore firebaseApp = FirebaseFirestore.getInstance();


    SignInEvents(Activity context){
        this.context = context;
        this.ui = new SignInUI(context);
        this.session = new Session(context.getApplicationContext());
        this.user = new User(session, ui.getLoginText(), ui.getPasswordText(), context);
    }

     void attach(){
        (ui.getBackButton()).setOnClickListener(this::goBack);
        (ui.getLoginButton()).setOnClickListener(this::SignIn);
    }

     void SignIn(View view) {
        CollectionReference reference = firebaseApp.collection("users");

        reference.whereEqualTo("Name", ui.getLoginText()).whereEqualTo("Pass", ui.getPasswordText())
                .get()
                .addOnSuccessListener(query -> {
                    if (!query.isEmpty()){
                        this.session.putString("username", ui.getLoginText()).save();
                        Toast.makeText(context, "Zalogowano!", Toast.LENGTH_SHORT).show();
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        //startActivity
                    } else {
                        Toast.makeText(context, "Taki użytkownik nie istnieje", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(e -> Toast.makeText(context, e.getMessage(), Toast.LENGTH_LONG).show());
    }

    private void goBack(View v) {
        context.startActivity(new Intent(context.getApplicationContext(), MainActivity.class));
    }
}