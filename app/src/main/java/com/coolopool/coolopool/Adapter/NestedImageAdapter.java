package com.coolopool.coolopool.Adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.coolopool.coolopool.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class NestedImageAdapter extends RecyclerView.Adapter<NestedImageAdapter.ImageViewHolder> {



    ArrayList<Uri> mList;
    Context mContext;

    public NestedImageAdapter(ArrayList<Uri> mList, Context mContext) {
        this.mList = mList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ImageViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.image_view_list_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder imageViewHolder, int i) {
        Picasso.get().load(mList.get(i)).fit().centerCrop().placeholder(R.drawable.pic1).into(imageViewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void addUri(Uri uri){
        mList.add(uri);
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = (ImageView)itemView.findViewById(R.id.image_view_list_item);

        }
    }
}
