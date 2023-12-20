package com.example.nicestart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;
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

        // casting a la vista a la que aplicamos un menu contextual
        // y la registramos
        TextView mycontext = findViewById(R.id.textTap);
        registerForContextMenu(mycontext);
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

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_context, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        /*AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)
                item.getMenuInfo();*/
        if (item.getItemId() == R.id.item) {
            Toast toast = Toast.makeText(this, "going CONTEXT ITEM",
                    Toast.LENGTH_LONG);
            toast.show();
            return true;
        } else if (item.getItemId()== R.id.action_settings) {
            Toast toast2 = Toast.makeText(this,"going CONTEXT SETTINGS",
                    Toast.LENGTH_LONG );
            toast2.show();
            return true;
        } else {
            return super.onContextItemSelected(item);
        }
    }
}