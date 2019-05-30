package com.coolopool.coolopool.Activity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.design.bottomappbar.BottomAppBar;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.coolopool.coolopool.Adapter.PostAdapter;
import com.coolopool.coolopool.R;

public class HomeActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    int[] images ={R.drawable.pic1,R.drawable.pic2,R.drawable.pic3,R.drawable.pic1,R.drawable.pic2,R.drawable.pic3};
    String[] titles ={"Afgfgf","A","A","A","A","A"};
    String[] descriptions ={"A","A","A","A","A","A"};
    RecyclerView.LayoutManager layoutManager;
    PostAdapter postAdapter;
    FloatingActionButton addPost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addPost = findViewById(R.id.fab);

        // for search box

        ImageButton mSearchButton = findViewById(R.id.searchButton);
        final EditText mSearchBox = findViewById(R.id.searchbar);
        mSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSearchBox.setVisibility(View.VISIBLE);
            }
        });

        // for hotel
        ImageButton mHotelButton = findViewById(R.id.hotelbtn);
        mHotelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Log_test", "Hotel Button has clicked");
                Intent intent = new Intent(HomeActivity.this, HotelActivity.class);
                startActivity(intent);
            }
        });


        recyclerView = findViewById(R.id.recycler_view);
        layoutManager = new GridLayoutManager(this,2);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(layoutManager);

        postAdapter = new PostAdapter(images,titles,descriptions);
        recyclerView.setAdapter(postAdapter);
        addPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });




    }

    private void showDialog(){
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.post_method_chooser);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        ((TextView)dialog.findViewById(R.id.new_post_pic)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Todo: create another activity for user to create their trip of only pictures

            }
        });
        ((TextView)dialog.findViewById(R.id.new_post_blog)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Todo: create another activity for user to create their trip in form of blog(pic plus caption)

            }
        });
        ((TextView)dialog.findViewById(R.id.new_post_trip)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Normal way of creating post using trip details
                startActivity(new Intent(HomeActivity.this,NewPostActivity.class));
            }
        });

        dialog.setCancelable(true);

        dialog.show();

    }

}
