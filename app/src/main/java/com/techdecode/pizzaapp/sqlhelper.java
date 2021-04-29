package com.techdecode.pizzaapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

public class sqlhelper extends SQLiteOpenHelper {


    public sqlhelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    public void queryData(String sql){

        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);
    }

    public void insertdata(String name, String price,String type,String description, byte[] image){
        SQLiteDatabase database = getWritableDatabase();
        String sql = "INSERT INTO FOOD VALUES(NULL, ?, ?, ?, ?, ? )";

        SQLiteStatement statement= database.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1, name);
        statement.bindString(2, price);
        statement.bindString(3, type);
        statement.bindString(4, description);
        statement.bindBlob(5, image);

        statement.executeInsert();
    }

    public void updateData(String name, String price, String type, String description, byte[] image, int id){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        String sql = "UPDATE FOOD SET name = ?, price = ?, type = ?, description = ?, image = ? WHERE  Id = ?";
        SQLiteStatement sqLiteStatement = sqLiteDatabase.compileStatement(sql);

        sqLiteStatement.bindString(1, name);
        sqLiteStatement.bindString(2, price);
        sqLiteStatement.bindString(3, type);
        sqLiteStatement.bindString(4, description);
        sqLiteStatement.bindBlob(5, image);
        sqLiteStatement.bindDouble(6,(double)id);

        sqLiteStatement.execute();
        sqLiteDatabase.close();

    }


    public void deleteData(int id){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        String sql = "DELETE FROM FOOD WHERE Id = ?";
        SQLiteStatement sqLiteStatement = sqLiteDatabase.compileStatement(sql);
        sqLiteStatement.clearBindings();
        sqLiteStatement.bindDouble(1,(double)id);

        sqLiteStatement.execute();
        sqLiteDatabase.close();
    }



    public Cursor getdata(String sql){

        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery(sql,null);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}
