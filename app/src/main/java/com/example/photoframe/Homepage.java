package com.example.photoframe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class Homepage extends AppCompatActivity {

    LinearLayout start_btn,share_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        getSupportActionBar().hide();

        Binding();

        start_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(Homepage.this,Startpage.class));

            }
        });






    }


    void Binding()
    {
        start_btn = findViewById(R.id.start_btn);
        share_btn = findViewById(R.id.share_btn);

    }



}