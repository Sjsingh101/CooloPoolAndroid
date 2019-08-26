package com.coolopool.coolopool.Adapter;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.coolopool.coolopool.Activity.PostActivity;
import com.coolopool.coolopool.Class.Post;
import com.coolopool.coolopool.R;
import com.squareup.picasso.Picasso;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackListener;
import com.yuyakaido.android.cardstackview.CardStackView;
import com.yuyakaido.android.cardstackview.Direction;
import com.yuyakaido.android.cardstackview.StackFrom;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

    ArrayList<Post> posts;
    Context mContext;

    public PostAdapter(ArrayList<Post> postArrayList, Context context){
        posts = postArrayList;
        this.mContext = context;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.root_layout_post,viewGroup,false);
        PostViewHolder postViewHolder= new PostViewHolder(view);
        return postViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final PostViewHolder viewHolder, int i) {

        Post current_post = posts.get(i);

        viewHolder.title.setText(current_post.getTitle());
        viewHolder.userName.setText(current_post.getUserInfo());
        viewHolder.setUpNestedStackView(mContext, current_post);

        viewHolder.v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewHolder.openCurrentPost(mContext);
            }
        });



        /*
        viewHolder.v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mContext != null){
                    Intent postIntent = new Intent(mContext, PostActivity.class);
                    Pair<View, String> image = Pair.create((View)viewHolder.postimage, "POST_IMAGE");
                    ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation((Activity) mContext, image);

                    mContext.startActivity(postIntent, activityOptions.toBundle());
                }

            }
        });*/

        Picasso.get().load(R.drawable.photo2).fit().centerCrop().into(viewHolder.profilePic);


    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public static class PostViewHolder extends RecyclerView.ViewHolder{

        TextView title;
        TextView userName;
        ImageView profilePic;
        CardStackView stackView;
        View v;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            v = itemView;
            title = itemView.findViewById(R.id.title);
            userName = itemView.findViewById(R.id.userName);
            stackView = itemView.findViewById(R.id.card_stack_view);
            profilePic = itemView.findViewById(R.id.profileImage);
        }

        public void openCurrentPost(Context mContext){
            Intent postIntent = new Intent(mContext, PostActivity.class);
            mContext.startActivity(postIntent);
        }

        public void setUpNestedStackView(final Context context, final Post post){
            CardStackListener listener = new CardStackListener() {
                @Override
                public void onCardDragging(Direction direction, float ratio) {

                }

                @Override
                public void onCardSwiped(Direction direction) {

                }

                @Override
                public void onCardRewound() {

                }

                @Override
                public void onCardCanceled() {

                }

                @Override
                public void onCardAppeared(View view, int position) {

                }

                @Override
                public void onCardDisappeared(View view, int position) {
                    if(position+1 == stackView.getAdapter().getItemCount()){
                       stackView.setAdapter(post.getAdapter());
                       stackView.getAdapter().notifyDataSetChanged();
                    }

                }
            };

            final CardStackLayoutManager manager = new CardStackLayoutManager(context, listener);

            stackView.setLayoutManager(manager);
            manager.setStackFrom(StackFrom.Right);
            manager.setVisibleCount(4);
            manager.setTranslationInterval(30f);
            manager.setScaleInterval(0.85f);

            stackView.setAdapter(post.getAdapter());
            stackView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    openCurrentPost(context);
                }
            });


        }
    }
}
