package com.coolopool.coolopool.Activity;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.appyvet.materialrangebar.RangeBar;
import com.coolopool.coolopool.Helper.DialogBuilder;
import com.coolopool.coolopool.R;

public class FoodActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        getContentsFromIntent();

        final ImageButton filter = (ImageButton)findViewById(R.id.food_activity_filter);
        ImageButton backButton = (ImageButton)findViewById(R.id.food_activity_back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final DialogBuilder dB = new DialogBuilder(FoodActivity.this, R.layout.food_filter_layout);
                dB.build();
                setupDialogButtonsClickEvent(dB);

                (dB.getDialog().getWindow()).setWindowAnimations(R.style.DialogAnimation);
            }
        });
    }

    private void setupDialogButtonsClickEvent(final DialogBuilder dB){

        final Dialog dialog = dB.getDialog();

        final int[] defaults = {R.id.food_activity_filter_0_to_1_km_selector,
                R.id.food_activity_filter_italian_selector,};


        ((ImageButton)dialog.findViewById(R.id.food_activity_filter_cross)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dB.destroy();
            }
        });

        ((LinearLayout)dialog.findViewById(R.id.food_activity_filter_0_to_1_km)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!(defaults[0] == R.id.food_activity_filter_0_to_1_km_selector)){
                    ((ImageView)dialog.findViewById(defaults[0])).setImageResource(R.drawable.filter_bottom_not_selected_circle);
                    defaults[0] = R.id.food_activity_filter_0_to_1_km_selector;
                    ((ImageView)dialog.findViewById(defaults[0])).setImageResource(R.drawable.filter_bottom_selected_circle);
                }
            }
        });
        ((LinearLayout)dialog.findViewById(R.id.food_activity_filter_1_to_3_km)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!(defaults[0] == R.id.food_activity_filter_1_to_3_km_selector)){
                    ((ImageView)dialog.findViewById(defaults[0])).setImageResource(R.drawable.filter_bottom_not_selected_circle);
                    defaults[0] = R.id.food_activity_filter_1_to_3_km_selector;
                    ((ImageView)dialog.findViewById(defaults[0])).setImageResource(R.drawable.filter_bottom_selected_circle);
                }
            }
        });
        ((LinearLayout)dialog.findViewById(R.id.food_activity_filter_3_km)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!(defaults[0] == R.id.food_activity_filter_3_km_selector)){
                    ((ImageView)dialog.findViewById(defaults[0])).setImageResource(R.drawable.filter_bottom_not_selected_circle);
                    defaults[0] = R.id.food_activity_filter_3_km_selector;
                    ((ImageView)dialog.findViewById(defaults[0])).setImageResource(R.drawable.filter_bottom_selected_circle);
                }
            }
        });
        ((LinearLayout)dialog.findViewById(R.id.food_activity_filter_italian)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!(defaults[1] == R.id.food_activity_filter_italian_selector)){
                    ((ImageView)dialog.findViewById(defaults[1])).setImageResource(R.drawable.filter_bottom_not_selected_circle);
                    defaults[1] = R.id.food_activity_filter_italian_selector;
                    ((ImageView)dialog.findViewById(defaults[1])).setImageResource(R.drawable.filter_bottom_selected_circle);
                }
            }
        });
        ((LinearLayout)dialog.findViewById(R.id.food_activity_filter_south_indian)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!(defaults[1] == R.id.food_activity_filter_south_indian_selector)){
                    ((ImageView)dialog.findViewById(defaults[1])).setImageResource(R.drawable.filter_bottom_not_selected_circle);
                    defaults[1] = R.id.food_activity_filter_south_indian_selector;
                    ((ImageView)dialog.findViewById(defaults[1])).setImageResource(R.drawable.filter_bottom_selected_circle);
                }
            }
        });
        ((LinearLayout)dialog.findViewById(R.id.food_activity_filter_american)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!(defaults[1] == R.id.food_activity_filter_american_selector)){
                    ((ImageView)dialog.findViewById(defaults[1])).setImageResource(R.drawable.filter_bottom_not_selected_circle);
                    defaults[1] = R.id.food_activity_filter_american_selector;
                    ((ImageView)dialog.findViewById(defaults[1])).setImageResource(R.drawable.filter_bottom_selected_circle);
                }
            }
        });
        ((LinearLayout)dialog.findViewById(R.id.food_activity_filter_sushi)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!(defaults[1] == R.id.food_activity_filter_sushi_selector)){
                    ((ImageView)dialog.findViewById(defaults[1])).setImageResource(R.drawable.filter_bottom_not_selected_circle);
                    defaults[1] = R.id.food_activity_filter_sushi_selector;
                    ((ImageView)dialog.findViewById(defaults[1])).setImageResource(R.drawable.filter_bottom_selected_circle);
                }
            }
        });


        ((Button)dialog.findViewById(R.id.food_activity_filter_apply_button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int LI = ((RangeBar)dialog.findViewById(R.id.food_activity_filter_price_range_slider)).getLeftIndex();
                int RI = ((RangeBar)dialog.findViewById(R.id.food_activity_filter_price_range_slider)).getRightIndex();

                toast("Left: "+(LI*50+500)+"Right: "+(RI*50+500));
            }
        });
    }

    private void getContentsFromIntent(){
        Intent intent = getIntent();

        String food_location = intent.getStringExtra("FOOD_LOCATION");

        TextView food_location_textView = (TextView)findViewById(R.id.food_activity_location_textView);

        food_location_textView.setText(food_location);

    }

    private void toast(String s){
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}
