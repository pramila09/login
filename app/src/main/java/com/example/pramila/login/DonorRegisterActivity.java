package com.example.pramila.login;

import android.content.Intent;
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

public class DonorRegisterActivity extends AppCompatActivity {
    EditText EditTextfirst, EditTextlast, EditTextemail, EditTextpassword, EditTextconfirmpassword, EditTextdob, EditTextcontact, EditTextaddress;
    Spinner spinnerGender, spinnerbloodgrp;
    Button btnsave;
    DatabaseReference databaseDonors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor_register);

        databaseDonors = FirebaseDatabase.getInstance().getReference("donors");

        EditTextfirst = (EditText) findViewById(R.id.EditTextfirst);
        EditTextlast = (EditText) findViewById(R.id.EditTextlast);
        EditTextpassword = (EditText) findViewById(R.id.EditTextpassword);
        EditTextconfirmpassword = (EditText) findViewById(R.id.EditTextconfirmpassword);
        EditTextaddress = (EditText) findViewById(R.id.EditTextaddress);
        EditTextcontact = (EditText) findViewById(R.id.EditTextcontact);
        EditTextdob = (EditText) findViewById(R.id.EditTextdob);
        spinnerGender = (Spinner) findViewById(R.id.spinnerGender);
        spinnerbloodgrp = (Spinner) findViewById(R.id.spinnerbloodgrp);

        Button btnsave = (Button) findViewById(R.id.btnsave);
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), PhoneAuthActivity.class);
                view.getContext().startActivity(intent);
                addDonor();
            }
        });
    }

    private void addDonor() {
        String firstname = EditTextfirst.getText().toString().trim();
        String lastname = EditTextlast.getText().toString().trim();
        String password = EditTextpassword.getText().toString().trim();
        String confirmpassword = EditTextconfirmpassword.getText().toString().trim();
        //if(!password.equals(confirmpassword)){
        //Toast.makeText(this,"Password is not matching",Toast.LENGTH_LONG).show();
        //}

        String address = EditTextaddress.getText().toString().trim();
        String contact = EditTextaddress.getText().toString().trim();
        String dob = EditTextdob.getText().toString().trim();
        String Gender = spinnerGender.getSelectedItem().toString();
        String Bloodgrp = spinnerbloodgrp.getSelectedItem().toString();

        if (!TextUtils.isEmpty(firstname)) {

            String id = databaseDonors.push().getKey();
            User user = new User(id, firstname, lastname, password, confirmpassword, address, contact, dob, Gender, Bloodgrp);
            databaseDonors.child(id).setValue(user);
            Toast.makeText(this, "User added", Toast.LENGTH_LONG).show();

        } else {
            Toast.makeText(this, "You should fill all the empty fields", Toast.LENGTH_LONG).show();


        }
    }
}
