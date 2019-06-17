package com.example.pramila.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RequestActivity extends AppCompatActivity {
    EditText EditTextquantity, EditTexttime;
    Spinner spinnerbloodgroup;
    Button btnsendrequest;
    DatabaseReference databaseRequest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);

        databaseRequest = FirebaseDatabase.getInstance().getReference("requests");

        spinnerbloodgroup = (Spinner) findViewById(R.id.spinnerbloodgrp);
        EditTextquantity = (EditText) findViewById(R.id.EditTextquantity);
        EditTexttime = (EditText) findViewById(R.id.EditTexttime);

        Button btnsendrequest = (Button) findViewById(R.id.btnsendrequest);
        btnsendrequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addRequest();
            }
        });
    }
        private void addRequest(){
        String bloodgrp = spinnerbloodgroup.getSelectedItem().toString().trim();
        String Quantity =EditTextquantity.getText().toString().trim();
        String Time = EditTexttime.getText().toString().trim();

        if(!TextUtils.isEmpty(bloodgrp)){
            String id = databaseRequest.push().getKey();
            Requests requests = new Requests(id, bloodgrp, Quantity, Time);
            databaseRequest.child(id).setValue(requests);
            Toast.makeText(this,"Request is sent successfully",Toast.LENGTH_LONG).show();

        }else{
            Toast.makeText(this,"You should enter the empty fields",Toast.LENGTH_LONG).show();

        }

        }

       // Button btnsendrequest = (Button) findViewById(R.id.btnsendrequest);
        //btnsendrequest.setOnClickListener(new View.OnClickListener() {
           // @Override
            //public void onClick(View view) {
              //  Toast.makeText(this,"Request sent successfully",Toast.LENGTH_LONG).show();
           // }
       // });

   // }
}
