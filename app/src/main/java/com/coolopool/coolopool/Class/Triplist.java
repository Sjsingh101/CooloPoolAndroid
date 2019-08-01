package com.coolopool.coolopool.Class;

public class Triplist {

    private int mTripPic;
    private String mTripPlace, mNoOfTripDays;

    public Triplist(int TripPic, String TripPlace, String NoofTripDays){
        mTripPic = TripPic;
        mTripPlace = TripPlace;
        mNoOfTripDays = NoofTripDays;
    }

    public int getmTripPic(){return mTripPic;}

    public String getmTripPlace() {return mTripPlace;}

    public String getmNoOfTripDays() {return mNoOfTripDays;}

}
