package com.techdecode.pizzaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.service.autofill.RegexValidator;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;

public class InsertDelivery extends AppCompatActivity {
  Button confirm,back;
  EditText fName,lName,email,contact,address;
  DBHelper db;

  AwesomeValidation awesomevalidation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_delivery);
    confirm = findViewById(R.id.dConfirm);
        fName =findViewById(R.id.fName);
        lName =findViewById(R.id.lName);
        email =findViewById(R.id.email);
        contact =findViewById(R.id.contactNumber);
        address =findViewById(R.id.address);

        db = new DBHelper(this);
        //style
        awesomevalidation = new AwesomeValidation(ValidationStyle.BASIC);

        awesomevalidation.addValidation(this,R.id.fName, RegexTemplate.NOT_EMPTY,R.string.invalid_name);

        awesomevalidation.addValidation(this,R.id.lName, RegexTemplate.NOT_EMPTY,R.string.invalid_name);

        awesomevalidation.addValidation(this,R.id.email,android.util.Patterns.EMAIL_ADDRESS, R.string.invalid_email);

        awesomevalidation.addValidation(this, R.id.contactNumber, RegexTemplate.TELEPHONE, R.string.err_tel);

        awesomevalidation.addValidation(this,R.id.address, RegexTemplate.NOT_EMPTY,R.string.invalid_address);





        confirm.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
        awesomevalidation.validate();
            String fNameTXT = fName.getText().toString();
            String lNameTXT = lName.getText().toString();
            String emailTXT = email.getText().toString();
            String contactTXT = contact.getText().toString();
            String addressTXT = address.getText().toString();


            boolean checkInsertData = db.insertdeliverydata(fNameTXT,lNameTXT,emailTXT,contactTXT,addressTXT);
            if (checkInsertData == true)
                Toast.makeText(getApplicationContext(), "New Entry Inserted", Toast.LENGTH_SHORT).show();
            //Intent i= new Intent(InsertDelivery.this,InsertPayment.class);
                  //startActivity(i);



            else
                Toast.makeText(getApplicationContext(), "New Entry Not Inserted", Toast.LENGTH_SHORT).show();}


    });


  }


}