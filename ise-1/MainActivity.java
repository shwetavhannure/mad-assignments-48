package com.example.launchcamera;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    int CAMERA_CODE = 100;
    ImageView img;
    RatingBar ratingBar;
    TextView txtMessage;

    boolean isFromCamera = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = findViewById(R.id.imageView);
        Button btn = findViewById(R.id.btnLaunchCamera);
        Button btnSubmit = findViewById(R.id.btnSubmit);
        ratingBar = findViewById(R.id.ratingBar);
        txtMessage = findViewById(R.id.txtMessage);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ratingBar.setRating(0);
                txtMessage.setText("");

                isFromCamera = true;
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, CAMERA_CODE);
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float rating = ratingBar.getRating();
                txtMessage.setText("You rated this image " + rating);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CAMERA_CODE && resultCode == RESULT_OK && data != null) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            img.setImageBitmap(photo);
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        if (!isFromCamera) {
            img.setImageBitmap(null);
            ratingBar.setRating(0);
            txtMessage.setText("");
        }
        isFromCamera = false;
    }
}