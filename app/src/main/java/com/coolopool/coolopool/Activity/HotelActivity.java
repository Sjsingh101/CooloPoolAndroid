package com.coolopool.coolopool.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;

import com.coolopool.coolopool.Helper.DialogBuilder;
import com.coolopool.coolopool.R;

public class HotelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel);

        final ImageButton filter = (ImageButton)findViewById(R.id.hotel_activity_filter);

        filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogBuilder dB = new DialogBuilder(HotelActivity.this, R.layout.hotel_filter_layout);
                dB.build();

                (dB.getDialog().getWindow()).setWindowAnimations(R.style.DialogAnimation);


            }
        });


    }
}
