package com.example.nicestart;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ImageView photoSplash = findViewById(R.id.fondoSplash);
        Glide.with(this)
                //Cargamos con la URL
                .load("https://images.unsplash.com/photo-1690460550070-e73402127f11?q=80&w=1887&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D")
                //Transicion mientras se puede obtener la imagen con la URL
                .transition(DrawableTransitionOptions.withCrossFade(2000))
                //Que se va a mostrar hasta que se cargue la imagen
                .placeholder(new ColorDrawable(this.getResources().getColor(R.color.fucsia_200)))
                //Centra la foto y recorta los bordes
                .centerCrop()
                //Insrta la foto en mi ImageView
                .into(photoSplash);
    }
}