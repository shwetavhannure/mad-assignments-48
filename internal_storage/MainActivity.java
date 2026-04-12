package com.example.internalstorage;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    private EditText inputField;
    private TextView displayArea;
    private final String FILE_NAME = "app_data.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputField = findViewById(R.id.inputField);
        displayArea = findViewById(R.id.displayArea);

        Button btnSave = findViewById(R.id.btnSave);
        Button btnRead = findViewById(R.id.btnRead);

        btnSave.setOnClickListener(v -> saveData());
        btnRead.setOnClickListener(v -> readData());
    }

    private void saveData() {
        String content = inputField.getText().toString();
        if (content.isEmpty()) {
            Toast.makeText(this, "Please enter some text", Toast.LENGTH_SHORT).show();
            return;
        }

        try (FileOutputStream fos = openFileOutput(FILE_NAME, Context.MODE_PRIVATE)) {
            fos.write(content.getBytes());
            inputField.setText("");
            Toast.makeText(this, "Stored in Internal Storage", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void readData() {
        try (FileInputStream fis = openFileInput(FILE_NAME);
             InputStreamReader isr = new InputStreamReader(fis);
             BufferedReader reader = new BufferedReader(isr)) {

            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }
            displayArea.setText(sb.toString().trim());

        } catch (Exception e) {
            displayArea.setText("File not found or empty");
        }
    }
}