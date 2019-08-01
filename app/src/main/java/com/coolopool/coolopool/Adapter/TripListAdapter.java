package com.coolopool.coolopool.Adapter;


import android.app.Activity;
import android.content.Context;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.coolopool.coolopool.Class.Triplist;
import com.coolopool.coolopool.R;

import java.util.ArrayList;
import java.util.List;

public class TripListAdapter extends RecyclerView.Adapter<TripListAdapter.TripViewHolder> {

    private ArrayList<Triplist> TripList;
    Context context;

    public TripListAdapter(ArrayList<Triplist> TripList, Context context){
        this.TripList = TripList;
        this.context = context;
    }

    @NonNull
    @Override
    public TripViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.trip_list_layout, viewGroup,false);
        return new TripViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TripViewHolder tripViewHolder, int i) {
    Triplist Trip = TripList.get(i);

    tripViewHolder.mTripPhoto.setImageResource(Trip.getmTripPic());
    tripViewHolder.mTripPlaceName.setText(Trip.getmTripPlace());
    tripViewHolder.mNoOfTripDays.setText(Trip.getmNoOfTripDays() + " days");
    }

    @Override
    public int getItemCount() {
        return TripList.size();
    }

    public class TripViewHolder extends RecyclerView.ViewHolder{

        ImageButton mTripPhoto;
        TextView mTripPlaceName, mNoOfTripDays;

        public TripViewHolder(@NonNull View itemView) {
            super(itemView);
            mTripPhoto = itemView.findViewById(R.id.tripPic);
            mTripPlaceName = itemView.findViewById(R.id.trip_place);
            mNoOfTripDays = itemView.findViewById(R.id.no_of_trip_days);
        }
    }
}