package com.coolopool.coolopool.Adapter;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.coolopool.coolopool.Activity.DetailHotelActivity;
import com.coolopool.coolopool.Class.Hotel;
import com.coolopool.coolopool.R;

import java.util.ArrayList;

public class HotelAdapter extends RecyclerView.Adapter<HotelAdapter.HotelViewHolder> {

    private ArrayList<Hotel> hotelList;
    Context context;

    public HotelAdapter(ArrayList<Hotel> hotelAList, Context context) {
        this.hotelList = hotelAList;
        this.context = context;
    }

    @NonNull
    @Override
    public HotelViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hotel_list_item, viewGroup, false);
        return new HotelViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HotelViewHolder hotelViewHolder, int i) {
        final Hotel currentHotel = hotelList.get(i);

        hotelViewHolder.name.setText(currentHotel.getmName());
        hotelViewHolder.cost.setText(currentHotel.getmCost());
        hotelViewHolder.location.setText(currentHotel.getmLocation());

        hotelViewHolder.rating.setRating((float)currentHotel.getmRating());

        hotelViewHolder.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailHotelActivity.class);
                intent.putExtra("ImageUri",currentHotel.getmThumbnailUrl());
                context.startActivity(intent);
            }
        });

        Glide
                .with(context)
                .load(currentHotel.getmThumbnailUrl())
                .into(hotelViewHolder.thumbnail);

    }

    @Override
    public int getItemCount() {
        return hotelList.size();
    }

    public static class HotelViewHolder extends RecyclerView.ViewHolder{

        TextView name;
        TextView cost;
        TextView location;
        RatingBar rating;
        ImageView thumbnail;

        View rootView;

        public HotelViewHolder(@NonNull View itemView) {
            super(itemView);
            rootView = itemView;
            name = (TextView)itemView.findViewById(R.id.hotel_list_item_hotel_name_textView);
            cost = (TextView)itemView.findViewById(R.id.hotel_list_item_cost_textView);
            location = (TextView)itemView.findViewById(R.id.hotel_list_item_location_textView);
            rating = (RatingBar)itemView.findViewById(R.id.hotel_list_item_ratingBar);
            thumbnail = (ImageView)itemView.findViewById(R.id.hotel_list_item_imageView);
        }
    }
}
