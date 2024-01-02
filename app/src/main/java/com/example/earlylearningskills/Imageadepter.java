package com.example.earlylearningskills;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public  class Imageadepter  extends RecyclerView.Adapter<Imageadepter.ViewHolder> {

    ArrayList<imgmodel> arrimg;
    HomeActivity mainActivity;
    OnItemclick onItemclick;


    public Imageadepter(HomeActivity mainActivity, ArrayList<imgmodel> arrimg, OnItemclick onItemclick) {
        this.mainActivity = mainActivity;
        this.arrimg = arrimg;
        this.onItemclick = onItemclick;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mainActivity).inflate(R.layout.imgview,null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imageView.setImageResource(arrimg.get(position).img);
        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemclick.Itemclick(position);

            }
        });
    }

    @Override
    public int getItemCount() {
        return arrimg.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        ConstraintLayout constraintLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.identityimg);
            constraintLayout = itemView.findViewById(R.id.itemtouch);
        }
    }
}
