package com.coolopool.coolopool.Activity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

import com.coolopool.coolopool.Adapter.FollowersListAdapter;
import com.coolopool.coolopool.Class.followList;
import com.coolopool.coolopool.R;

import java.util.ArrayList;

public class FollowersActivity extends AppCompatActivity {

    RecyclerView mFollowerList;
    EditText mfollowersSearchBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_followers);

        mfollowersSearchBtn = findViewById(R.id.followersSearch);
        mfollowersSearchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mfollowersSearchBtn.setFocusableInTouchMode(true);
            }
        });

        ArrayList<followList> followersLists = new ArrayList<>();

        followersLists.add(new followList(R.drawable.userfacepic,"Leo","Rahul Singh"));
        followersLists.add(new followList(R.drawable.userfacepic,"Leo","Rahul Singh"));
        followersLists.add(new followList(R.drawable.userfacepic,"Leo","Rahul Singh"));
        followersLists.add(new followList(R.drawable.userfacepic,"Leo","Rahul Singh"));
        followersLists.add(new followList(R.drawable.userfacepic,"Leo","Rahul Singh"));
        followersLists.add(new followList(R.drawable.userfacepic,"Leo","Rahul Singh"));
        followersLists.add(new followList(R.drawable.userfacepic,"Leo","Rahul Singh"));
        followersLists.add(new followList(R.drawable.userfacepic,"Leo","Rahul Singh"));
        followersLists.add(new followList(R.drawable.userfacepic,"Leo","Rahul Singh"));
        followersLists.add(new followList(R.drawable.userfacepic,"Leo","Rahul Singh"));
        followersLists.add(new followList(R.drawable.userfacepic,"Leo","Rahul Singh"));
        followersLists.add(new followList(R.drawable.userfacepic,"Leo","Rahul Singh"));

        mFollowerList = findViewById(R.id.Followers_RecyclerView);
        mFollowerList.setLayoutManager(new LinearLayoutManager(this));
        mFollowerList.setAdapter(new FollowersListAdapter(followersLists,this));
    }
}
