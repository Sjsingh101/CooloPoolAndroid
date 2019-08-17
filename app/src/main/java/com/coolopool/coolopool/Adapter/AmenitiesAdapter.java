package com.coolopool.coolopool.Adapter;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.coolopool.coolopool.Class.Amenities;
import com.coolopool.coolopool.R;

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
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.amenities_list_item, viewGroup, false);
        return new AmenitiesViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AmenitiesViewHolder amenitiesViewHolder, int i) {
        Amenities currentAmenities = amenities.get(i);

        amenitiesViewHolder.ic_imageView.setImageResource(currentAmenities.getmIcon());
        amenitiesViewHolder.string.setText(currentAmenities.getmString());
    }

    @Override
    public int getItemCount() {
        return amenities.size();
    }

    public class AmenitiesViewHolder extends RecyclerView.ViewHolder{

        ImageView ic_imageView;
        TextView string;

        public AmenitiesViewHolder(@NonNull View itemView) {
            super(itemView);
            ic_imageView = (ImageView)itemView.findViewById(R.id.amenities_list_item_ic_imageView);
            string = (TextView)itemView.findViewById(R.id.amenities_list_item_string_textView);

        }
    }


}
