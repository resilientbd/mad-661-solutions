package com.faisal.solution3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String LOG = "chk_log";
    private Spinner optionSpinner;
    private EditText editText_quantity;
    private EditText editText_amount;
    private TextView textView_display;
    private Button button_action;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
        button_action.setOnClickListener(v -> {
            try {
                calculateFuel();
            } catch (Exception e) {
                Log.e(LOG, "Exception:" + e.getMessage());
            }
        });
    }

    private void calculateFuel() {
        double unitProduct = 0.0;
        switch (optionSpinner.getSelectedItemPosition()) {
            case 0:
                unitProduct = 43;
                break;
            case 1:
                unitProduct = 45;
                break;
            case 2:
                unitProduct = 89;
                break;
            case 3:
                unitProduct = 90;
                break;
            default:
                break;
        }
        int quantity =
                Integer.parseInt(editText_quantity.getText().toString().trim
                        ());
        double amount =
                Double.parseDouble(editText_amount.getText().toString().trim
                        ());
        double changed_amount = amount -
                (unitProduct * quantity);
        textView_display.setText("Change:" + changed_amount);
    }

    private void initComponents() {
        optionSpinner = findViewById(R.id.spinner);
        editText_quantity = findViewById(R.id.text_quantity);
        editText_amount = findViewById(R.id.text_amount);
        textView_display = findViewById(R.id.text_display);
        button_action = findViewById(R.id.btn_calculate);
    }
}