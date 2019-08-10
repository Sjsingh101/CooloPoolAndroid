package com.coolopool.coolopool.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.coolopool.coolopool.Class.RoomType;
import com.coolopool.coolopool.R;

import java.util.ArrayList;

public class RoomTypAdapter extends RecyclerView.Adapter<RoomTypAdapter.RoomTypeViewHolder> {

    ArrayList<RoomType> roomTypes;
    Context mContext;

    public RoomTypAdapter(ArrayList<RoomType> roomTypes, Context mContext) {
        this.roomTypes = roomTypes;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public RoomTypeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.room_type_list_item, viewGroup, false);
        return new RoomTypeViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RoomTypeViewHolder roomTypeViewHolder, int i) {
        RoomType current = roomTypes.get(i);
        roomTypeViewHolder.mType.setText(current.getmType());
        roomTypeViewHolder.mAvalibility.setText(current.getmAvailability());
    }

    @Override
    public int getItemCount() {
        return roomTypes.size();
    }

    public class RoomTypeViewHolder extends RecyclerView.ViewHolder{

        TextView mType;
        TextView mAvalibility;

        public RoomTypeViewHolder(@NonNull View itemView) {
            super(itemView);
            mType = (TextView)itemView.findViewById(R.id.room_type_list_item_type_textView);
            mAvalibility = (TextView)itemView.findViewById(R.id.room_type_list_item_quantity_textView);
        }
    }
}
