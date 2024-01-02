package com.example.earlylearningskills;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    ArrayList<imgmodel> arrimg = new ArrayList<>();
    RecyclerView recyclerView;
    Imageadepter imageadepter;
    ImageButton imageButton;
    ImageView imageView,arrowsign;
    MediaPlayer mediaPlayer;
    String whatsappUser = "918072857939";
    boolean ismusicplayerstart = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycleimg);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        arrimg.add(new imgmodel(R.drawable.mspaint));
        arrimg.add(new imgmodel(R.drawable.alphabetlogo));
        arrimg.add(new imgmodel(R.drawable.quizlogo));
        arrimg.add(new imgmodel(R.drawable.headphone));
        arrimg.add(new imgmodel(R.drawable.fruits));
        arrimg.add(new imgmodel(R.drawable.numericdig));
        arrimg.add(new imgmodel(R.drawable.animal));
        arrimg.add(new imgmodel(R.drawable.vegetables));
        arrimg.add(new imgmodel(R.drawable.carslogo));
        arrimg.add(new imgmodel(R.drawable.birdslogo));
        imageButton = findViewById(R.id.spklg);
        imageView = findViewById(R.id.sharedconv);
        arrowsign = findViewById(R.id.arrowsign);
        mediaPlayer = MediaPlayer.create(this, R.raw.audiotune);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // ismusicplayerstart = !ismusicplayerstart;

                if(ismusicplayerstart == false){

                 mediaPlayer.start();
                 ismusicplayerstart = true;
                 imageButton.setBackgroundResource(R.drawable.speakerlogo);
                }
                else if(ismusicplayerstart == true){
                 mediaPlayer.pause();
                 ismusicplayerstart = false;
                    imageButton.setBackgroundResource(R.drawable.speakerlogo);
                }
            }
        });
        /*imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.pause();
            }
        });*/
        imageadepter = new Imageadepter(this,arrimg, new OnItemclick(){
            @Override
            public void Itemclick(int pos) {
                if(pos == 0){
                    Intent paintActivity = new Intent(HomeActivity.this, PaintActivity.class);
                    startActivity(paintActivity);
                }
                else if(pos ==1){
                    Intent learningactivity = new Intent(HomeActivity.this,LearnActivity.class);
                    startActivity(learningactivity);
                }
               else if(pos ==4){
                    Intent frtactivity = new Intent(HomeActivity.this,FruitsActivity.class);
                    startActivity(frtactivity);
               }
            }
        });
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,2);
        //recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,true));
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(imageadepter);

        RecyclerView.SmoothScroller smoothScroller = new LinearSmoothScroller(this) {
            @Override protected int getVerticalSnapPreference() {
                return LinearSmoothScroller.SNAP_TO_START;
            }
        };
        arrowsign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //smoothScroller.setTargetPosition(5);
               // recyclerView.imageadepter.notifyItemChanged(5);
                recyclerView.smoothScrollToPosition(4);
            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              /*  String url = "https://api.whatsapp.com/send?phone=" + whatsappUser;
                try {
                    PackageManager pm = getApplicationContext().getPackageManager();
                    pm.getPackageInfo("com.whatsapp", PackageManager.GET_ACTIVITIES);
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);
                } catch (PackageManager.NameNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
                }*/
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
                sendIntent.setType("text/plain");
                sendIntent.setPackage("com.whatsapp");
                startActivity(sendIntent);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(mediaPlayer.isPlaying())
            mediaPlayer.pause();
    }
}