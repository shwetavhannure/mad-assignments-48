package com.example.buttoncolorapp;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;


public class ProjectActivity7 extends AppCompatActivity {

    public void changeRed(View view) {
        ConstraintLayout layout = findViewById(R.id.mainLayout);
        layout.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
    }

    public void changeBlue(View view) {
        ConstraintLayout layout = findViewById(R.id.mainLayout);
        layout.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_light));
    }

    public void changeImage(View view) {
        ConstraintLayout layout = findViewById(R.id.mainLayout);
        layout.setBackgroundResource(R.drawable.bgimage);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
    }
}
