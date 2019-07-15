package com.example.snapchatcopy;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class CaptureActivity extends AppCompatActivity {

    Button bFromCapture;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capture);

        bFromCapture = findViewById(R.id.backFromCapture);

        bFromCapture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Bundle extras = getIntent().getExtras();
        assert extras != null;
        byte[] b = extras.getByteArray("capture");

        if(b!=null){
            ImageView imageView = findViewById(R.id.imageCapture);

            Bitmap decodeBitmap = BitmapFactory.decodeByteArray(b, 0, b.length);

            Bitmap rotateBitmap = rotate(decodeBitmap);


            imageView.setImageBitmap(rotateBitmap);

        }
     }



    private Bitmap rotate(Bitmap decodeBitmap) {
     int w = decodeBitmap.getWidth();
     int h = decodeBitmap.getHeight();

     Matrix matrix = new Matrix();
     matrix.setRotate(90);
     return Bitmap.createBitmap(decodeBitmap, 0, 0, w, h, matrix, true);
    }
}
