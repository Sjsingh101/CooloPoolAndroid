package com.coolopool.coolopool.Adapter;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.coolopool.coolopool.R;

import java.util.ArrayList;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {

    ArrayList<Integer> mImageId;
    Context mContext;

    public ImageAdapter(ArrayList<Integer> imageId, Context mContext) {
        this.mImageId = imageId;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.day_post_item, viewGroup, false);
        return new ImageViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder imageViewHolder, int i) {
        imageViewHolder.mImage.setImageResource(mImageId.get(i));
    }

    @Override
    public int getItemCount() {
        return mImageId.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder{

        ImageView mImage;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            mImage = (ImageView)itemView.findViewById(R.id.day_post_item_imageView);
        }
    }
}
