package com.example.pramila.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editText = (EditText)findViewById(R.id.Editetxtusername);
        EditText editText1 =(EditText)findViewById(R.id.Edittextpassword);

        Button btnjoin = (Button) findViewById(R.id.btnjoin);
        btnjoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), register.class);
                view.getContext().startActivity(intent);
            }
        });
        final EditText editTex = (EditText)findViewById(R.id.Editetxtusername);
        final EditText editText0 =(EditText)findViewById(R.id.Edittextpassword);

        Button btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editTex.getText().length()<=0)
                {
                    Toast.makeText(MainActivity.this, "Enter username", Toast.LENGTH_SHORT).show();
                }
                if(editText0.getText().length()<=0)
                {
                    Toast.makeText(MainActivity.this, "Enter password", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent = new Intent(view.getContext(), RequestActivity.class);
                    view.getContext().startActivity(intent);
                }
            }
        });
        Button btnlearn = (Button) findViewById(R.id.btnlearn);
        btnlearn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), learn.class);
                view.getContext().startActivity(intent);
            }
        });


    }
}





