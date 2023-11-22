package com.example.nicestart;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class Valoracion extends AppCompatActivity {

    private RatingBar ratingBar;
    private Button Alerta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_valoracion);

        ratingBar = (RatingBar) findViewById(R.id.Puntuacion);
        /*Alerta = (Button) findViewById(R.id.Alert);*/
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(Valoracion.this,"Has votado con "+ rating,Toast.LENGTH_LONG).show();
            }
        });
    }
}