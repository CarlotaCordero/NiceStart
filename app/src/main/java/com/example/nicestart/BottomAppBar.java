package com.example.nicestart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class BottomAppBar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_app_bar);

        //BottomAppBar bottomAppBar = findViewById(R.id.bottom_app_bar);
        FloatingActionButton myfab = findViewById(R.id.fab);

        //click event en el  FAB
        myfab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(BottomAppBar.this, "Ojito con lo que haces", Toast.LENGTH_SHORT).show();
            }
        });

        //click event en el Hamburguer menuset NavigationOnClickListener
        /*bottomAppBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(BottomAppBar.this, "Menu clicked", Toast.LENGTH_SHORT).show();
                //sheetBehavior = BottomSheetBehavior.from(sheet);
            }
        });*/

        /*bottomAppBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.ajustes:
                        Toast.makeText(BottomAppBar.this, "Config", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_settings:
                        Toast.makeText(BottomAppBar.this, "Cosas", Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        });*/
    }


}