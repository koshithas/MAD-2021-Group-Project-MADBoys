package com.techdecode.pizzaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class user_inside_food_item extends AppCompatActivity {


    ImageView img;
    TextView txtname, txtprice, txttype;
    Button place_order;


    private Context context;
    private int layout;
    private ArrayList<Food> foodList;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_inside_food_item);

        img = findViewById(R.id.imageView234);
        txtname = findViewById(R.id.checkout_food_name);
        txtprice = findViewById(R.id.checkout_total);
        txttype = findViewById(R.id.type);
        place_order = findViewById(R.id.order_button);

        Bundle extras = getIntent().getExtras();
        byte[] byteArray = extras.getByteArray("image1");
        Bitmap bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        img.setImageBitmap(bmp);


        txtname.setText(getIntent().getStringExtra("name1"));
        txtprice.setText(getIntent().getStringExtra("price1"));
        txttype.setText(getIntent().getStringExtra("type1"));



        String name = txtname.getText().toString();
        String price = txtprice.getText().toString();
        String type = txttype.getText().toString();







        place_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), OrderConfirmation.class);
                i.putExtra("foodName", name);
                i.putExtra("foodPrice", price);
                i.putExtra("foodNType", type);
                i.putExtra("foodImage",byteArray);


                startActivity(i);
            }
        });





    }


}