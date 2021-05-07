package com.techdecode.pizzaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Ongoing_get_order_details extends AppCompatActivity {

    EditText getOrderId;
    Button goBtn;

    sqlhelper sqlhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ongoing_get_order_details);

        sqlhelper = new sqlhelper(this, "FoodDB.sqlite",null, 1);

        getOrderId = findViewById(R.id.get_order_id_);
        goBtn = findViewById(R.id.xxxxxxxxxxxxxxxxxxxx);




        goBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String orderID = getOrderId.getText().toString();

                Intent intent = new Intent(Ongoing_get_order_details.this, assign_order.class);
                intent.putExtra("orderID",orderID);
                startActivity(intent);

            }
        });


    }
}