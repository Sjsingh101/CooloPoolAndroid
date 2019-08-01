package com.coolopool.coolopool.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.coolopool.coolopool.R;

public class NewPostMenuAdapter extends RecyclerView.Adapter<NewPostMenuAdapter.MenuViewHolder> {

    String[] title = {"New Day", "Photos", "Location", "Tag Friend"};
    int[] icon = {R.drawable.calendar, R.drawable.photos, R.drawable.ic_location, R.drawable.tag_frnd};

    public NewPostMenuAdapter() {

    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.new_post_menu_list_item, viewGroup, false);
        return new MenuViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder menuViewHolder, int i) {
        menuViewHolder.icon.setImageResource(icon[i]);
        menuViewHolder.title.setText(title[i]);
    }

    @Override
    public int getItemCount() {
        return title.length;
    }

    public class MenuViewHolder extends RecyclerView.ViewHolder{

        TextView title;
        ImageView icon;

        public MenuViewHolder(@NonNull View itemView) {
            super(itemView);
            title = (TextView)itemView.findViewById(R.id.menu_item_title_textView);
            icon = (ImageView)itemView.findViewById(R.id.menu_item_icon_imageView);



        }
    }
}
