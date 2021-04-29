package com.techdecode.pizzaapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, "order.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table deliveryDetails(id integer primary key autoincrement,fname TEXT ,lname TEXT,email TEXT,contact NUMBER ,address TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists deliveryDetails");
    }

    public boolean insertdeliverydata(String fname,String lname, String email,String contact,String address){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("fname",fname);
        contentValues.put("lname",lname);
        contentValues.put("email",email);
        contentValues.put("contact",contact);
        contentValues.put("address",address);

        long result = db.insert("deliveryDetails",null,contentValues);
        if(result == -1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
//    public cursor getdata(){
//
//    }

}
