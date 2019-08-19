package com.coolopool.coolopool.Class;

public class Offer {

    int mImageId;
    String mType;
    String mDescription;
    int mExpiry;

    public Offer(int mImageId, String mType, String mDescription, int mExpiry) {
        this.mImageId = mImageId;
        this.mType = mType;
        this.mDescription = mDescription;
        this.mExpiry = mExpiry;
    }

    public int getmImageId() {
        return mImageId;
    }

    public String getmType() {
        return mType;
    }

    public String getmDescription() {
        return mDescription;
    }

    public String getmExpiry() {
        return ""+mExpiry;
    }
}
