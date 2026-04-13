package com.example.contextual_menu;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        registerForContextMenu(textView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.setHeaderTitle("Choose Option");

        menu.add(0, 1, 0, "Change Text");
        menu.add(0, 2, 1, "Change Color");
        menu.add(0, 3, 2, "Reset");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        if (item.getItemId() == 1) {
            textView.setText("Text Changed");
            Toast.makeText(this, "Text Updated", Toast.LENGTH_SHORT).show();
            return true;

        } else if (item.getItemId() == 2) {
            textView.setTextColor(Color.BLUE);
            Toast.makeText(this, "Color Changed", Toast.LENGTH_SHORT).show();
            return true;

        } else if (item.getItemId() == 3) {
            textView.setText("Long Press Here");
            textView.setTextColor(Color.BLACK);
            Toast.makeText(this, "Reset Done", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onContextItemSelected(item);
    }
}