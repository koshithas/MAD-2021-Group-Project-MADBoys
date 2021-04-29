package com.techdecode.pizzaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.techdecode.pizzaapp.Model.DeliveryDetailsModel;

public class InsertPayment extends AppCompatActivity {
    EditText cardName,cardNumber,exp,security;

    Button confirm;
    DBHelper db;


    DeliveryDetailsModel detailsModel;


    String TAG="InsertPayment";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_payment);



        // To retrieve object in second Activity
        try{

            detailsModel= (DeliveryDetailsModel) getIntent().getSerializableExtra("MyClass");




        }catch (Exception e){


            Log.e(TAG,e.getMessage());
        }

        Log.e(TAG,"calling");
        Log.e(TAG,detailsModel.getfName()+"");


        cardName = (EditText) findViewById(R.id.cardOnName);
        cardNumber = (EditText) findViewById(R.id.cNumber);
        exp =(EditText)  findViewById(R.id.exp);
        security = (EditText) findViewById(R.id.sCode);
        db = new DBHelper(this);
        confirm =findViewById(R.id.pConfirm);



        String cardNameTXT = cardName.getText().toString();
        String cardNumberTXT = cardName.getText().toString();
        String expTXT = cardName.getText().toString();
        String securityTXT = cardName.getText().toString();

        Intent i = getIntent();
        String fname_txt= i.getStringExtra("FIRST_NAME");
        String lname_txt=  i.getStringExtra("LAST_NAME");
        String emailtxt =i.getStringExtra("EMAIL");
        String contacttxt=i.getStringExtra("CONTACT");
        String addresstxt =i.getStringExtra("ADDRESS");

        


        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checkInsertData = db.insertData(fname_txt,lname_txt,emailtxt,contacttxt,addresstxt,cardNameTXT,cardNumberTXT,expTXT,securityTXT);
                if(checkInsertData = true)
                    Toast.makeText(getApplicationContext(), "New Entry Inserted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(), "New Entry is not Inserted", Toast.LENGTH_SHORT).show();
            }
        });
    }
}