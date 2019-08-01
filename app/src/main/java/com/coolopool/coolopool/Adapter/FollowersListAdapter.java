package com.coolopool.coolopool.Adapter;

import android.content.Context;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.coolopool.coolopool.Class.followList;
import com.coolopool.coolopool.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class FollowersListAdapter extends RecyclerView.Adapter<FollowersListAdapter.FollowersViewHolder> {

    private ArrayList<followList> FollowList;
    Context context;

    public FollowersListAdapter(ArrayList<followList> FollowList, Context context) {
        this.FollowList = FollowList;
        this.context = context;
    }

    @NonNull
    @Override
    public FollowersViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.followerslist, viewGroup, false);
        return new FollowersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FollowersViewHolder followersViewHolder, int i) {
        followList FollowersList = FollowList.get(i);

        followersViewHolder.mUserProfilePic.setImageResource(FollowersList.getmUserProfilePic());
        followersViewHolder.mUserName.setText(FollowersList.getmUserName());
        followersViewHolder.mUserFullName.setText(FollowersList.getmFullName());
    }

    @Override
    public int getItemCount() {
        return FollowList.size();
    }

    public class FollowersViewHolder extends RecyclerView.ViewHolder{

        CircleImageView mUserProfilePic;
        TextView mUserName, mUserFullName;

        public FollowersViewHolder(@NonNull View itemView) {
            super(itemView);
            mUserProfilePic = itemView.findViewById(R.id.userProfilePic);
            mUserName = itemView.findViewById(R.id.Username);
            mUserFullName = itemView.findViewById(R.id.Name);
        }
    }
}
