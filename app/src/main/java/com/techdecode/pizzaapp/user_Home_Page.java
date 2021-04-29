package com.techdecode.pizzaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;

public class user_Home_Page extends AppCompatActivity {


    GridView gridView;
    ArrayList<Food> list;
    useFoodListAdapter adapter = null;

    public static sqlhelper sqliteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__home__page);


        gridView = findViewById(R.id.grideview12);
        list = new ArrayList<>();
        adapter = new useFoodListAdapter(this,R.layout.user_food_item,list);
        gridView.setAdapter(adapter);


        //get all data from sqlite

        Cursor cursor = MainActivity.sqliteHelper.getdata("SELECT * FROM FOOD");
        list.clear();

        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String price = cursor.getString(2);
            String type = cursor.getString(3);
            String description = cursor.getString(4);
            byte[] image = cursor.getBlob(5);

            list.add(new Food(id, name, price, type, description, image));


        }


        adapter.notifyDataSetChanged();

    }
}