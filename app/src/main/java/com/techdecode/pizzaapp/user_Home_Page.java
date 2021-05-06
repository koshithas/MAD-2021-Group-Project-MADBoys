package com.techdecode.pizzaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.ArrayList;

public class user_Home_Page extends AppCompatActivity {


    GridView gridView;
    ArrayList<Food> list;
    useFoodListAdapter adapter = null;

    SearchView mySearchView;
    ImageView imageView;
    TextView t;

    public static sqlhelper sqliteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__home__page);


        gridView = findViewById(R.id.grideview12);
        list = new ArrayList<>();
        adapter = new useFoodListAdapter(this,R.layout.user_food_item,list);
        gridView.setAdapter(adapter);




        //get the user details to the user profile

        String username = getIntent().getStringExtra("username1");



        imageView = findViewById(R.id.profile_btn);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(user_Home_Page.this, userProfile.class);
                intent.putExtra("username1",username);
                startActivity(intent);

            }
        });




        //get all data from sqlite

        Cursor cursor = startup_screen.sqliteHelper.getdata("SELECT * FROM FOOD");
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


        mySearchView = findViewById(R.id.food_search_bar);


    }

}