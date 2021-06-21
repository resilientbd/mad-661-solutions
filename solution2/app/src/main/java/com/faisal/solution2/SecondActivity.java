package com.faisal.solution2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private TextView display;
    public static final String VALUE_NAME = "value_name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        display = findViewById(R.id.text_display);
        display.setText(""+getIntent().getStringExtra(VALUE_NAME));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(SecondActivity.this,FirstActivity.class));
        finish();
    }
}