package com.faisal.solution1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String LOG = "check_value";
    private EditText value_x;
private EditText value_y;
private Button btnAction;
private TextView text_display;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        value_x = findViewById(R.id.edit_text_1);
        value_y = findViewById(R.id.edit_text_2);
        btnAction = findViewById(R.id.btn_action);
        text_display = findViewById(R.id.text_view_display);

        text_display.setOnClickListener(v -> {
            try{
                int x = Integer.parseInt(value_x.getText().toString().trim());
                int y = Integer.parseInt(value_y.getText().toString().trim());
                double result = Math.pow(x,y);
                text_display.setText(""+result);
            }catch (Exception e)
            {
                Log.e(LOG,"exception:"+e.getMessage());
            }

        });
    }
}