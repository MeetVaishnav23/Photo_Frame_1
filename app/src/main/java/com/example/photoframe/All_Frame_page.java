package com.example.photoframe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.ListResult;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;

import pl.droidsonroids.gif.GifImageView;

public class All_Frame_page extends AppCompatActivity {

    TextView header;
    RecyclerView allframe_recycle;

   public static ImageView frame_image;

    List<Framemodalclass> framelist = new ArrayList<>();

    List<Uri> list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_frame_page);

        getSupportActionBar().hide();

        Binding();

        Intent intent = getIntent();

        String title = intent.getStringExtra("cat_text");


        header.setText(title);


//        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
//        DatabaseReference databaseReference = firebaseDatabase.getReference();
//
//
//        databaseReference.child("Frames").child(title).addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//
//                for (DataSnapshot dataSnapshot : snapshot.getChildren())
//                {
//                    String frame = dataSnapshot.child("frame").getValue().toString();
//
//                    Framemodalclass framemodalclass = new Framemodalclass(frame);
//                    framelist.add(framemodalclass);
//
//                }
//
//                Frame_Adapter frame_adapter = new Frame_Adapter(All_Frame_page.this,framelist);
//                RecyclerView.LayoutManager layoutManager = new GridLayoutManager(All_Frame_page.this,2);
//                allframe_recycle.setLayoutManager(layoutManager);
//                allframe_recycle.setAdapter(frame_adapter);
//
//                back_gif.setVisibility(View.INVISIBLE);
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });


        FirebaseStorage firebaseStorage = FirebaseStorage.getInstance();
        StorageReference storageRef = firebaseStorage.getReference();


        storageRef.child(title).listAll().addOnSuccessListener(new OnSuccessListener<ListResult>() {
            @Override
            public void onSuccess(ListResult listResult) {


                for(StorageReference sf : listResult.getItems()) {


                    sf.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                        @Override
                        public void onSuccess(Uri uri) {

                            list.add(uri);

                            Frame_Adapter frame_adapter = new Frame_Adapter(All_Frame_page.this, list);
//                            RecyclerView.LayoutManager layoutManager = new GridLayoutManager(All_Frame_page.this, 2);
                            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(All_Frame_page.this,RecyclerView.HORIZONTAL,false);
                            allframe_recycle.setLayoutManager(layoutManager);
                            allframe_recycle.setAdapter(frame_adapter);


                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {

                            Toast.makeText(All_Frame_page.this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    });


                }


            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

                Toast.makeText(All_Frame_page.this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });


    }


    void Binding() {
        header = findViewById(R.id.header);
        allframe_recycle = findViewById(R.id.allframe_recycle);
        frame_image = findViewById(R.id.frame_image);
    }


}