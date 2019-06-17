package com.coolopool.coolopool.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.coolopool.coolopool.Class.Amenities;

import java.util.ArrayList;

public class AmenitiesAdapter extends RecyclerView.Adapter<AmenitiesAdapter.AmenitiesViewHolder> {

    ArrayList<Amenities> amenities;
    Context mContext;

    public AmenitiesAdapter(ArrayList<Amenities> amenities, Context context) {
        this.amenities = amenities;
        mContext = context;
    }

    @NonNull
    @Override
    public AmenitiesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull AmenitiesViewHolder amenitiesViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class AmenitiesViewHolder extends RecyclerView.ViewHolder{

        ImageView ic_imageView;
        TextView string;

        public AmenitiesViewHolder(@NonNull View itemView) {
            super(itemView);

        }
    }


}
