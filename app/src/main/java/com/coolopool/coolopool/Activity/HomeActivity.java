package com.coolopool.coolopool.Activity;

import android.support.design.bottomappbar.BottomAppBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;

import com.coolopool.coolopool.Adapter.PostAdapter;
import com.coolopool.coolopool.R;

public class HomeActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    int[] images ={R.drawable.pic1,R.drawable.pic2,R.drawable.pic3,R.drawable.pic1,R.drawable.pic2,R.drawable.pic3};
    String[] titles ={"Afgfgf","A","A","A","A","A"};
    String[] descriptions ={"A","A","A","A","A","A"};
    RecyclerView.LayoutManager layoutManager;
    PostAdapter postAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        layoutManager = new GridLayoutManager(this,2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        postAdapter = new PostAdapter(images,titles,descriptions);
        recyclerView.setAdapter(postAdapter);
    }

}
