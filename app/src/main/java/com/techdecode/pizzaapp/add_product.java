package com.techdecode.pizzaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class add_product extends AppCompatActivity {

    private TextView textView_name,textView_type,textView_description,textView_price;
    private Button add,img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        textView_name = findViewById(R.id.editTextText_Name);
        textView_type = findViewById(R.id.editTextText_food_type);
        textView_description = findViewById(R.id.editTextText_description);
        textView_price = findViewById(R.id.editTextText_price);
        add = findViewById(R.id.add_btn);
        img = findViewById(R.id.editTextText_photo);
    }
}