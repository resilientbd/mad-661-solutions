package com.faisal.solution5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private TextView textMiles;
private EditText editText_kilometers;
private Button btnAction;
    private final double KM_VALUE = 1.609;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textMiles = findViewById(R.id.text_mi);
        editText_kilometers = findViewById(R.id.edit_km);
        btnAction = findViewById(R.id.btn_action);
        btnAction.setOnClickListener(v -> {
            int kilo = Integer.parseInt(editText_kilometers.getText().toString().trim());
            double result = kilo/KM_VALUE;
            textMiles.setText(""+result+" Miles");
        });


    }
}