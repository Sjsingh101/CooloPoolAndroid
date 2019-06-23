package com.coolopool.coolopool.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.coolopool.coolopool.Class.Restaurant;
import com.coolopool.coolopool.R;

import java.util.ArrayList;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder> {

    ArrayList<Restaurant> restaurants;

    @NonNull
    @Override
    public RestaurantViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
         View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.restaurant_list_item, viewGroup, false);
        return new RestaurantViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantViewHolder restaurantViewHolder, int i) {
        Restaurant currentRestaurant = restaurants.get(i);
    }

    @Override
    public int getItemCount() {
        return restaurants.size();
    }

    public class RestaurantViewHolder extends RecyclerView.ViewHolder{

        ImageView mThumbnail;
        TextView mName;
        TextView mCuisineType;
        TextView mVeg;
        TextView mNonVeg;
        TextView mCost;
        TextView mOpeningTime;
        TextView mClosingTme;
        ImageView mGoButton;

        public RestaurantViewHolder(@NonNull View itemView) {
            super(itemView);
            mThumbnail = (ImageView)itemView.findViewById(R.id.restaurants_list_item_picture_imageView);
            mName = (TextView)itemView.findViewById(R.id.restaurants_list_item_name_textView);
            mCuisineType = (TextView)itemView.findViewById(R.id.restaurants_list_item_type_of_food_textView);
            mVeg = (TextView)itemView.findViewById(R.id.restaurants_list_item_veg_textView);
            mNonVeg = (TextView)itemView.findViewById(R.id.restaurants_list_item_non_veg_textView);
            mCost = (TextView)itemView.findViewById(R.id.restaurants_list_item_cost_textView);
            mOpeningTime = (TextView)itemView.findViewById(R.id.restaurants_list_item_opening_time_textView);
            mClosingTme = (TextView)itemView.findViewById(R.id.restaurants_list_item_closing_time_textView);
            mGoButton = (ImageView)itemView.findViewById(R.id.restaurants_list_item_go_imageView);
        }
    }
}
