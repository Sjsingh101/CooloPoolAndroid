package com.coolopool.coolopool.Activity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.coolopool.coolopool.Adapter.MainStatePageAdapter;
import com.coolopool.coolopool.Application.MyApplication;
import com.coolopool.coolopool.Helper.DialogBuilder;
import com.coolopool.coolopool.R;

public class HomeActivity extends AppCompatActivity {

    static String TAG = "HomeActivit: ~~~~~~~~~~~~~~~~~~~~~~~~~";

    ViewPager viewPager;
    FloatingActionButton fab;

    ImageButton mSearchButton;
    ImageButton mHomeButton;

    ImageButton transportButton;
    ImageButton hotelButton;
    ImageButton restaurantsButton;

    MainStatePageAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fab = findViewById(R.id.fab);


        viewPager = findViewById(R.id.viewPager);
        hotelButton = findViewById(R.id.hotelbtn);
        restaurantsButton = findViewById(R.id.foodbtn);

        // for search box

        mSearchButton = findViewById(R.id.searchButton);
        final EditText mSearchBox = findViewById(R.id.searchbar);
        mSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSearchBox.setVisibility(View.VISIBLE);
            }
        });

        mHomeButton = findViewById(R.id.homeBtn);
        updateSelectedIcon(viewPager.getCurrentItem());
        mHomeButton.setImageResource(R.drawable.ic_house_selected);
        viewPager.setCurrentItem(0);

        adapter = new MainStatePageAdapter(getSupportFragmentManager());

        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
                Log.d(TAG, ""+i);
            }

            @Override
            public void onPageSelected(int i) {
                updateSelectedIcon(100);

                updateUi(i);

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        mHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateSelectedIcon(viewPager.getCurrentItem());
                mHomeButton.setImageResource(R.drawable.ic_house_selected);
                viewPager.setCurrentItem(0);
            }
        });

        /*transportButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               *//* updateSelectedIcon(viewPager.getCurrentItem());
                transportButton.setImageResource(R.drawable.ic_taxi_selected);
                viewPager.setCurrentItem(1);*//*
            }
        });*/

        hotelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateSelectedIcon(viewPager.getCurrentItem());
                hotelButton.setImageResource(R.drawable.ic_hotel_selected);
                viewPager.setCurrentItem(1);
            }
        });

        restaurantsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateSelectedIcon(viewPager.getCurrentItem());
                restaurantsButton.setImageResource(R.drawable.ic_food_selected);
                viewPager.setCurrentItem(2);
            }
        });


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });
    }

    private void showDialog(){
        final DialogBuilder dB = new DialogBuilder(this, R.layout.post_method_chooser);
        dB.build();


        (dB.getDialog().findViewById(R.id.dialog_back_button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dB.destroy();
            }
        });


        (dB.getDialog().findViewById(R.id.new_post_pic)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Todo: create another activity for user to create their trip of only pictures

            }
        });
        (dB.getDialog().findViewById(R.id.new_post_blog)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Todo: create another activity for user to create their trip of only pictures

            }
        });

        (dB.getDialog().findViewById(R.id.new_post_trip)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Normal way of creating post using trip details
                startActivity(new Intent(HomeActivity.this,NewPostActivity.class));
            }
        });
    }

    private void updateSelectedIcon(int i){

        //100: disabling selected state of all fragment

        switch (i){
            case 0:
                mHomeButton.setImageResource(R.drawable.ic_house);
                break;
            /*case :
                transportButton.setImageResource(R.drawable.ic_taxi);
                break;*/
            case 1:
                hotelButton.setImageResource(R.drawable.ic_hotel);
                break;
            case 2:
                restaurantsButton.setImageResource(R.drawable.ic_food);
                break;
            case 100:
                mHomeButton.setImageResource(R.drawable.ic_house);
                /*transportButton.setImageResource(R.drawable.ic_taxi);*/
                hotelButton.setImageResource(R.drawable.ic_hotel);
                restaurantsButton.setImageResource(R.drawable.ic_food);
            default:
                break;
        }

    }

    private void updateUi(int i){

        switch (i){
            case 0:
                mHomeButton.setImageResource(R.drawable.ic_house_selected);
                fab.setImageResource(R.drawable.ic_add);
                fab.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        showDialog();
                    }
                });
                break;
           /* case 1:
                transportButton.setImageResource(R.drawable.ic_taxi_selected);
                fab.setImageResource(R.drawable.ic_search_white);
                Log.d(TAG, "CabFragment Enabled");
                break;*/
            case 1:
                hotelButton.setImageResource(R.drawable.ic_hotel_selected);
                fab.setImageResource(R.drawable.ic_search_white);
                fab.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(HomeActivity.this, HotelActivity.class);

                        Fragment currentFragment = adapter.getItem(viewPager.getCurrentItem());

                        Pair<View, String> pair_location = Pair.create(currentFragment.getView().findViewById(R.id.hotel_fragment_location), "LOCATION");

                        Pair<View, String> pair_guests = Pair.create(currentFragment.getView().findViewById(R.id.guests_value_textView), "GUESTS");

                        Pair<View, String> pair_rooms = Pair.create(currentFragment.getView().findViewById(R.id.rooms_value_textView), "ROOMS");

                        Pair<View, String> pair_checkIn_day = Pair.create(currentFragment.getView().findViewById(R.id.checkIn_value_year_month_textView), "CHECKIN_DAY_YEAR");

                        Pair<View, String> pair_checkOut_day = Pair.create(currentFragment.getView().findViewById(R.id.checkOut_value_year_month_textView), "CHECKOUT_DAY_YEAR");

                        ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(HomeActivity.this, pair_location, pair_guests, pair_rooms, pair_checkIn_day, pair_checkOut_day);

                        startActivity(intent, activityOptions.toBundle());
                    }
                });
                Log.d(TAG, "HotelFragment Enabled");
                break;
            case 2:
                restaurantsButton.setImageResource(R.drawable.ic_food_selected);
                fab.setImageResource(R.drawable.ic_search_white);
                Log.d(TAG, "ResturantFragment Enabled");
                break;

            default:
                return;

        }
    }
}
