package com.techdecode.pizzaapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, "orders.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table orderTable(id integer primary key autoincrement,fname TEXT ,lname TEXT,email TEXT,contact INTEGER ,address TEXT,cardname TEXt,cardnumber INTEGER,expdate TEXT,security INTEGER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists orderTable");
    }

    public boolean insertData(String fname,String lname, String email,String contact,String address,String cardname,String cardnumber,String expdate,String security){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("fname",fname);
        contentValues.put("lname",lname);
        contentValues.put("email",email);
        contentValues.put("contact",contact);
        contentValues.put("address",address);
        contentValues.put("cardname",cardname);
        contentValues.put("cardnumber",cardnumber);
        contentValues.put("expdate",expdate);
        contentValues.put("security",security);

        long result = db.insert("orderTable",null,contentValues);
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
