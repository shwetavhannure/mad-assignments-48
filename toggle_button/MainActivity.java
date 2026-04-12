package com.example.toggleexample;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.switchmaterial.SwitchMaterial;

public class MainActivity extends AppCompatActivity {

    private SwitchMaterial toggleButton;
    private TextView toggleStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toggleButton = findViewById(R.id.toggleButton);
        toggleStatus = findViewById(R.id.toggleStatus);

        toggleButton.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                toggleStatus.setText("Toggle is ON");
            } else {
                toggleStatus.setText("Toggle is OFF");
            }
        });
    }
}