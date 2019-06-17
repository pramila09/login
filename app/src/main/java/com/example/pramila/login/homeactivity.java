package com.example.pramila.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class homeactivity extends AppCompatActivity {
    ImageView image, image2, image3, image4, image5, image6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homeactivity);
        click();
    }
        public void click()
        {
            image = (ImageView) findViewById(R.id.img);
            image2 = (ImageView) findViewById(R.id.img2);
            image3 = (ImageView) findViewById(R.id.img3);
            image4 = (ImageView) findViewById(R.id.img4);
            image5 = (ImageView) findViewById(R.id.img5);
            image6 = (ImageView) findViewById(R.id.img6);

           image.setOnClickListener(new View.OnClickListener() {

               @Override
               public void onClick(View v) {
                   Intent intent = new Intent(homeactivity.this,MainActivity.class);
                   startActivity(intent);

               }
           });
           image2.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   Intent i = new Intent(homeactivity.this,searchactivity.class);
                   startActivity(i);
               }
           });
           image3.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   Intent i = new Intent(homeactivity.this,secondactivity.class);
                   startActivity(i);
               }
           });
           image4.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   Intent i = new Intent(homeactivity.this,RequestActivity.class);
                   startActivity(i);
               }
           });
           image5.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   Intent i = new Intent(homeactivity.this,banklistactivity.class);
                   startActivity(i);

               }
           });
           image6.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   Intent i = new Intent(homeactivity.this,learn.class);
                   startActivity(i);
               }
           });
        }



    }

