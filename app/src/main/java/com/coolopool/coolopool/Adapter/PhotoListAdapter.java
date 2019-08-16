package com.coolopool.coolopool.Adapter;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.coolopool.coolopool.Class.Photolist;
import com.coolopool.coolopool.R;

import java.util.ArrayList;

public class PhotoListAdapter extends  RecyclerView.Adapter<PhotoListAdapter.PhotoViewHolder>{

    private ArrayList<Photolist> PhotoList;
    Context context;

    public PhotoListAdapter(ArrayList<Photolist> PhotoList, Context context){
        this.PhotoList = PhotoList;
        this.context = context;
    }

    @NonNull
    @Override
    public PhotoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.photo_list_layout, viewGroup, false);
        return new PhotoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoViewHolder photoViewHolder, int i) {
        Photolist mPhoto = PhotoList.get(i);

        photoViewHolder.mPhoto.setImageResource(mPhoto.getmPhoto());
        photoViewHolder.mPhotoName.setText(mPhoto.getmPhotoName());
        photoViewHolder.mPhotoPlace.setText(mPhoto.getmPhotoPlace());
    }

    @Override
    public int getItemCount() {
        return PhotoList.size();
    }

    public class PhotoViewHolder extends RecyclerView.ViewHolder{

       ImageButton mPhoto;
       TextView mPhotoName, mPhotoPlace;

       public PhotoViewHolder(@NonNull View itemView) {
           super(itemView);
           mPhoto = itemView.findViewById(R.id.photo);
           mPhotoName = itemView.findViewById(R.id.photo_name);
           mPhotoPlace = itemView.findViewById(R.id.photo_place);
       }
   }
}
