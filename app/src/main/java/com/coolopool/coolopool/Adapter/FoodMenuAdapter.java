package com.coolopool.coolopool.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class FoodMenuAdapter extends RecyclerView.Adapter<FoodMenuAdapter.FoodMenuViewHolder> {



    @NonNull
    @Override
    public FoodMenuViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull FoodMenuViewHolder foodMenuViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class FoodMenuViewHolder extends RecyclerView.ViewHolder{

        public FoodMenuViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
