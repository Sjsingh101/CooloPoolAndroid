package com.coolopool.coolopool.Class;

public class Review {

    private int mIcon;
    private float mRating;
    private String mUserAddress;
    private String mTitle;
    private String mDescription;
    private String mDate;


    public Review(int mIcon, float mRating, String mUserAddress, String mTitle, String mDescription, String mDate) {
        this.mIcon = mIcon;
        this.mRating = mRating;
        this.mUserAddress = mUserAddress;
        this.mTitle = mTitle;
        this.mDescription = mDescription;
        this.mDate = mDate;
    }

    public int getmIcon() {
        return mIcon;
    }

    public void setmIcon(int mIcon) {
        this.mIcon = mIcon;
    }

    public float getmRating() {
        return mRating;
    }

    public void setmRating(float mRating) {
        this.mRating = mRating;
    }

    public String getmUserAddress() {
        return mUserAddress;
    }

    public void setmUserAddress(String mUserAddress) {
        this.mUserAddress = mUserAddress;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public String getmDate() {
        return mDate;
    }

    public void setmDate(String mDate) {
        this.mDate = mDate;
    }
}
