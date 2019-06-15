package com.coolopool.coolopool.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.media.RatingCompat;
import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.coolopool.coolopool.Activity.DetailHotelActivity;
import com.coolopool.coolopool.Activity.HotelActivity;
import com.coolopool.coolopool.Application.MyApplication;
import com.coolopool.coolopool.Class.Hotel;
import com.coolopool.coolopool.R;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class HotelAdapter extends RecyclerView.Adapter<HotelAdapter.HotelViewHolder> {

    ArrayList<Hotel> hotelList;
    Context context;

    public HotelAdapter(ArrayList<Hotel> hotelAList, Context context) {
        this.hotelList = hotelAList;
        this.context = context;
    }

    @NonNull
    @Override
    public HotelViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hotel_list_item, viewGroup, false);
        HotelViewHolder hotelViewHolder = new HotelViewHolder(view);
        return hotelViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HotelViewHolder hotelViewHolder, int i) {
        Hotel currentHotel = hotelList.get(i);

        hotelViewHolder.name.setText(currentHotel.getmName());
        hotelViewHolder.cost.setText(currentHotel.getmCost());
        hotelViewHolder.location.setText(currentHotel.getmLocation());

        hotelViewHolder.rating.setRating((float)currentHotel.getmRating());

        hotelViewHolder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, DetailHotelActivity.class));
            }
        });

        Picasso.get().load(currentHotel.getmThumbnailUrl()).error(R.drawable.pic1).into(hotelViewHolder.thumbnail);

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

        public HotelViewHolder(@NonNull View itemView) {
            super(itemView);
            name = (TextView)itemView.findViewById(R.id.hotel_list_item_hotel_name_textView);
            cost = (TextView)itemView.findViewById(R.id.hotel_list_item_cost_textView);
            location = (TextView)itemView.findViewById(R.id.hotel_list_item_location_textView);
            rating = (RatingBar)itemView.findViewById(R.id.hotel_list_item_ratingBar);
            thumbnail = (ImageView)itemView.findViewById(R.id.hotel_list_item_imageView);
        }
    }
}
