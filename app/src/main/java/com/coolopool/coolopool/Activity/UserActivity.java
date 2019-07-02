package com.coolopool.coolopool.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.coolopool.coolopool.Adapter.PhotoListAdapter;
import com.coolopool.coolopool.Adapter.TripListAdapter;
import com.coolopool.coolopool.Class.Photolist;
import com.coolopool.coolopool.Class.Triplist;
import com.coolopool.coolopool.R;
import java.util.ArrayList;

public class UserActivity extends AppCompatActivity {

    RecyclerView mTripList,mPhotoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

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
    }
}
