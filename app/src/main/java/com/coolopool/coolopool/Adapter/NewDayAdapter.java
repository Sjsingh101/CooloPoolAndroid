package com.coolopool.coolopool.Adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.coolopool.coolopool.Class.NewDay;
import com.coolopool.coolopool.R;

import java.util.ArrayList;

import com.coolopool.coolopool.Interface.ItemClickListener;

public class NewDayAdapter extends RecyclerView.Adapter<NewDayAdapter.NewDayViewHolder> {

    ArrayList<NewDay> newDays;
    Context context;
    int focussedPosition = 0;
    View previouslySelectedView;
    int flag = 0; //0: for creating & 1: for displaying


    public NewDayAdapter(ArrayList<NewDay> newDays, Context context) {
        this.newDays = newDays;
        this.context = context;
    }

    public NewDayAdapter(ArrayList<NewDay> newDays, Context context, int flag) {
        this.newDays = newDays;
        this.context = context;
        this.flag = flag;
    }

    @NonNull
    @Override
    public NewDayAdapter.NewDayViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new NewDayViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.create_new_day_list_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull NewDayAdapter.NewDayViewHolder newDayViewHolder, int i) {
        newDayViewHolder.daysCounter.setText(newDays.get(i).getmDays());
        newDayViewHolder.setUpNestedRecyclerView(context, newDays.get(i));
        newDayViewHolder.description.setText(newDays.get(i).getmDescription().trim());

        if(flag == 1){
            newDayViewHolder.description.setEnabled(false);
        }else{
            newDayViewHolder.setItemClickListener(new ItemClickListener() {
                @Override
                public void onClick(View view, int position) {
                    if(previouslySelectedView != null){
                        previouslySelectedView.setBackground(context.getResources().getDrawable(R.drawable.background));
                    }
                    view.setBackgroundColor(context.getResources().getColor(R.color.white));
                    previouslySelectedView = view;
                    focussedPosition = position;
                }
            });
        }


    }

    @Override
    public int getItemCount() {
        return newDays.size();
    }

    public NewDay get(int position){
        return newDays.get(position);
    }

    public void addDays(NewDay day){
        newDays.add(day);
    }

    public void addPhoto(Uri uri){
        Toast.makeText(context, newDays.get(focussedPosition).getmDays(), Toast.LENGTH_SHORT).show();
        newDays.get(focussedPosition).addmImageUri(uri);
    }

    public class NewDayViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ItemClickListener itemClickListener;

        TextView daysCounter;
        TextView description;
        RecyclerView imageRecyclerView;

        public NewDayViewHolder(@NonNull View itemView) {
            super(itemView);
            daysCounter = (TextView)itemView.findViewById(R.id.create_new_day_list_item_day_counter_textView);
            description = (TextView)itemView.findViewById(R.id.create_new_day_list_item_desc_editText);
            imageRecyclerView = (RecyclerView)itemView.findViewById(R.id.create_new_day_list_image_recyclerView);

            itemView.setOnClickListener(this);
        }

        public void setItemClickListener(ItemClickListener itemClickListener) {
            this.itemClickListener = itemClickListener;
        }

        public void setUpNestedRecyclerView(Context context, NewDay day){
            imageRecyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
            imageRecyclerView.setAdapter(day.getmAdapter());
        }

        @Override
        public void onClick(View view) {
            itemClickListener.onClick(view, getAdapterPosition());
        }
    }
}
