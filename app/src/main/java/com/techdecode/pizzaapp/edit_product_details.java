package com.techdecode.pizzaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class edit_product_details extends AppCompatActivity {

    private TextView textView_name,textView_type,textView_description,textView_price;
    private Button edit,img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_product_details);


        textView_name = findViewById(R.id.editTextText_Name_1);
        textView_type = findViewById(R.id.editTextText_food_type_1);
        textView_description = findViewById(R.id.editTextText_description_1);
        textView_price = findViewById(R.id.editTextText_price_1);
        edit = findViewById(R.id.edit_btn);
        img = findViewById(R.id.editTextText_photo_1);

    }

}