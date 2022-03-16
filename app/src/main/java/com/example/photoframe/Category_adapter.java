package com.example.photoframe;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Category_adapter extends RecyclerView.Adapter<Category_adapter.CategoryData> {

    String[] category;
    int[] background;
    Activity activity;

    public Category_adapter(Startpage startpage, String[] category, int[] background) {

        this.category = category;
        this.background = background;
        activity = startpage;

    }

    @NonNull
    @Override
    public CategoryData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(activity).inflate(R.layout.category_design,parent,false);

        return new CategoryData(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryData holder, int position) {

        holder.cat_img.setImageResource(background[position]);
        holder.cat_text.setText(category[position]);

        holder.linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(activity,All_Frame_page.class);
                intent.putExtra("cat_text",category[position]);

                activity.startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return category.length;
    }

    class CategoryData extends RecyclerView.ViewHolder {

        ImageView cat_img;
        TextView cat_text;
        LinearLayout linear;

        public CategoryData(@NonNull View itemView) {
            super(itemView);

            cat_img = itemView.findViewById(R.id.cat_img);
            cat_text = itemView.findViewById(R.id.cat_text);
            linear = itemView.findViewById(R.id.linear);

        }
    }

}
