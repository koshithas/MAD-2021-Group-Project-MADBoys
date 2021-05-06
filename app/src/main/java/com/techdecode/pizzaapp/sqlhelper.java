package com.techdecode.pizzaapp;

import android.content.ContentValues;
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

    //sawishka

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

    //sawishka
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


    //sawishka
    public void deleteData(int id){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        String sql = "DELETE FROM FOOD WHERE Id = ?";
        SQLiteStatement sqLiteStatement = sqLiteDatabase.compileStatement(sql);
        sqLiteStatement.clearBindings();
        sqLiteStatement.bindDouble(1,(double)id);

        sqLiteStatement.execute();
        sqLiteDatabase.close();
    }


    //sawishka

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



    //sangeeth

    public boolean insertUser(String username,String email, String contact, String password){

        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username",username);
        contentValues.put("email",email);
        contentValues.put("contact",contact);
        contentValues.put("password",password);

        long ins =db.insert("user",null,contentValues);

        if (ins == -1){
            return false;
        }else {
            return true;
        }
    }

    public boolean checkUsername(String username){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from user where username = ?",new String[] {username});

        if (cursor.getCount()> 0){
            return false;
        }else {
            return true;
        }
    }


    public boolean emailPassword(String username, String password){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from user where username= ? and password= ?",new String[]{username,password});


        if (cursor.getCount()> 0){
            return true;
        }else {
            return false;
        }
    }





    public Cursor getUserData(String username){

        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery("select * from user where username= ?",new String[]{username});

    }

    public void updateUserData(String email, String contact, String password, String username){

        SQLiteDatabase db =this.getWritableDatabase();

        String sql = "UPDATE user SET email = ?, contact = ?, password = ? WHERE  username = ?";
        SQLiteStatement sqLiteStatement = db.compileStatement(sql);

        sqLiteStatement.bindString(1, email);
        sqLiteStatement.bindString(2, contact);
        sqLiteStatement.bindString(3, password);
        sqLiteStatement.bindString(4, username);

        sqLiteStatement.execute();
        db.close();


    }




    public void deleteUserData(String username){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        String sql = "DELETE FROM user WHERE username = ?";

        SQLiteStatement sqLiteStatement = sqLiteDatabase.compileStatement(sql);
        sqLiteStatement.clearBindings();
        sqLiteStatement.bindString(1,username);

        sqLiteStatement.execute();
        sqLiteDatabase.close();
    }





    //savindu

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


    public void deleteOrderData(int id) {
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
