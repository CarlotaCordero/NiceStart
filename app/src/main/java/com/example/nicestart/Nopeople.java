package com.example.nicestart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

public class Nopeople extends AppCompatActivity {

    private SwipeRefreshLayout swipe;
    private WebView miWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nopeople);

        swipe = findViewById(R.id.refresco);
        swipe.setOnRefreshListener(mOnRefreshListener);

        miWeb = findViewById(R.id.web);
        registerForContextMenu(miWeb);
        WebSettings webSettings = miWeb.getSettings();
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);
        miWeb.loadUrl("https://thispersondoesnotexist.com/");
    }

    protected SwipeRefreshLayout.OnRefreshListener
        mOnRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            Toast toast = Toast.makeText(Nopeople.this, " No existo :( ", Toast.LENGTH_LONG);
            toast.show();
            miWeb.reload();
            swipe.setRefreshing(false);
        }
    };
}