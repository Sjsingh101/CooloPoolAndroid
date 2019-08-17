package com.coolopool.coolopool.Adapter;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.coolopool.coolopool.Class.FoodMenuItem;
import com.coolopool.coolopool.R;

import java.util.ArrayList;

public class FoodMenuAdapter extends RecyclerView.Adapter<FoodMenuAdapter.FoodMenuViewHolder> {

    ArrayList<FoodMenuItem> menuItems;
    Context mContext;

    public FoodMenuAdapter(ArrayList<FoodMenuItem> menuItems, Context mContext) {
        this.menuItems = menuItems;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public FoodMenuViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.food_menu_list_item, viewGroup, false);
        return new FoodMenuViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodMenuViewHolder foodMenuViewHolder, int i) {
        FoodMenuItem currentItem = menuItems.get(i);

        foodMenuViewHolder.textView.setText(currentItem.getmItem());

    }

    @Override
    public int getItemCount() {
        return menuItems.size();
    }

    public class FoodMenuViewHolder extends RecyclerView.ViewHolder{

        TextView textView;

        public FoodMenuViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.food_menu_list_item_type_textView);
        }
    }
}
