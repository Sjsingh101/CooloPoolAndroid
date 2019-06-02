package com.coolopool.coolopool.Activity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.design.bottomappbar.BottomAppBar;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.coolopool.coolopool.Adapter.MainStatePageAdapter;
import com.coolopool.coolopool.Adapter.PostAdapter;
import com.coolopool.coolopool.Fragments.HotelFragment;
import com.coolopool.coolopool.Helper.DialogBuilder;
import com.coolopool.coolopool.R;

public class HomeActivity extends AppCompatActivity {

    static String TAG = "HomeActivity";

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


        viewPager = (ViewPager)findViewById(R.id.viewPager);
        transportButton = (ImageButton)findViewById(R.id.taxiBtn);
        hotelButton = (ImageButton)findViewById(R.id.hotelbtn);
        restaurantsButton = (ImageButton)findViewById(R.id.foodbtn);

        mSearchButton = (ImageButton)findViewById(R.id.searchButton);
        final EditText mSearchBox = (EditText)findViewById(R.id.searchbar);
        mSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSearchBox.setVisibility(View.VISIBLE);
            }
        });

        mHomeButton = (ImageButton)findViewById(R.id.homeButton);


        adapter = new MainStatePageAdapter(getSupportFragmentManager());

        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                Log.d(TAG, ""+i);
                updateUi(i);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        mHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(0);
            }
        });

        transportButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(1);
            }
        });

        hotelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(2);
            }
        });

        restaurantsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(3);
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
        DialogBuilder dB = new DialogBuilder(this, R.layout.post_method_chooser);
        dB.build();



        ((TextView)dB.getDialog().findViewById(R.id.new_post_pic)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Todo: create another activity for user to create their trip of only pictures

            }
        });
        ((TextView)dB.getDialog().findViewById(R.id.new_post_blog)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Todo: create another activity for user to create their trip of only pictures

            }
        });

        ((TextView)dB.getDialog().findViewById(R.id.new_post_trip)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Normal way of creating post using trip details
                startActivity(new Intent(HomeActivity.this,NewPostActivity.class));
            }
        });
        



    }

    private void updateUi(int i){

        switch (i){
            case 0:
                fab.setImageResource(R.drawable.ic_add);
                fab.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        showDialog();
                    }
                });
                break;
            case 1:
                fab.setImageResource(R.drawable.ic_search);
                Log.d(TAG, "CabFragment Enabled");
                break;
            case 2:
                fab.setImageResource(R.drawable.ic_search);
                Log.d(TAG, "HotelFragment Enabled");
                break;
            case 3:
                fab.setImageResource(R.drawable.ic_search);
                Log.d(TAG, "ResturantFragment Enabled");
                break;

            default:
                return;

        }
    }
}
