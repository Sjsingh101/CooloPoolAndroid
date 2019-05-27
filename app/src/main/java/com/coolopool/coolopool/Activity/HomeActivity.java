package com.coolopool.coolopool.Activity;

import android.app.Dialog;
import android.content.Intent;
import android.support.design.bottomappbar.BottomAppBar;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

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


        recyclerView = findViewById(R.id.recycler_view);
        layoutManager = new GridLayoutManager(this,2);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(layoutManager);

        postAdapter = new PostAdapter(images,titles,descriptions);
        recyclerView.setAdapter(postAdapter);
        addPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,NewPostActivity.class));
            }
        });


    }

    private void showDialoge(){
        Dialog dialog = new Dialog(this);

    }

}
