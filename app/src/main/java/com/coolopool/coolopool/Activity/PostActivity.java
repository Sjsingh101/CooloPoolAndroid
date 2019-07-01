package com.coolopool.coolopool.Activity;

import android.os.Build;
import android.provider.ContactsContract;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ScrollView;

import com.coolopool.coolopool.R;

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

        final ScrollView scrollView = (ScrollView)findViewById(R.id.post_activity_scrollView);
        final NestedScrollView root = (NestedScrollView)findViewById(R.id.nested);

        scrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {
                int[] loc = new int[2];
                back.getLocationOnScreen(loc);
                Log.d("~~~~~~~~~~~~~~~",":----------- "+loc[0]);


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
