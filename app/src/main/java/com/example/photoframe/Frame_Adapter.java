package com.example.photoframe;

import static com.example.photoframe.All_Frame_page.frame_image;

import android.app.Activity;
import android.media.Image;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class Frame_Adapter extends RecyclerView.Adapter<Frame_Adapter.FrameData> {

    List<Framemodalclass> framelist;
    List<Uri> list;
    Activity activity;

    static int i=1;

//    public Frame_Adapter(All_Frame_page all_frame_page, List<Framemodalclass> framelist) {
//
//        this.framelist = framelist;
//        activity = all_frame_page;
//
//    }

    public Frame_Adapter(All_Frame_page all_frame_page, List<Uri> list) {

        activity = all_frame_page;
        this.list = list;

    }

    @NonNull
    @Override
    public FrameData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(activity).inflate(R.layout.framedesign,parent,false);

        return new FrameData(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FrameData holder, int position) {

        Glide.with(activity).load(list.get(position)).into(holder.frame_img);






        holder.frame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Glide.with(activity).load(list.get(position)).into(frame_image);

            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class  FrameData extends RecyclerView.ViewHolder {

        ImageView frame_img;
        CardView frame;

        public FrameData(@NonNull View itemView) {
            super(itemView);

            frame_img = itemView.findViewById(R.id.frame_img);

            frame = itemView.findViewById(R.id.frame);

        }
    }

}
