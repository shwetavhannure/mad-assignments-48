package com.example.gridlayoutprojects;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btn1 = findViewById(R.id.btnProject1);
        Button btn2 = findViewById(R.id.btnProject2);
        Button btn3 = findViewById(R.id.btnProject3);
        Button btn4 = findViewById(R.id.btnProject4);
        Button btn5 = findViewById(R.id.btnProject5);
        Button btn6 = findViewById(R.id.btnProject6);
        Button btn7 = findViewById(R.id.btnProject7);
        Button btn8 = findViewById(R.id.btnProject8);
        Button btn9 = findViewById(R.id.btnProject9);


        btn1.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, ProjectActivity1.class)));
        btn2.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, ProjectActivity2.class)));
        btn3.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, ProjectActivity3.class)));
        btn4.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, ProjectActivity4.class)));
        btn5.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, ProjectActivity5.class)));
        btn6.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, ProjectActivity6.class)));
        btn7.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, ProjectActivity7.class)));
        btn8.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, ProjectActivity8.class)));
        btn9.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, ProjectActivity9.class)));
    }
}