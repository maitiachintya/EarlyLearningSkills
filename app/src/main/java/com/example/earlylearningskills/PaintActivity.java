package com.example.earlylearningskills;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Toast;

import com.example.earlylearningskills.customview.DrawingView;

import java.io.OutputStream;

public class PaintActivity extends AppCompatActivity implements View.OnClickListener {
    SeekBar mThickness;
    Bitmap alteredBitmap;
    ImageView imghome, imgerase, imgdraw, saveimg;

    private DrawingView mDrawLayout;
    SeekBar seekBar;
    private Paint drawPaint = new Paint();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paint);
        mThickness = (SeekBar) findViewById(R.id.thickness);
        mDrawLayout = (DrawingView) findViewById(R.id.viewDraw);
        imgerase = findViewById(R.id.eraseop);
        imgdraw = findViewById(R.id.drawoption);
        /*choosenImageView = (ImageView) this.findViewById(R.id.ChoosenImageView);
        choosePicture = (Button) this.findViewById(R.id.ChoosePictureButton);*/
        saveimg = (ImageView) this.findViewById(R.id.downloading);
        saveimg.setOnClickListener(this);
        mDrawLayout.setVisibility(View.VISIBLE);
        mDrawLayout.setDrawingCacheEnabled(true);
        mDrawLayout.setEnabled(true);
        mThickness.setMax(50);
        mThickness.setProgress(10);
        mDrawLayout.setPaintAlpha(mThickness.getProgress());
        int currLevel = mDrawLayout.getPaintAlpha();
        mThickness.setProgress(currLevel);
        mDrawLayout.invalidate();
        imghome = findViewById(R.id.homeop);
        imghome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainactivity = new Intent(PaintActivity.this, HomeActivity.class);
                startActivity(mainactivity);
            }
        });
        imgerase.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                drawPaint.setColor(Color.TRANSPARENT);
                mDrawLayout.setErase(true);

            }
        });
        imgdraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawLayout.setErase(false);

            }
        });

        mThickness.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                mDrawLayout.setPaintAlpha(mThickness.getProgress());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        if (view == saveimg) {

            if (alteredBitmap != null) {
                ContentValues contentValues = new ContentValues(3);
                contentValues.put(MediaStore.Images.Media.DISPLAY_NAME, "Draw On Me");

                Uri imageFileUri = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
                try {
                    OutputStream imageFileOS = getContentResolver().openOutputStream(imageFileUri);
                    alteredBitmap.compress(Bitmap.CompressFormat.JPEG, 90, imageFileOS);
                    Toast t = Toast.makeText(this, "Saved!", Toast.LENGTH_SHORT);
                    t.show();

                } catch (Exception e) {
                    Log.v("EXCEPTION", e.getMessage());
                }
            }
        }
    }
}