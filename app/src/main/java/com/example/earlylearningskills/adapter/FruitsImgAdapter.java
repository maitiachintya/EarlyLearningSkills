package com.example.earlylearningskills.adapter;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import com.example.earlylearningskills.FruitsActivity;
import com.example.earlylearningskills.FruitsImageModel;
import com.example.earlylearningskills.R;

import java.util.ArrayList;

public class FruitsImgAdapter extends Adapter<FruitsImgAdapter.ViewHolder> {
    Context context;
    ArrayList<FruitsImageModel> arrimg1 = new ArrayList<>();

    public FruitsImgAdapter(Context context, ArrayList<FruitsImageModel> arrimg1) {
        this.context = context;
        this.arrimg1 = arrimg1;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.fruitsimageview,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.txt_vw.setText(arrimg1.get(position).getName());
            holder.imageView_letter.setImageResource(arrimg1.get(position).getCharecter_img());
            holder.imaageview_pic.setImageResource(arrimg1.get(position).getCharecter());
    }

    @Override
    public int getItemCount() {
        return arrimg1.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txt_vw;
        ImageView imageView_letter,imaageview_pic;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_vw = itemView.findViewById(R.id.txt);
            imageView_letter = itemView.findViewById(R.id.identityletter);
            imaageview_pic = itemView.findViewById(R.id.identitypicture);
            imageView_letter = itemView.findViewById(R.id.identityletter);
        }
    }
}
