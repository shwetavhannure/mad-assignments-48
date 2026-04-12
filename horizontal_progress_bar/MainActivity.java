package com.example.progressbarhoriz;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ProgressBar indeterminateProgressBar, determinateProgressBar;
    Button startProgressBtn;
    Handler handler = new Handler();
    int progressStatus = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       
        indeterminateProgressBar = findViewById(R.id.indeterminateProgressBar);
        determinateProgressBar = findViewById(R.id.determinateProgressBar);
        startProgressBtn = findViewById(R.id.startProgressBtn);

       
        indeterminateProgressBar.setIndeterminate(true);

       
        startProgressBtn.setOnClickListener(v -> {
            progressStatus = 0;
            determinateProgressBar.setProgress(progressStatus);

           
            new Thread(() -> {
                while (progressStatus < 100) {
                    progressStatus += 1;

                   
                    handler.post(() -> determinateProgressBar.setProgress(progressStatus));

                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        });
    }
}