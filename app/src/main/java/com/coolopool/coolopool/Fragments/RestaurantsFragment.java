package com.coolopool.coolopool.Fragments;


import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.AppCompatImageView;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.coolopool.coolopool.Activity.FoodActivity;
import com.coolopool.coolopool.Activity.HomeActivity;
import com.coolopool.coolopool.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RestaurantsFragment extends Fragment {

    View v;


    public RestaurantsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v =  inflater.inflate(R.layout.fragment_resturants, container, false);

        AppCompatImageButton searchButton = (AppCompatImageButton)v.findViewById(R.id.restaurants_fragment_searchButton);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), FoodActivity.class);
                intent.putExtra("FOOD_LOCATION", ((EditText)v.findViewById(R.id.food_fragment_city_area_editText)).getText().toString().trim());

                Pair<View, String> pair_food_location = Pair.create(v.findViewById(R.id.food_fragment_city_area_editText), "FOOD_LOCATION");

                ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(getActivity(), pair_food_location);
                startActivity(intent, activityOptions.toBundle());
            }
        });



        return v;
    }

    public View getView() {
        return v;
    }


}
