package com.coolopool.coolopool.Activity;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.MotionEvent;
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
import android.widget.Toast;

import com.coolopool.coolopool.Adapter.NewDayAdapter;
import com.coolopool.coolopool.Adapter.NewPostMenuAdapter;
import com.coolopool.coolopool.Class.NewDay;
import com.coolopool.coolopool.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PostDraftActivity extends AppCompatActivity {

    public static final int SELECT_PICTURE = 100;


    DrawerLayout drawer;

    ArrayList<NewDay> days;
    NewDayAdapter adapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_draft);
        init();
        loadIntentData();
        setUpBackButton();
        setUpNavigationDrawer();
        setUpToolbar();
        setUpFabButton();




    }


    private void init(){
        drawer = findViewById(R.id.drawer_layout);
        days = new ArrayList<>();
        adapter = new NewDayAdapter(days, this);
        recyclerView = (RecyclerView)findViewById(R.id.post_draft_activity_content_holder_linearLayout);
        recyclerView.setLayoutManager(new LinearLayoutManager(PostDraftActivity.this));
        recyclerView.setHasFixedSize(false);

        recyclerView.setAdapter(adapter);
    }

    public void pickImage() {

        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), SELECT_PICTURE);

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == SELECT_PICTURE) {

                //Get ImageURi and load with help of picasso
                Uri selectedImageURI = data.getData();
                //Toast.makeText(PostDraftActivity.this, ""+adapter.getItemCount(), Toast.LENGTH_SHORT).show();

                adapter.addPhoto(selectedImageURI);

            }

        }
    }

    private void setUpNavigationDrawer(){
        ImageView menuToggle = (ImageView)findViewById(R.id.post_draft_activity_toolbar_menu_opener_imageView);

        menuToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawer.openDrawer(Gravity.RIGHT);
            }
        });

        ((ImageView)findViewById(R.id.menu_item_icon_new_day_imageView)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PostDraftActivity.this, "New day", Toast.LENGTH_SHORT).show();
                adapter.addDays(new NewDay("", PostDraftActivity.this));
                adapter.notifyDataSetChanged();
            }
        });

        ((ImageView)findViewById(R.id.menu_item_photos_icon_imageView)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PostDraftActivity.this, "Photos", Toast.LENGTH_SHORT).show();
                pickImage();
            }
        });




    }

    private void setUpFabButton(){
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void setUpToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
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

    @Override
    public void onBackPressed() {
        if(drawer.isDrawerOpen(Gravity.RIGHT)){
            drawer.closeDrawer(Gravity.RIGHT);
        }else{
            super.onBackPressed();
        }
    }
}
