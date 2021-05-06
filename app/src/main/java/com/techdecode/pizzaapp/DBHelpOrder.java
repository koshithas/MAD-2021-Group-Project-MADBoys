package com.techdecode.pizzaapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import androidx.annotation.Nullable;

public class DBHelpOrder extends SQLiteOpenHelper {
    public DBHelpOrder(Context context) {
        super(context, "OrderData.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create Table Orders(orderId integer PRIMARY KEY AUTOINCREMENT," +
                "firstName Text ," +
                " lastName TEXT, " +
                "email TEXT," +
                "contactNumber integer," +
                "address text," +
                "cardName text," +
                "cardNumber text,e" +
                "xpDate text," +
                "securityCode text," +
                "productId text,qty text,date text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("drop Table if exists Orders");

    }
    public Boolean insertData(String firstName,String lastName,String email,String contactNumber,
                              String address,String cardName,String cardNumber,String expDate,
                              String securityCode,String productId,String qty,String date) {
        SQLiteDatabase db = this.getWritableDatabase();
        //for our values
        ContentValues contentValues = new ContentValues();
        contentValues.put("firstName", firstName);
        contentValues.put("lastName", lastName);
        contentValues.put("email", email);
        contentValues.put("contactNumber", contactNumber);
        contentValues.put("address", address);
        contentValues.put("cardName", cardName);
        contentValues.put("cardNumber", cardNumber);
        contentValues.put("expDate", expDate);
        contentValues.put("securityCode", securityCode);
        contentValues.put("productId", productId);
        contentValues.put("qty", qty);
        contentValues.put("date", date);


        long results = db.insert("Orders", null,contentValues);

        if(results == -1){
            return false;
        }else {
            return true;
        }

    }
    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor =db.rawQuery("select * from Orders",null);
        return  cursor;


    }
    public Boolean updateData(String id,String firstName,String lastName,String email,String contactNumber,
                              String address,String cardName,String cardNumber,String expDate,
                              String securityCode,String productId,String qty,String date) {
        SQLiteDatabase db = this.getWritableDatabase();
        //for our values
        ContentValues contentValues = new ContentValues();
       // contentValues.put("firstName", firstName);
       // contentValues.put("lastName", lastName);
       // contentValues.put("email", email);
        contentValues.put("contactNumber", contactNumber);
        contentValues.put("address", address);
        //contentValues.put("cardName", cardName);
        //contentValues.put("cardNumber", cardNumber);
       // contentValues.put("expDate", expDate);
       // contentValues.put("securityCode", securityCode);
      //  contentValues.put("productId", productId);
       // contentValues.put("qty", qty);
       // contentValues.put("qty", date);

        long results = db.update("Orders",contentValues,"orderId = ?",new String[] {id});


        if(results == -1){
            return false;
        }else {
            return true;
        }

    }
    public void deleteData(int id) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
    /*


        long results = db.delete("Orders", "orderId = ?", new int[]{id});

        if (results == -1) {
            return false;
        } else {
            return true;
        }

     */
        String sql = "DELETE FROM Orders WHERE OrderId = ?";
        SQLiteStatement sqLiteStatement = sqLiteDatabase.compileStatement(sql);
        sqLiteStatement.clearBindings();
        sqLiteStatement.bindDouble(1,(double)id);

        sqLiteStatement.execute();
        sqLiteDatabase.close();

    }

    }
