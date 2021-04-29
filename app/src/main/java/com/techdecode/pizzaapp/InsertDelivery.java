package com.techdecode.pizzaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.techdecode.pizzaapp.Model.DeliveryDetailsModel;

import java.io.Serializable;

public class InsertDelivery extends AppCompatActivity {
    Button confirm,back;
//    EditText fName,lName,email,contact,address;
   // DBHelper db;

    AwesomeValidation awesomevalidation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_delivery);
        confirm = findViewById(R.id.dConfirm);
       final EditText fName =findViewById(R.id.fName);
        final EditText lName =findViewById(R.id.lName);
        final EditText email =findViewById(R.id.email);
        final EditText contact =findViewById(R.id.contactNumber);
        final EditText address =findViewById(R.id.address);

       // db = new DBHelper(this);
        //style
        awesomevalidation = new AwesomeValidation(ValidationStyle.BASIC);

        awesomevalidation.addValidation(this,R.id.fName, RegexTemplate.NOT_EMPTY,R.string.invalid_name);

        awesomevalidation.addValidation(this,R.id.lName, RegexTemplate.NOT_EMPTY,R.string.invalid_name);

        awesomevalidation.addValidation(this,R.id.email,android.util.Patterns.EMAIL_ADDRESS, R.string.invalid_email);

        awesomevalidation.addValidation(this, R.id.contactNumber, RegexTemplate.TELEPHONE, R.string.err_tel);

        awesomevalidation.addValidation(this,R.id.address, RegexTemplate.NOT_EMPTY,R.string.invalid_address);


        String fNameTXT = fName.getText().toString();
        String lNameTXT = lName.getText().toString();
        String emailTXT = email.getText().toString();
        String contactTXT = contact.getText().toString();
        String addressTXT = address.getText().toString();


        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {





                if( awesomevalidation.validate()){

//                    Intent i = new Intent(InsertDelivery.this, InsertPayment.class);
//                    i.putExtra("FIRST_NAME",fNameTXT);
//                    i.putExtra("LAST_NAME",lNameTXT);
//                    i.putExtra("EMAIL",emailTXT);
//                    i.putExtra("CONTACT",contactTXT);
//                    i.putExtra("ADDRESS",addressTXT);
//                    startActivity(i);


                    DeliveryDetailsModel obj=new DeliveryDetailsModel();
                    obj.setfName(fNameTXT+"");
                    obj.setlName(lNameTXT+"");
                    obj.setEmail(emailTXT+"");
                    obj.setContact(contactTXT+"");
                    obj.setAddress(addressTXT+"");

                    Intent i = new Intent(InsertDelivery.this, InsertPayment.class);
                    i.putExtra("MyClass", (Serializable) obj);
                    startActivity(i);

                }
//
//
//
//                else
//                    Toast.makeText(getApplicationContext(), "New Entry Not Inserted", Toast.LENGTH_SHORT).show();
                    }


            });


    }


}