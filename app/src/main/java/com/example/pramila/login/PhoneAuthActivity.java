package com.example.pramila.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class PhoneAuthActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;

    EditText editTextPhone, editTextCode;
    String codeSent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_auth);

        editTextCode = findViewById(R.id.editTextCode);
        editTextPhone = findViewById(R.id.editTextPhone);

        mAuth = FirebaseAuth.getInstance();
        findViewById(R.id.buttonGetVerificationCode).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendVerificationCode();

            }
        });

        findViewById(R.id.buttonSignIn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               verifySignInCode();
            }
        });
    }
    private void verifySignInCode(){
        String code = editTextCode.getText().toString();
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(codeSent, code);
        signInWithPhoneAuthCredential(credential);

    }
    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            //Toast.makeText(getApplicationContext(),
                                    //"Login Successful",Toast.LENGTH_LONG).show();
                            Button buttonSignIn = (Button) findViewById(R.id.buttonSignIn);
                            buttonSignIn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent = new Intent(view.getContext(),MainActivity.class);
                                    view.getContext().startActivity(intent);
                                }
                            });

                        } else {
                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                                // The verification code entered was invalid
                                Toast.makeText(getApplicationContext(),
                                        "Login UnSuccessful",Toast.LENGTH_LONG).show();

                        }
                    }
                }
                });
    }


    private void sendVerificationCode(){
        String phone = editTextPhone.getText().toString();
        if(phone.isEmpty()){
            editTextPhone.setError("Phone number is required");
            editTextPhone.requestFocus();
            return;
        }
        if(phone.length()<10){
            editTextPhone.setError("Please enter a valid number");
            editTextPhone.requestFocus();
            return;
        }
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                phone,        // Phone number to verify
                60,                 // Timeout duration
                TimeUnit.SECONDS,   // Unit of timeout
                this,               // Activity (for callback binding)
                mCallbacks);        // OnVerificationStateChangedCallbacks

    }

    PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        @Override
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {

        }

        @Override
        public void onVerificationFailed(FirebaseException e) {

        }

        @Override
        public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);
            codeSent = s;
        }
    };
}