package com.faisal.solution2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

public class FirstActivity extends AppCompatActivity {
    private static final String LOG = "check_log";
    private EditText firstName;
    private EditText middleName;
    private EditText lastName;
    private Button btnAction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        initAll();
        initClickListeners();
    }

    private void initClickListeners() {
        btnAction.setOnClickListener(v -> {
            try {
                char char1 = firstName.getText().toString().trim().charAt(0);
                char char2 = middleName.getText().toString().trim().charAt(0);
                char char3 = lastName.getText().toString().trim().charAt(0);
                goNext("" + char1 + char2 + char3);
            } catch (Exception e) {
                Log.e(LOG, "exception:" + e.getMessage());
            }
        });
    }

    private void goNext(String value) {
        Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
        intent.putExtra(SecondActivity.VALUE_NAME, value);
        startActivity(intent);
        finish();
    }

    private void initAll() {
        firstName = findViewById(R.id.edit_text_1);
        middleName = findViewById(R.id.edit_text_2);
        lastName = findViewById(R.id.edit_text_3);
        btnAction = findViewById(R.id.btn_action);

    }
}