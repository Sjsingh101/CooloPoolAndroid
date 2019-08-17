package com.coolopool.coolopool.Adapter;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
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
    int imageSize = 0; //0 for SMALL & 1 for BIG

    public NestedImageAdapter(ArrayList<Uri> mList, Context mContext) {
        this.mList = mList;
        this.mContext = mContext;
    }

    public NestedImageAdapter(ArrayList<Uri> mList, Context mContext, int imageSize) {
        this.mList = mList;
        this.mContext = mContext;
        this.imageSize = imageSize;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if(imageSize == 0){
            return new ImageViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.small_image_view_list_item, viewGroup, false));
        }

        return new ImageViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.large_image_view_list_item, viewGroup, false));

    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder imageViewHolder, int i) {
        Picasso.get().load(mList.get(i)).fit().centerCrop().into(imageViewHolder.imageView);
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
