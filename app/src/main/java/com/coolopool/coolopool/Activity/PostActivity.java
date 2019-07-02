package com.coolopool.coolopool.Activity;

import android.os.Build;
import android.provider.ContactsContract;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ScrollView;

import com.coolopool.coolopool.Adapter.ImageAdapter;
import com.coolopool.coolopool.R;

import java.util.ArrayList;

public class PostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        setUpTransparentNavBar();



        final ImageView back = (ImageView)findViewById(R.id.post_activity_back_button);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        ArrayList<Integer> id = new ArrayList<>();

        id.add(R.drawable.pic1);
        id.add(R.drawable.pic2);
        id.add(R.drawable.pic3);
        id.add(R.drawable.pic1);
        id.add(R.drawable.pic2);
        id.add(R.drawable.pic3);
        id.add(R.drawable.pic1);
        id.add(R.drawable.pic2);



        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.post_activity_image_recyclerView);
        ImageAdapter adapter = new ImageAdapter(id, this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setHasFixedSize(false);

        recyclerView.setAdapter(adapter);



    }

    private void setUpTransparentNavBar(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
    }


}
