package com.example.nicestart;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BottomBar extends AppCompatActivity {

    private MenuItem prevMenuItem;
    private SectionsPagerAdapter sectionsPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_bar);
        //Constructor de pages adapter
        sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        //Indexar el paginador
        ViewPager viewPager1 = findViewById(R.id.view_pager);
        viewPager1.setAdapter(sectionsPagerAdapter);
        //Indexar bottom navigation
        BottomNavigationView myBottomNavigation = findViewById(R.id.bottom_navigation);
        //Crear badges
        BottomNavigationMenuView bottomNavigationMenuView =
                (BottomNavigationMenuView) myBottomNavigation.getChildAt(0);
        View v = bottomNavigationMenuView.getChildAt(2);
        BottomNavigationItemView itemView = (BottomNavigationItemView) v;

        LayoutInflater.from(this)
                .inflate(R.layout.badge, itemView, true);

        myBottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if (item.getItemId() == R.id.mailMenu) {
                    item.setChecked(true);
                    Toast.makeText(BottomBar.this, "Mensajito.", Toast.LENGTH_SHORT).show();
                    removeBadge(myBottomNavigation,item.getItemId());
                    viewPager1.setCurrentItem(0);
                } else if (item.getItemId() == R.id.personaMenu) {
                    item.setChecked(true);
                    Toast.makeText(BottomBar.this, "Hallo!.", Toast.LENGTH_SHORT).show();
                    removeBadge(myBottomNavigation,item.getItemId());
                    viewPager1.setCurrentItem(1);
                } else if (item.getItemId() == R.id.ojoMenu) {
                    item.setChecked(true);
                    Toast.makeText(BottomBar.this, "Ojito.", Toast.LENGTH_SHORT).show();
                    removeBadge(myBottomNavigation,item.getItemId());
                    viewPager1.setCurrentItem(2);
                } else if (item.getItemId() == R.id.candadoMenu) {
                    item.setChecked(true);
                    Toast.makeText(BottomBar.this, "Te bloqueo.", Toast.LENGTH_SHORT).show();
                    removeBadge(myBottomNavigation,item.getItemId());
                    viewPager1.setCurrentItem(3);
                }
                return false;
            }
        });
        viewPager1.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (prevMenuItem != null) {
                    prevMenuItem.setChecked(false);
                } else {
                    myBottomNavigation.getMenu().getItem(0).setChecked(false);
                    myBottomNavigation.getMenu().getItem(position).setChecked(true);
                    //removeBadge(myBottomNavigation, myBottomNavigation.getMenu().getItem(position).getItemId());
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
    public static void removeBadge(BottomNavigationView bottomNavigationView, @IdRes int itemId) {
        BottomNavigationItemView itemView = bottomNavigationView.findViewById(itemId);
        if (itemView.getChildCount() == 3) {
            itemView.removeViewAt(2);
        }
    }
}
