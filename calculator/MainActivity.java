package com.example.calculator;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText input1, input2;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input1 = findViewById(R.id.input1);
        input2 = findViewById(R.id.input2);
        tvResult = findViewById(R.id.tvResult);

        findViewById(R.id.btnAdd).setOnClickListener(v -> calculate('+'));
        findViewById(R.id.btnSub).setOnClickListener(v -> calculate('-'));
        findViewById(R.id.btnMul).setOnClickListener(v -> calculate('*'));
        findViewById(R.id.btnDiv).setOnClickListener(v -> calculate('/'));
    }

    private void calculate(char op) {
        String s1 = input1.getText().toString();
        String s2 = input2.getText().toString();

        if (s1.isEmpty() || s2.isEmpty()) {
            Toast.makeText(this, "Please enter numbers", Toast.LENGTH_SHORT).show();
            return;
        }

        double n1 = Double.parseDouble(s1);
        double n2 = Double.parseDouble(s2);
        double res = 0;

        if (op == '+') res = n1 + n2;
        else if (op == '-') res = n1 - n2;
        else if (op == '*') res = n1 * n2;
        else if (op == '/') {
            if (n2 != 0) res = n1 / n2;
            else {
                tvResult.setText("Answer: Error");
                return;
            }
        }

        tvResult.setText("Answer: " + res);
    }
}