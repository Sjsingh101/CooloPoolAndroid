package com.coolopool.coolopool.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.coolopool.coolopool.Activity.PostActivity;
import com.coolopool.coolopool.R;
import com.squareup.picasso.Picasso;

public class StackCardAdapter extends RecyclerView.Adapter<StackCardAdapter.StackCardViewHolder> {

    String[] imageUrl;
    String[] description;
    Context mContext;



    public StackCardAdapter(String[] imageUrl, String[] description, Context context) {
        this.imageUrl = imageUrl;
        this.description = description;
        mContext = context;
    }

    @NonNull
    @Override
    public StackCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_post, parent, false);
        return new StackCardViewHolder((v));
    }

    @Override
    public void onBindViewHolder(@NonNull StackCardViewHolder holder, int position) {
        if(imageUrl[position] != null) {
            Picasso.get().load(imageUrl[position]).into(holder.imageView);
        }
        holder.description.setText(description[position]);
        holder.v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent postIntent = new Intent(mContext, PostActivity.class);
                mContext.startActivity(postIntent);
            }
        });
    }

    public String getDes(int position){
        return description[position];
    }

    @Override
    public int getItemCount() {
        return imageUrl.length;
    }

    public class StackCardViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView description;
        View v;

        public StackCardViewHolder(@NonNull View itemView) {
            super(itemView);
            v = itemView;
            imageView = itemView.findViewById(R.id.post_image);
            description = itemView.findViewById(R.id.desc);

        }
    }
}
