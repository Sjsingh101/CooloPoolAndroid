package com.coolopool.coolopool.Adapter;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.coolopool.coolopool.Activity.PostActivity;
import com.coolopool.coolopool.Application.MyApplication;
import com.coolopool.coolopool.R;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

    int[] images;
    String[] titles;
    String[] descriptions;
    Context mContext;

    public PostAdapter(int[] images, String[] titles, String[] descriptions, Context context){
        this.images = images;
        this.titles = titles;
        this.descriptions=descriptions;
        this.mContext = context;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_post,viewGroup,false);
        PostViewHolder postViewHolder= new PostViewHolder(view);
        return postViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final PostViewHolder viewHolder, int i) {

        int image_id = images[i];
        String title = titles[i];
        String description = descriptions[i];

        viewHolder.postimage.setImageResource(image_id);
        viewHolder.posttitle.setText(title);
        viewHolder.postdesc.setText(description);

        viewHolder.postimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mContext != null){
                    Intent postIntent = new Intent(mContext, PostActivity.class);
                    Pair<View, String> image = Pair.create((View)viewHolder.postimage, "POST_IMAGE");
                    ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation((Activity) mContext, image);

                    mContext.startActivity(postIntent, activityOptions.toBundle());
                }

            }
        });

        Picasso.get().load(R.drawable.photo2).fit().centerCrop().into(viewHolder.profilePic);


    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public static class PostViewHolder extends RecyclerView.ViewHolder{

        ImageView postimage;
        TextView posttitle,postdesc;
        CircleImageView profilePic;
        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            postimage = itemView.findViewById(R.id.post_image);
            posttitle = itemView.findViewById(R.id.title);
            postdesc = itemView.findViewById(R.id.desc);
            profilePic = itemView.findViewById(R.id.layout_post_profile_picture_imageView);
        }


    }
}
