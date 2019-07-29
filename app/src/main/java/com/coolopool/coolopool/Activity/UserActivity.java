package com.coolopool.coolopool.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.coolopool.coolopool.Adapter.PhotoListAdapter;
import com.coolopool.coolopool.Adapter.TripListAdapter;
import com.coolopool.coolopool.Class.Photolist;
import com.coolopool.coolopool.Class.Triplist;
import com.coolopool.coolopool.R;
import java.util.ArrayList;

public class UserActivity extends AppCompatActivity {

    RecyclerView mTripList,mPhotoList;
    TextView mFollowButton, mAddPost, mAddPhoto;
    ImageButton mSettingButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        //for Setting
        mSettingButton = findViewById(R.id.settingbtn);
        mSettingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserActivity.this, SettingActivity.class);
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

        mTripList = findViewById(R.id.Trip_RecyclerView);
        mTripList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        mTripList.setAdapter(new TripListAdapter(tripList,this));

        // this is for Photo List View

        ArrayList<Photolist> photoList = new ArrayList<>();

        photoList.add(new Photolist(R.drawable.photo4,"Room","USA"));
        photoList.add(new Photolist(R.drawable.photo1,"Food","kathi junction"));
        photoList.add(new Photolist(R.drawable.photo5,"Night Room","London"));
        photoList.add(new Photolist(R.drawable.photo2,"Burger","burger king"));
        photoList.add(new Photolist(R.drawable.photo4,"Room","USA"));
        photoList.add(new Photolist(R.drawable.photo3,"BedRoom","OYO"));

        mPhotoList = findViewById(R.id.Photo_RecyclerView);
        mPhotoList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
        mPhotoList.setAdapter(new PhotoListAdapter(photoList,this));

        mFollowButton = findViewById(R.id.followbtn);
        mFollowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Log_test", "followers activity is started");
                Intent intent = new Intent(UserActivity.this, FollowersActivity.class);
                startActivity(intent);
            }
        });

       /* mPhotoButton = findViewById(R.id.photobtn);
        mPhotoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Log_test", "Photo activity is started");
                Intent intent = new Intent(UserActivity.this, PhotoActivity.class);
                startActivity(intent);
            }
        });

        mTripButton = findViewById(R.id.tripsbtn);
        mTripButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Log_test", "Trip activity is started");
                Intent intent = new Intent(UserActivity.this, TripActivity.class);
                startActivity(intent);
            }
        });*/

       mAddPhoto = findViewById(R.id.addPhoto);
       mAddPhoto.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Log.d("Log_test","Add New photo is open");
               Intent intent = new Intent(UserActivity.this, NewPicPostActivity.class);
               startActivity(intent);
           }
       });

        mAddPost = findViewById(R.id.addTrip);
        mAddPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Log_test","Add New photo is open");
                Intent intent = new Intent(UserActivity.this, NewPostActivity.class);
                startActivity(intent);
            }
        });
    }
}
