package com.coolopool.coolopool.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.TextView;

import com.coolopool.coolopool.Helper.DialogBuilder;
import com.coolopool.coolopool.R;

public class HotelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel);

        Intent intent = getIntent();

        String location = intent.getStringExtra("LOCATION");
        String guests = intent.getStringExtra("GUESTS");
        String rooms = intent.getStringExtra("ROOMS");
        String checkInDate = intent.getStringExtra("CHECKIN_DAYOFWEEK").substring(0, 3)+ ", " + intent.getStringExtra("CHECKIN") + intent.getStringExtra("CHECKIN_MONTH_YEAR");
        String checkOutDate = intent.getStringExtra("CHECKOUT_DAYOFWEEK").substring(0, 3)+ ", " + intent.getStringExtra("CHECKOUT") + intent.getStringExtra("CHECKOUT_MONTH_YEAR");

        TextView location_textView = (TextView)findViewById(R.id.hotel_activity_location_textView);
        TextView checkIn_textView = (TextView)findViewById(R.id.hotel_activity_date_from_dayOfWeek_textView);
        TextView checkOut_textView = (TextView)findViewById(R.id.hotel_activity_date_to_dayOfWeek_textView);
        TextView guests_textView = (TextView)findViewById(R.id.hotel_activity_guests_value_textView);
        TextView rooms_textView = (TextView)findViewById(R.id.hotel_activity_rooms_value_textView);

        location_textView.setText(location);
        checkIn_textView.setText(checkInDate);
        checkOut_textView.setText(checkOutDate);
        guests_textView.setText(guests);
        rooms_textView.setText(rooms);



        final ImageButton filter = (ImageButton)findViewById(R.id.hotel_activity_filter);
        ImageButton backButton = (ImageButton)findViewById(R.id.hotel_activity_back_button);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final DialogBuilder dB = new DialogBuilder(HotelActivity.this, R.layout.hotel_filter_layout);
                dB.build();

                (dB.getDialog().getWindow()).setWindowAnimations(R.style.DialogAnimation);

                (dB.getDialog().findViewById(R.id.hotel_activity_filter_cross)).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                       dB.destroy();
                    }
                });


            }
        });


    }
}
