package com.coolopool.coolopool.Activity;

import android.app.ActivityOptions;
import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.coolopool.coolopool.Adapter.MainStatePageAdapter;
import com.coolopool.coolopool.Application.MyApplication;
import com.coolopool.coolopool.Helper.DialogBuilder;
import com.coolopool.coolopool.R;

public class HomeActivity extends AppCompatActivity {


    ViewPager viewPager;
    FloatingActionButton fab;

    ImageButton mSearchButton;
    ImageButton mHomeButton;

    ImageButton hotelButton;
    ImageButton restaurantsButton;

    RadioButton topRadioButton;
    RadioButton bottomRadioButton;

    ImageButton userButton;

    MainStatePageAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //setUpTransparentNavBar();
        fab = findViewById(R.id.fab);


        viewPager = findViewById(R.id.viewPager);
        hotelButton = findViewById(R.id.hotelbtn);
        restaurantsButton = findViewById(R.id.foodbtn);
        userButton = findViewById(R.id.userbtn);

        // for search box

        mSearchButton = findViewById(R.id.searchButton);



        mSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DialogBuilder dialogBuilder = new DialogBuilder(HomeActivity.this, R.layout.home_activity_search_dialog_layout);
                dialogBuilder.build();

                setUpDialogForSearch(dialogBuilder);


            }
        });

        // to set icon on create

        mHomeButton = findViewById(R.id.homeBtn);
        updateSelectedIcon(viewPager.getCurrentItem());
        mHomeButton.setImageResource(R.drawable.ic_house_selected);
        viewPager.setCurrentItem(0);

        adapter = new MainStatePageAdapter(getSupportFragmentManager());

        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

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

        userButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent userIntent = new Intent(HomeActivity.this, UserActivity.class);
                startActivity(userIntent);
            }
        });


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });
    }

    private void setUpTransparentNavBar(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_INSET_DECOR);
        }
    }

    private void setUpDialogForSearch(DialogBuilder db){
        final Dialog dialog = db.getDialog();
        topRadioButton = (RadioButton)dialog.findViewById(R.id.search_dialog_top_radioBar);
        bottomRadioButton = (RadioButton)dialog.findViewById(R.id.search_dialog_bottom_radioBar);

        ((ImageView)dialog.findViewById(R.id.search_dialog_back_button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        topRadioButton.setChecked(true);

        topRadioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

            }
        });

        topRadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                topRadioButton.setChecked(true);
                bottomRadioButton.setChecked(false);
            }
        });

        bottomRadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomRadioButton.setChecked(true);
                topRadioButton.setChecked(false);
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
                startActivity(new Intent(HomeActivity.this, NewPicPostActivity.class));
            }
        });
        (dB.getDialog().findViewById(R.id.new_post_blog)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Todo: create another activity for user to create their trip of only pictures
                startActivity(new Intent(HomeActivity.this, NewBlogPostActivity.class));

            }
        });

        /*(dB.getDialog().findViewById(R.id.new_post_trip)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Normal way of creating post using trip details
                startActivity(new Intent(HomeActivity.this,NewPostActivity.class));
            }
        });*/
    }

    private void updateSelectedIcon(int i){

        //100: disabling selected state of all fragment

        switch (i){
            case 0:
                mHomeButton.setImageResource(R.drawable.ic_house);
                break;
            case 1:
                hotelButton.setImageResource(R.drawable.ic_hotel);
                break;
            case 2:
                restaurantsButton.setImageResource(R.drawable.ic_food);
                break;
            case 100:
                mHomeButton.setImageResource(R.drawable.ic_house);
                hotelButton.setImageResource(R.drawable.ic_hotel);
                restaurantsButton.setImageResource(R.drawable.ic_food);
            default:
                break;
        }

    }

    private void updateUi(int i){

        fab.setOnClickListener(null);
        final Fragment currentFragment = adapter.getItem(viewPager.getCurrentItem());

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
            case 1:
                hotelButton.setImageResource(R.drawable.ic_hotel_selected);
                fab.setImageResource(R.drawable.ic_search_white);
                fab.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(HomeActivity.this, HotelActivity.class);

                        intent.putExtra("LOCATION", ((EditText)currentFragment.getView().findViewById(R.id.hotel_fragment_location)).getText().toString().trim());

                        intent.putExtra("CHECKIN", ((TextView)currentFragment.getView().findViewById(R.id.checkIn_value_textView)).getText().toString());
                        intent.putExtra("CHECKIN_DAYOFWEEK", ((TextView)currentFragment.getView().findViewById(R.id.checkIn_value_day_of_week_textView)).getText().toString());
                        intent.putExtra("CHECKIN_MONTH_YEAR", ((TextView)currentFragment.getView().findViewById(R.id.checkIn_value_year_month_textView)).getText().toString().substring(0,3));


                        intent.putExtra("CHECKOUT", ((TextView)currentFragment.getView().findViewById(R.id.checkOut_value_textView)).getText().toString());
                        intent.putExtra("CHECKOUT_DAYOFWEEK", ((TextView)currentFragment.getView().findViewById(R.id.checkOut_value_day_of_week_textView)).getText().toString());
                        intent.putExtra("CHECKOUT_MONTH_YEAR", ((TextView)currentFragment.getView().findViewById(R.id.checkOut_value_year_month_textView)).getText().toString().substring(0,3));

                        intent.putExtra("GUESTS", ((EditText)currentFragment.getView().findViewById(R.id.guests_value_textView)).getText().toString().trim());

                        intent.putExtra("ROOMS", ((EditText)currentFragment.getView().findViewById(R.id.rooms_value_textView)).getText().toString().trim());


                        Pair<View, String> pair_location = Pair.create(currentFragment.getView().findViewById(R.id.hotel_fragment_location), "LOCATION");

                        Pair<View, String> pair_guests = Pair.create(currentFragment.getView().findViewById(R.id.guests_value_textView), "GUESTS");

                        Pair<View, String> pair_rooms = Pair.create(currentFragment.getView().findViewById(R.id.rooms_value_textView), "ROOMS");

                        Pair<View, String> pair_checkIn_day = Pair.create(currentFragment.getView().findViewById(R.id.checkIn_value_year_month_textView), "CHECKIN_DAY_YEAR");

                        Pair<View, String> pair_checkOut_day = Pair.create(currentFragment.getView().findViewById(R.id.checkOut_value_year_month_textView), "CHECKOUT_DAY_YEAR");

                        ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(HomeActivity.this, pair_location, pair_guests, pair_rooms, pair_checkIn_day, pair_checkOut_day);

                        startActivity(intent, activityOptions.toBundle());
                    }
                });
                break;
            case 2:
                restaurantsButton.setImageResource(R.drawable.ic_food_selected);
                fab.setImageResource(R.drawable.ic_search_white);
                fab.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(HomeActivity.this, FoodActivity.class);
                        intent.putExtra("FOOD_LOCATION", ((EditText)currentFragment.getView().findViewById(R.id.food_fragment_city_area_editText)).getText().toString().trim());

                        Pair<View, String> pair_food_location = Pair.create(currentFragment.getView().findViewById(R.id.food_fragment_city_area_editText), "FOOD_LOCATION");

                        ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(HomeActivity.this, pair_food_location);
                        startActivity(intent, activityOptions.toBundle());
                    }
                });
                break;

            default:
                return;

        }
    }
}
