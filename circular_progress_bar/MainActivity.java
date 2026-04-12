package com.example.progressbarcircu;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Button;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ProgressBar determinateBar;
    private Button startBtn;
    private int progressValue = 0;
    private final Handler handler = new Handler(Looper.getMainLooper());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        determinateBar = findViewById(R.id.determinateBar);
        startBtn = findViewById(R.id.startBtn);

        startBtn.setOnClickListener(v -> {
            startBtn.setEnabled(false);
            progressValue = 0;

            new Thread(() -> {
                while (progressValue < 100) {
                    progressValue++;


                    handler.post(() -> determinateBar.setProgress(progressValue));

                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                handler.post(() -> startBtn.setEnabled(true));
            }).start();
        });
    }
}