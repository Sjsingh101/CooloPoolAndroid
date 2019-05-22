package com.coolopool.coolopool.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.coolopool.coolopool.Helper.OnSwipeTouchListener;
import com.coolopool.coolopool.R;

public class NewPostActivity extends AppCompatActivity {

    LinearLayout swipeUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_post);
        swipeUp = findViewById(R.id.swipe_up);
        swipeUp.setOnTouchListener(new OnSwipeTouchListener(NewPostActivity.this){


            @Override
            public void onSwipeUp() {
                super.onSwipeUp();
                startActivity(new Intent(NewPostActivity.this,PostDraftActivity.class));
            }

            @Override
            public void onSwipeDown() {
                super.onSwipeDown();
                // your swipe down here.
            }
        });
    }
}
