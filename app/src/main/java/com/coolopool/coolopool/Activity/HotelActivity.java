package com.coolopool.coolopool.Activity;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.appyvet.materialrangebar.RangeBar;
import com.coolopool.coolopool.Adapter.HotelAdapter;
import com.coolopool.coolopool.Class.Hotel;
import com.coolopool.coolopool.Helper.DialogBuilder;
import com.coolopool.coolopool.R;

import java.util.ArrayList;

public class HotelActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;

    HotelAdapter mHotelAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel);

        ArrayList<Hotel> hotels = new ArrayList<>();

        hotels.add(new Hotel("ABCD", "4000", "Mall road", "url", (float)3.5));
        hotels.add(new Hotel("Residence", "5500", "Mall road", "url", (float)5));
        hotels.add(new Hotel("OYO 337", "6079", "GT road", "url", (float)4.5));
        hotels.add(new Hotel("OYO 334", "4040", "Nh32 road", "url", (float)2.5));
        hotels.add(new Hotel("OYO 654", "4400", "Nh21 road", "url", (float)4.5));
        hotels.add(new Hotel("OYO 323", "8000", "Mall road", "url", (float)5));
        hotels.add(new Hotel("OYO 110", "4060", "Mall road", "url", (float)4.5));
        hotels.add(new Hotel("OYO 111", "9000", "Mall road", "url", (float)1.5));
        hotels.add(new Hotel("OYO 999", "4560", "Mall road", "url", (float)4.5));
        hotels.add(new Hotel("OYO 600", "4900", "Mall road", "url", (float)5));
        hotels.add(new Hotel("OYO 33", "4670", "Mall road", "url", (float)4.25));


        mRecyclerView = (RecyclerView)findViewById(R.id.hotel_activity_recyclerView);
        mHotelAdapter = new HotelAdapter(hotels);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mHotelAdapter);

        getContentsFromIntent();

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
                setupDialogButtonsClickEvent(dB);

                (dB.getDialog().getWindow()).setWindowAnimations(R.style.DialogAnimation);



            }
        });


    }

    private void setupDialogButtonsClickEvent(final DialogBuilder dB){

        final Dialog dialog = dB.getDialog();

        final int[] defaults = {R.id.hotel_activity_filter_0_to_1_km_selector,
                R.id.hotel_activity_filter_12_to_6_am_selector,
                R.id.hotel_activity_filter_ac_selector};


        ((ImageButton)dialog.findViewById(R.id.hotel_activity_filter_cross)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dB.destroy();
            }
        });

        ((LinearLayout)dialog.findViewById(R.id.hotel_activity_filter_0_to_1_km)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!(defaults[0] == R.id.hotel_activity_filter_0_to_1_km_selector)){
                    ((ImageView)dialog.findViewById(defaults[0])).setImageResource(R.drawable.filter_bottom_not_selected_circle);
                    defaults[0] = R.id.hotel_activity_filter_0_to_1_km_selector;
                    ((ImageView)dialog.findViewById(defaults[0])).setImageResource(R.drawable.filter_bottom_selected_circle);
                }
            }
        });
        ((LinearLayout)dialog.findViewById(R.id.hotel_activity_filter_1_to_3_km)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!(defaults[0] == R.id.hotel_activity_filter_1_to_3_km_selector)){
                    ((ImageView)dialog.findViewById(defaults[0])).setImageResource(R.drawable.filter_bottom_not_selected_circle);
                    defaults[0] = R.id.hotel_activity_filter_1_to_3_km_selector;
                    ((ImageView)dialog.findViewById(defaults[0])).setImageResource(R.drawable.filter_bottom_selected_circle);
                }
            }
        });
        ((LinearLayout)dialog.findViewById(R.id.hotel_activity_filter_3_km)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!(defaults[0] == R.id.hotel_activity_filter_3_km_selector)){
                    ((ImageView)dialog.findViewById(defaults[0])).setImageResource(R.drawable.filter_bottom_not_selected_circle);
                    defaults[0] = R.id.hotel_activity_filter_3_km_selector;
                    ((ImageView)dialog.findViewById(defaults[0])).setImageResource(R.drawable.filter_bottom_selected_circle);
                }
            }
        });
        ((LinearLayout)dialog.findViewById(R.id.hotel_activity_filter_12_to_6_am)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!(defaults[1] == R.id.hotel_activity_filter_12_to_6_am_selector)){
                    ((ImageView)dialog.findViewById(defaults[1])).setImageResource(R.drawable.filter_bottom_not_selected_circle);
                    defaults[1] = R.id.hotel_activity_filter_12_to_6_am_selector;
                    ((ImageView)dialog.findViewById(defaults[1])).setImageResource(R.drawable.filter_bottom_selected_circle);
                }
            }
        });
        ((LinearLayout)dialog.findViewById(R.id.hotel_activity_filter_6_to_12_morning)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!(defaults[1] == R.id.hotel_activity_filter_6_to_12_morning_selector)){
                    ((ImageView)dialog.findViewById(defaults[1])).setImageResource(R.drawable.filter_bottom_not_selected_circle);
                    defaults[1] = R.id.hotel_activity_filter_6_to_12_morning_selector;
                    ((ImageView)dialog.findViewById(defaults[1])).setImageResource(R.drawable.filter_bottom_selected_circle);
                }
            }
        });
        ((LinearLayout)dialog.findViewById(R.id.hotel_activity_filter_12_to_6_afternoon_evening)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!(defaults[1] == R.id.hotel_activity_filter_12_to_6_afternoon_evening_selector)){
                    ((ImageView)dialog.findViewById(defaults[1])).setImageResource(R.drawable.filter_bottom_not_selected_circle);
                    defaults[1] = R.id.hotel_activity_filter_12_to_6_afternoon_evening_selector;
                    ((ImageView)dialog.findViewById(defaults[1])).setImageResource(R.drawable.filter_bottom_selected_circle);
                }
            }
        });
        ((LinearLayout)dialog.findViewById(R.id.hotel_activity_filter_6_to_12_night)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!(defaults[1] == R.id.hotel_activity_filter_6_to_12_night_selector)){
                    ((ImageView)dialog.findViewById(defaults[1])).setImageResource(R.drawable.filter_bottom_not_selected_circle);
                    defaults[1] = R.id.hotel_activity_filter_6_to_12_night_selector;
                    ((ImageView)dialog.findViewById(defaults[1])).setImageResource(R.drawable.filter_bottom_selected_circle);
                }
            }
        });
        ((LinearLayout)dialog.findViewById(R.id.hotel_activity_filter_ac)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!(defaults[2] == R.id.hotel_activity_filter_ac_selector)){
                    ((ImageView)dialog.findViewById(defaults[2])).setImageResource(R.drawable.filter_bottom_not_selected_circle);
                    defaults[2] = R.id.hotel_activity_filter_ac_selector;
                    ((ImageView)dialog.findViewById(defaults[2])).setImageResource(R.drawable.filter_bottom_selected_circle);
                }
            }
        });
        ((LinearLayout)dialog.findViewById(R.id.hotel_activity_filter_non_ac)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!(defaults[2] == R.id.hotel_activity_filter_non_ac_selector)){
                    ((ImageView)dialog.findViewById(defaults[2])).setImageResource(R.drawable.filter_bottom_not_selected_circle);
                    defaults[2] = R.id.hotel_activity_filter_non_ac_selector;
                    ((ImageView)dialog.findViewById(defaults[2])).setImageResource(R.drawable.filter_bottom_selected_circle);
                }
            }
        });

        ((Button)dialog.findViewById(R.id.hotel_activity_filter_apply_button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int LI = ((RangeBar)dialog.findViewById(R.id.hotel_activity_filter_price_range_slider)).getLeftIndex();
                int RI = ((RangeBar)dialog.findViewById(R.id.hotel_activity_filter_price_range_slider)).getRightIndex();

                toast("Left: "+(LI*50+500)+"Right: "+(RI*50+500));
            }
        });
    }

    private void getContentsFromIntent(){
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
    }

    private void toast(String s){
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}
