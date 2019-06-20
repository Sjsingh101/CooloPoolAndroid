package com.coolopool.coolopool.Class;

import java.io.Serializable;

public class Hotel implements Serializable {

    private String mName;
    private String mCost;
    private String mLocation;
    private String mThumbnailUrl;
    private float mRating;

    public Hotel(){}

    public Hotel(String mName, String mCost, String mLocation, String mThumbnailUrl, float mRating) {
        this.mName = mName;
        this.mCost = mCost;
        this.mLocation = mLocation;
        this.mThumbnailUrl = mThumbnailUrl;
        this.mRating = mRating;
    }

    public String getmName() {
        return mName;
    }

    public String getmCost() {
        return mCost;
    }

    public String getmLocation() {
        return mLocation;
    }

    public String getmThumbnailUrl() {
        return mThumbnailUrl;
    }

    public float getmRating() {
        return mRating;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public void setmCost(String mCost) {
        this.mCost = mCost;
    }

    public void setmLocation(String mLocation) {
        this.mLocation = mLocation;
    }

    public void setmThumbnailUrl(String mThumbnailUrl) {
        this.mThumbnailUrl = mThumbnailUrl;
    }

    public void setmRating(float mRating) {
        this.mRating = mRating;
    }
}
