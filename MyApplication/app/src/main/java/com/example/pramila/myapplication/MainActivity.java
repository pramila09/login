package com.example.pramila.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button addbtn = (Button) findViewById(R.id.addbtn);
        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText firstnumedittext = (EditText) findViewById(R.id.firstnumedittext);
                EditText secondnumedittext = (EditText) findViewById(R.id.secondnumedittext);
                TextView ResultTextView = (TextView) findViewById(R.id.ResultTextView);
                int num1 = Integer.parseInt(firstnumedittext.getText().toString());
                int num2 = Integer.parseInt(secondnumedittext.getText().toString());
                int result = num1 + num2;
                ResultTextView.setText(result + "");


            }
        });

    }
}
