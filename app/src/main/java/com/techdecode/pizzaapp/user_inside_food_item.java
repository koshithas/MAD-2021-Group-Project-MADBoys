package com.techdecode.pizzaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class user_inside_food_item extends AppCompatActivity {


    ImageView img;
    TextView txtname, txtprice, txttype,txtDescription,foodId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_inside_food_item);

        img = findViewById(R.id.imageView234);
        txtname = findViewById(R.id.checkout_food_name);
        txtprice = findViewById(R.id.checkout_total);
        txttype = findViewById(R.id.type);
        txtDescription = findViewById(R.id.checkout_food_description);


       Bundle extras = getIntent().getExtras();
        byte[] byteArray = extras.getByteArray("image1");

       Bitmap bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        img.setImageBitmap(bmp);


        txtname.setText(getIntent().getStringExtra("name1"));
        txtprice.setText(getIntent().getStringExtra("price1"));
        txttype.setText(getIntent().getStringExtra("type1"));
        txtDescription.setText(getIntent().getStringExtra("description1"));

    }
}