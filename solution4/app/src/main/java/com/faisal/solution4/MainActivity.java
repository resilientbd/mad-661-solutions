package com.faisal.solution4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String LOG = "chk_log";
    private CheckBox item_chocolate;
    private CheckBox item_whipped_cream;
    private Button btnIncrement;
    private Button btnDecrement;
    private Button btnOrder;
    private TextView textQuantity;
    private TextView textDisplay;

    private final int regular_rate = 2;
    private final double rate_chocolate = 0.50;
    private final double rate_whipped_cream = 1.00;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
        btnOrder.setOnClickListener(v -> {
           try{
               calculateOrder();
           }catch (Exception e)
           {
               Log.e(LOG,"exception:"+e.getMessage());
           }
        });
        btnIncrement.setOnClickListener(v -> {
            incrementQuantity();
        });
        btnDecrement.setOnClickListener(v -> {
            decrementQuantity();
        });
    }

    private void decrementQuantity() {
        int quantity = Integer.parseInt(textQuantity.getText().toString().trim());
        if (quantity > 1) {
            textQuantity.setText("" + (--quantity));
        }
    }

    private void incrementQuantity() {
        int quantity = Integer.parseInt(textQuantity.getText().toString().trim());
        textQuantity.setText("" + (++quantity));
    }

    private void calculateOrder() {
        double price = regular_rate;
        String result = "Order Summary \n\n";
        if(item_chocolate.isChecked())
        {
            price = price + rate_whipped_cream;
            result = result+"Cocolate cream added \n";
        }
        if(item_whipped_cream.isChecked())
        {
            price = price + rate_chocolate;
            result = result+"Whipped cream added \n";
        }
        int quantity = Integer.parseInt(textQuantity.getText().toString().trim());
        price = price*quantity;
        result = result+"Quantity: "+quantity+" \n";
        result = result+"Total price: $"+price+" \n";
        result = result+"\nThank You!";
        textDisplay.setText(result);
    }

    private void initComponents() {
        item_chocolate = findViewById(R.id.checkbox_chocolate);
        item_whipped_cream = findViewById(R.id.checkbox_whipped_cream);
        btnIncrement = findViewById(R.id.btn_increment);
        btnDecrement = findViewById(R.id.btn_decrement);
        btnOrder = findViewById(R.id.button_order);
        textQuantity = findViewById(R.id.text_quantity);
        textDisplay = findViewById(R.id.text_display);
    }
}