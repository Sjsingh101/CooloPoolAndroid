package com.coolopool.coolopool.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

public class AmenitiesAdapter extends RecyclerView.Adapter<AmenitiesAdapter.AmenitiesViewHolder> {


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

        public AmenitiesViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }


}
