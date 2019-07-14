package com.example.snapchatcopy;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class ActivitySingUp extends AppCompatActivity {

    EditText emailLabel, nameLabel, passLabel;
    CardView bLogin;
    String email, name, pass;
    Button button;
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.singup_main);


        bLogin = (CardView)findViewById(R.id.loginButtonIn);

        emailLabel = (EditText)findViewById(R.id.emailLabel);
        nameLabel  = (EditText)findViewById(R.id.nameLabel);
        passLabel = (EditText)findViewById(R.id.passLabel);

        this.button = findViewById(R.id.backButtonInSingUp);

        this.button.setOnClickListener(this::buttonOnClick);


        bLogin.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {

                email = emailLabel.getText().toString();
                name = nameLabel.getText().toString();
                pass = passLabel.getText().toString();

                Map<String, Object> user = new HashMap<>();
                user.put("Email", email);
                user.put("Name", name);
                user.put("Pass", pass);

                // Add a new document with a generated ID
                db.collection("users")
                        .add(user)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                Log.d("User", "DocumentSnapshot added with ID: " + documentReference.getId());
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.w("User", "Error adding document", e);
                            }
                        });
            }
        });

    }

    public void buttonOnClick(View v) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }


}