package com.example.snapchatcopy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;


public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUserTypeOnCardViewClick();


    }
    private void setUserTypeOnCardViewClick(){

        CardView card1 = (CardView) findViewById(R.id.cardie1);
        CardView card2 = (CardView) findViewById(R.id.cardie);


        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), ActivitySingIn.class);
                startActivity(i);
            }
        });


        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), ActivitySingUp.class);
                startActivityForResult(i, 0);

            }
        });
    }


}
// final LinearLayout layout=(LinearLayout)findViewById(R.id."");
