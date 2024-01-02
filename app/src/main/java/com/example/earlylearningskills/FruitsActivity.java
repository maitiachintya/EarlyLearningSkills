package com.example.earlylearningskills;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.earlylearningskills.adapter.FruitsImgAdapter;

import java.util.ArrayList;

public class FruitsActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ImageView imageView,leftarrow,rightarrow,imghome;
    ArrayList<FruitsImageModel> arrimg1 = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruits);
       // FruitsActivityAdapter ActivityAdapter;
        imghome = findViewById(R.id.homesign);
        recyclerView = findViewById(R.id.recycleimage);
        LinearLayoutManager linearLayoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setNestedScrollingEnabled(false);
        arrimg1.add(new FruitsImageModel(R.drawable.a, R.drawable.apple,"Apple"));
        arrimg1.add(new FruitsImageModel(R.drawable.b,R.drawable.banana, "Banana"));
        arrimg1.add(new FruitsImageModel(R.drawable.c, R.drawable.cherries, "Cherries"));
        arrimg1.add(new FruitsImageModel(R.drawable.d,R.drawable.strawberry, "Dog"));
        arrimg1.add(new FruitsImageModel(R.drawable.e, R.drawable.elephant, "Apple"));
        arrimg1.add(new FruitsImageModel(R.drawable.f, R.drawable.flag, "Apple"));
        arrimg1.add(new FruitsImageModel(R.drawable.g, R.drawable.goat, "Apple"));
        arrimg1.add(new FruitsImageModel(R.drawable.h, R.drawable.hen, "Apple"));
        arrimg1.add(new FruitsImageModel(R.drawable.i, R.drawable.icecream, "Apple"));
        arrimg1.add(new FruitsImageModel(R.drawable.j, R.drawable.jug, "Apple"));
        arrimg1.add(new FruitsImageModel(R.drawable.k, R.drawable.kite, "Apple"));
        arrimg1.add(new FruitsImageModel(R.drawable.l, R.drawable.lamp, "Apple"));
        arrimg1.add(new FruitsImageModel(R.drawable.m, R.drawable.mango, "Apple"));
        arrimg1.add(new FruitsImageModel(R.drawable.n, R.drawable.nest, "Apple"));
        arrimg1.add(new FruitsImageModel(R.drawable.o, R.drawable.orange, "Apple"));
        arrimg1.add(new FruitsImageModel(R.drawable.p, R.drawable.parrot, "Apple"));
        arrimg1.add(new FruitsImageModel(R.drawable.q, R.drawable.queen, "Apple"));
        arrimg1.add(new FruitsImageModel(R.drawable.r, R.drawable.rose, "Apple"));
        arrimg1.add(new FruitsImageModel(R.drawable.s, R.drawable.snake, "Apple"));
        arrimg1.add(new FruitsImageModel(R.drawable.t, R.drawable.table, "Apple"));
        arrimg1.add(new FruitsImageModel(R.drawable.u, R.drawable.umbrella, "Apple"));
        arrimg1.add(new FruitsImageModel(R.drawable.v, R.drawable.vulture, "Apple"));
        arrimg1.add(new FruitsImageModel(R.drawable.w, R.drawable.wristwatch, "Apple"));
        arrimg1.add(new FruitsImageModel(R.drawable.x, R.drawable.xylophone, "Apple"));
        arrimg1.add(new FruitsImageModel(R.drawable.y, R.drawable.yak, "Apple"));
        arrimg1.add(new FruitsImageModel(R.drawable.z, R.drawable.zebra, "Apple"));
        FruitsImgAdapter fruitsImgAdapter = new FruitsImgAdapter(this,arrimg1);
        recyclerView.setAdapter(fruitsImgAdapter);
    }
}