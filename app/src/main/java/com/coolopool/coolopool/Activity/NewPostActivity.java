package com.coolopool.coolopool.Activity;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.coolopool.coolopool.Helper.OnSwipeTouchListener;
import com.coolopool.coolopool.R;

public class NewPostActivity extends AppCompatActivity {

    LinearLayout swipeUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_post);
        setUpTransparentNavBar();
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

    private void setUpTransparentNavBar(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
    }
}
