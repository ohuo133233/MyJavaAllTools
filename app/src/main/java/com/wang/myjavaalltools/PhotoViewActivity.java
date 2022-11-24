package com.wang.myjavaalltools;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.bm.library.PhotoView;

public class PhotoViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_view);

//        PhotoView photoView = (PhotoView) findViewById(R.id.photo_view);
//        photoView.setImageResource(R.mipmap.max);
        PhotoView photoView = (PhotoView) findViewById(R.id.photo_view);
        photoView.enable();
    }
}