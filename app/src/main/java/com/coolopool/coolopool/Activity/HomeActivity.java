package com.coolopool.coolopool.Activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
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

import com.coolopool.coolopool.Adapter.MainStatePageAdapter;
import com.coolopool.coolopool.Helper.DialogBuilder;
import com.coolopool.coolopool.R;

public class HomeActivity extends AppCompatActivity {


    ViewPager viewPager;
    FloatingActionButton fab;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        mSearchButton = findViewById(R.id.searchButton);
        mSearchBar = findViewById(R.id.searchBox);
        mSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mSearchBar.getVisibility() == View.GONE){
                    mSearchBar.setVisibility(View.VISIBLE);
                    mSearchButton.setBackground(getResources().getDrawable(R.drawable.ic_cross_black));
                    Animation animation = AnimationUtils.loadAnimation(HomeActivity.this, R.anim.search_entry_animation);
                    mSearchBar.startAnimation(animation);
                }else{
                    mSearchButton.setBackground(getResources().getDrawable(R.drawable.ic_search_black));
                    Animation animation = AnimationUtils.loadAnimation(HomeActivity.this, R.anim.search_exit_animation);
                    mSearchBar.startAnimation(animation);
                    mSearchBar.setVisibility(View.GONE);
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

    private void setUpTransparentNavBar(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_INSET_DECOR);
        }
    }

    private void setUpDialogForSearch(DialogBuilder db){
        final Dialog dialog = db.getDialog();


        ((ImageView)dialog.findViewById(R.id.search_dialog_back_button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
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
