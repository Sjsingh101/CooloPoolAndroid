package com.coolopool.coolopool.Activity;

import android.content.Intent;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.coolopool.coolopool.Adapter.NewPostMenuAdapter;
import com.coolopool.coolopool.R;

public class PostDraftActivity extends AppCompatActivity {


    DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_draft);
        setUpTransparentNavBar();
        loadIntentData();
        setUpBackButton();
        setUpNavigationDrawer();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);




        //ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        //drawer.addDrawerListener(toggle);
        //toggle.syncState();
        //navigationView.setNavigationItemSelectedListener(this);
    }

    private void setUpNavigationDrawer(){
        RecyclerView menu = (RecyclerView)findViewById(R.id.post_draft_activity_menu_recyclerView);
        menu.setLayoutManager(new LinearLayoutManager(PostDraftActivity.this));
        menu.setHasFixedSize(true);
        NewPostMenuAdapter adapter = new NewPostMenuAdapter();

        menu.setAdapter(adapter);

        ImageView menuToggel = (ImageView)findViewById(R.id.post_draft_activity_toolbar_menu_opener_imageView);

        menuToggel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawer.openDrawer(Gravity.RIGHT);
            }
        });

    }


    private void loadIntentData(){
        Intent intent = getIntent();

        ((TextView)findViewById(R.id.post_draft_activity_toolbar_title_textView)).setText(intent.getStringExtra("Title"));
        ((TextView)findViewById(R.id.post_draft_activity_toolbar_date_textView)).setText(intent.getStringExtra("Date"));

    }

    private void setUpBackButton(){
        ((ImageView)findViewById(R.id.post_draft_activity_toolbar_back_button_imageView)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }


    private void setUpTransparentNavBar(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
    }

    @Override
    public void onBackPressed() {
        if(drawer.isDrawerOpen(Gravity.RIGHT)){
            drawer.closeDrawer(Gravity.RIGHT);
        }else{
            super.onBackPressed();
        }
    }
}
