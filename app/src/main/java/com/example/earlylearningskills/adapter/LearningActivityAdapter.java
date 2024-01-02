package com.example.earlylearningskills.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.earlylearningskills.LearnActivity;
import com.example.earlylearningskills.LearningImageModel;
import com.example.earlylearningskills.R;

import java.util.ArrayList;


public class LearningActivityAdapter extends RecyclerView.Adapter<LearningActivityAdapter.ViewHolder> {
    LearnActivity learnActivity;
    ArrayList<LearningImageModel> array;
    public LearningActivityAdapter(LearnActivity learnActivity,ArrayList<LearningImageModel> array){
        this.learnActivity = learnActivity;
        this.array = array;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(learnActivity).inflate(R.layout.alphabetimageview,null);
         ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imageView.setImageResource(array.get(position).getImg());
        holder.imageset.setImageResource(array.get(position).getAlphabat());
    }

    @Override
    public int getItemCount() {
        return array.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        ConstraintLayout constraintLayout;
        AppCompatImageView imageView,imageset;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.letteralphabet);
            imageset = itemView.findViewById(R.id.identitypicture);
        }
    }
}
