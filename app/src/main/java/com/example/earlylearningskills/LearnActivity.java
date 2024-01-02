package com.example.earlylearningskills;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.earlylearningskills.adapter.LearningActivityAdapter;

import java.util.ArrayList;

public class LearnActivity extends AppCompatActivity {
    ArrayList<LearningImageModel> arrimg = new ArrayList<>();
    RecyclerView recyclerView;
    Imageadepter imageadepter;
    ImageView imageView,leftarrow,rightarrow,imghome;
    LearningActivityAdapter learningActivityAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);
        imghome = findViewById(R.id.homesign);
        recyclerView = findViewById(R.id.recycleimage);
        LinearLayoutManager linearLayoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setNestedScrollingEnabled(false);
        //recyclerView.setLayoutManager(new LinearLayoutManager(LearnActivity.this,LinearLayoutManager.HORIZONTAL, false));
        arrimg.add(new LearningImageModel(R.drawable.a, R.drawable.apple));
        arrimg.add(new LearningImageModel(R.drawable.blogo, R.drawable.ball));
        arrimg.add(new LearningImageModel(R.drawable.c, R.drawable.cat));
        arrimg.add(new LearningImageModel(R.drawable.d, R.drawable.dog));
        arrimg.add(new LearningImageModel(R.drawable.e, R.drawable.elephant));
        arrimg.add(new LearningImageModel(R.drawable.f, R.drawable.flag));
        arrimg.add(new LearningImageModel(R.drawable.g, R.drawable.goat));
        arrimg.add(new LearningImageModel(R.drawable.h, R.drawable.hen));
        arrimg.add(new LearningImageModel(R.drawable.i, R.drawable.icecream));
        arrimg.add(new LearningImageModel(R.drawable.j, R.drawable.jug));
        arrimg.add(new LearningImageModel(R.drawable.k, R.drawable.kite));
        arrimg.add(new LearningImageModel(R.drawable.l, R.drawable.lamp));
        arrimg.add(new LearningImageModel(R.drawable.m, R.drawable.mango));
        arrimg.add(new LearningImageModel(R.drawable.n, R.drawable.nest));
        arrimg.add(new LearningImageModel(R.drawable.o, R.drawable.orange));
        arrimg.add(new LearningImageModel(R.drawable.p, R.drawable.parrot));
        arrimg.add(new LearningImageModel(R.drawable.q, R.drawable.queen));
        arrimg.add(new LearningImageModel(R.drawable.r, R.drawable.rose));
        arrimg.add(new LearningImageModel(R.drawable.s, R.drawable.snake));
        arrimg.add(new LearningImageModel(R.drawable.t, R.drawable.table));
        arrimg.add(new LearningImageModel(R.drawable.u, R.drawable.umbrella));
        arrimg.add(new LearningImageModel(R.drawable.v, R.drawable.vulture));
        arrimg.add(new LearningImageModel(R.drawable.w, R.drawable.wristwatch));
        arrimg.add(new LearningImageModel(R.drawable.x, R.drawable.xylophone));
        arrimg.add(new LearningImageModel(R.drawable.y, R.drawable.yak));
        arrimg.add(new LearningImageModel(R.drawable.z, R.drawable.zebra));
        learningActivityAdapter = new LearningActivityAdapter(this,arrimg);
        recyclerView.setAdapter(learningActivityAdapter);
        imghome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainactivity = new Intent(LearnActivity.this, HomeActivity.class);
                startActivity(mainactivity);
            }
        });

    }
}