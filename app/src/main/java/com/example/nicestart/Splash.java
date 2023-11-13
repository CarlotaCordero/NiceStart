package com.example.nicestart;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ImageView photoSplash = findViewById(R.id.fondoSplas);
        Glide.with(this)
                .load(R.drawable.fondo_splash)
                .into(photoSplash);
    }
}