package com.example.gridlayoutprojects;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ProjectActivity9 extends AppCompatActivity {

    Button button, button2, button3, button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);

        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);

       
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://www.google.com";
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(i);
            }
        });

        
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double lat = 18.5204;
                double lon = 73.8567;

                Uri geoUri = Uri.parse(
                        "geo:" + lat + "," + lon +
                                "?q=" + lat + "," + lon + "(My+Location)"
                );

                Intent i = new Intent(Intent.ACTION_VIEW, geoUri);
                i.setPackage("com.google.android.apps.maps");
                startActivity(i);
            }
        });

        
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(i);
            }
        });

     
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = "+917028456088";
                Intent i = new Intent(Intent.ACTION_DIAL,
                        Uri.parse("tel:" + phone));
                startActivity(i);
            }
        });
    }
}
