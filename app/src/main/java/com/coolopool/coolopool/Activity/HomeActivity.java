package com.coolopool.coolopool.Activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Build;

import com.coolopool.coolopool.Views.CustomViewPager;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.coolopool.coolopool.Adapter.MainStatePageAdapter;
import com.coolopool.coolopool.Helper.DialogBuilder;
import com.coolopool.coolopool.R;
import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity {


    CustomViewPager viewPager;
    FloatingActionButton fab;

    RelativeLayout mGiftContainer;
    ImageButton mGiftButton;

    RelativeLayout mSearchContainer;
    ImageButton mSearchButton;
    EditText mSearchBar;
    ImageButton mHomeButton;
    ImageButton mCartButton;

    ImageButton hotelButton;
    ImageButton restaurantsButton;

    RadioButton topRadioButton;
    RadioButton bottomRadioButton;

    ImageButton userButton;

    MainStatePageAdapter adapter;

    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseInit();

        fab = findViewById(R.id.fab);


        viewPager = findViewById(R.id.viewPager);
        hotelButton = findViewById(R.id.hotelbtn);
        restaurantsButton = findViewById(R.id.foodbtn);
        userButton = findViewById(R.id.userbtn);

        // for search box

        /*
        mCartButton = findViewById(R.id.cart_imageButton);


        mCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, CartActivity.class);
                startActivity(intent);
            }
        });*/

        mGiftContainer = findViewById(R.id.gifts_container);
        mGiftButton = findViewById(R.id.giftButton);

        mGiftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, GiftsActivity.class));
            }
        });
        mGiftContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, GiftsActivity.class));
            }
        });


        mSearchContainer = findViewById(R.id.search_container);
        mSearchButton = findViewById(R.id.searchButton);
        mSearchBar = findViewById(R.id.searchBox);
        mSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mSearchBar.getVisibility() == View.INVISIBLE){
                    mSearchBar.setVisibility(View.VISIBLE);
                    mSearchButton.setBackground(getResources().getDrawable(R.drawable.ic_cross));
                    Animation animation = AnimationUtils.loadAnimation(HomeActivity.this, R.anim.search_entry_animation);
                    mSearchBar.startAnimation(animation);
                }else{
                    mSearchButton.setBackground(getResources().getDrawable(R.drawable.ic_search_white));
                    Animation animation = AnimationUtils.loadAnimation(HomeActivity.this, R.anim.search_exit_animation);
                    mSearchBar.startAnimation(animation);
                    mSearchBar.setVisibility(View.INVISIBLE);
                }

            }
        });
        mSearchContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mSearchBar.getVisibility() == View.INVISIBLE){
                    mSearchBar.setVisibility(View.VISIBLE);
                    mSearchButton.setBackground(getResources().getDrawable(R.drawable.ic_cross));
                    Animation animation = AnimationUtils.loadAnimation(HomeActivity.this, R.anim.search_entry_animation);
                    mSearchBar.startAnimation(animation);
                }else{
                    mSearchButton.setBackground(getResources().getDrawable(R.drawable.ic_search_white));
                    Animation animation = AnimationUtils.loadAnimation(HomeActivity.this, R.anim.search_exit_animation);
                    mSearchBar.startAnimation(animation);
                    mSearchBar.setVisibility(View.INVISIBLE);
                }

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
                updateSelectedIcon(viewPager.getCurrentItem());
                userButton.setImageResource(R.drawable.ic_user_selected);
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

    @Override
    protected void onStart() {
        super.onStart();
        if(mAuth.getCurrentUser() == null){
            startActivity(new Intent(HomeActivity.this, SplashActivity.class));
            finish();
        }

    }

    private void firebaseInit(){
        mAuth = FirebaseAuth.getInstance();
        Toast.makeText(this, "main: "+mAuth.getUid(), Toast.LENGTH_SHORT).show();
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


        /*(dB.getDialog().findViewById(R.id.new_post_pic)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Todo: create another activity for user to create their trip of only pictures
                startActivity(new Intent(HomeActivity.this, NewPicPostActivity.class));
            }
        });*/
        (dB.getDialog().findViewById(R.id.new_post_blog)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Todo: create another activity for user to create their trip of only pictures
                startActivity(new Intent(HomeActivity.this, NewPostActivity.class));

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
            case 3:
                userButton.setImageResource(R.drawable.ic_user);
                break;
            case 100:
                mHomeButton.setImageResource(R.drawable.ic_house);
                hotelButton.setImageResource(R.drawable.ic_hotel);
                restaurantsButton.setImageResource(R.drawable.ic_food);
                break;
            default:
                break;
        }

    }


    private void updateUi(int i){

        fab.setOnClickListener(null);
        final Fragment currentFragment = adapter.getItem(viewPager.getCurrentItem());

        if(mSearchButton.getVisibility() == View.INVISIBLE && i != 2){
            mSearchButton.setVisibility(View.VISIBLE);
            mSearchButton.setBackground(getResources().getDrawable(R.drawable.ic_search_white));
            mSearchContainer.setVisibility(View.VISIBLE);
        }

        switch (i){
            case 0:
                mHomeButton.setImageResource(R.drawable.ic_house_selected);
                //fab.setImageResource(R.drawable.ic_add);
                fab.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        showDialog();
                    }
                });
                break;
            case 1:
                hotelButton.setImageResource(R.drawable.ic_hotel_selected);
                //fab.setImageResource(R.drawable.ic_search_white);
                fab.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                       showDialog();
                    }
                });
                break;
            case 2:
                if(mSearchBar.getVisibility() == View.VISIBLE){
                    mSearchBar.setVisibility(View.INVISIBLE);
                }
                mSearchButton.setVisibility(View.INVISIBLE);
                mSearchContainer.setVisibility(View.INVISIBLE);
                restaurantsButton.setImageResource(R.drawable.ic_food_selected);
                fab.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        showDialog();
                    }
                });
                break;


            default:
                return;

        }
    }
}
