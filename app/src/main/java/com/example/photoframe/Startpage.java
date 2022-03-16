package com.example.photoframe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class Startpage extends AppCompatActivity {


    RecyclerView frame_recycleview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startpage);

        getSupportActionBar().hide();

        String[] category = {"Cartoon Frame","Birthday Frame","Flower Frame","Bollywood Frame","Love Frame","Anniversary Frame","Festival Frame","Nature Frame"};
        int[] background = {R.drawable.bg1,R.drawable.bg2,R.drawable.bg3,R.drawable.bg4,R.drawable.bg5,R.drawable.bg6,R.drawable.bg7,R.drawable.bg8};


        frame_recycleview = findViewById(R.id.frame_recycleview);

        Category_adapter category_adapter = new Category_adapter(Startpage.this,category,background);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(Startpage.this,2);
        frame_recycleview.setLayoutManager(layoutManager);
        frame_recycleview.setAdapter(category_adapter);










    }
}