package com.coolopool.coolopool.Fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.coolopool.coolopool.Activity.FollowersActivity;
import com.coolopool.coolopool.Activity.NewPicPostActivity;
import com.coolopool.coolopool.Activity.NewPostActivity;
import com.coolopool.coolopool.Activity.SettingActivity;
import com.coolopool.coolopool.Activity.UserActivity;
import com.coolopool.coolopool.Adapter.PhotoListAdapter;
import com.coolopool.coolopool.Adapter.TripListAdapter;
import com.coolopool.coolopool.Application.MyApplication;
import com.coolopool.coolopool.Class.Photolist;
import com.coolopool.coolopool.Class.Triplist;
import com.coolopool.coolopool.R;

import java.util.ArrayList;


public class ProfileFragment extends Fragment {

    View v;
    RecyclerView mTripList,mPhotoList;
    TextView mFollowButton, mAddPost, mAddPhoto;
    ImageButton mSettingButton;


    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        v =  inflater.inflate(R.layout.fragment_profile, container, false);

        //for Setting
        mSettingButton = v.findViewById(R.id.settingbtn);
        mSettingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyApplication.getAppContext(), SettingActivity.class);
                startActivity(intent);
            }
        });

        // this is for Trip List View

        ArrayList<Triplist> tripList = new ArrayList<>();

        tripList.add(new Triplist(R.drawable.trip1,"Goa","2"));
        tripList.add(new Triplist(R.drawable.trip2,"Sikkim","2"));
        tripList.add(new Triplist(R.drawable.trip1,"Goa","2"));
        tripList.add(new Triplist(R.drawable.trip2,"Sikkim","2"));
        tripList.add(new Triplist(R.drawable.trip1,"Goa","2"));
        tripList.add(new Triplist(R.drawable.trip2,"Sikkim","2"));

        mTripList = v.findViewById(R.id.Trip_RecyclerView);
        mTripList.setLayoutManager(new LinearLayoutManager(MyApplication.getAppContext(), LinearLayoutManager.HORIZONTAL, false));
        mTripList.setAdapter(new TripListAdapter(tripList,MyApplication.getAppContext()));

        // this is for Photo List View

        ArrayList<Photolist> photoList = new ArrayList<>();

        photoList.add(new Photolist(R.drawable.photo4,"Room","USA"));
        photoList.add(new Photolist(R.drawable.photo1,"Food","kathi junction"));
        photoList.add(new Photolist(R.drawable.photo5,"Night Room","London"));
        photoList.add(new Photolist(R.drawable.photo2,"Burger","burger king"));
        photoList.add(new Photolist(R.drawable.photo4,"Room","USA"));
        photoList.add(new Photolist(R.drawable.photo3,"BedRoom","OYO"));

        mPhotoList = v.findViewById(R.id.Photo_RecyclerView);
        mPhotoList.setLayoutManager(new LinearLayoutManager(MyApplication.getAppContext(), LinearLayoutManager.HORIZONTAL,false));
        mPhotoList.setAdapter(new PhotoListAdapter(photoList,MyApplication.getAppContext()));

        mFollowButton = v.findViewById(R.id.followbtn);
        mFollowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Log_test", "followers activity is started");
                Intent intent = new Intent(MyApplication.getAppContext(), FollowersActivity.class);
                startActivity(intent);
            }
        });


        mAddPhoto = v.findViewById(R.id.addPhoto);
        mAddPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Log_test","Add New photo is open");
                Intent intent = new Intent(MyApplication.getAppContext(), NewPicPostActivity.class);
                startActivity(intent);
            }
        });

        mAddPost = v.findViewById(R.id.addTrip);
        mAddPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Log_test","Add New photo is open");
                Intent intent = new Intent(MyApplication.getAppContext(), NewPostActivity.class);
                startActivity(intent);
            }
        });



        return v;
    }

    public View getView() {
        return v;
    }

}
