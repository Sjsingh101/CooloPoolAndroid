package com.coolopool.coolopool.Class;

public class Review {

    private int mIcon;
    private String mUserAddress;
    private String mTitle;
    private String mDescription;


    public Review(int mIcon, String mUserAddress, String mTitle, String mDescription) {
        this.mIcon = mIcon;
        this.mUserAddress = mUserAddress;
        this.mTitle = mTitle;
        this.mDescription = mDescription;
    }

    public int getmIcon() {
        return mIcon;
    }

    public void setmIcon(int mIcon) {
        this.mIcon = mIcon;
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
}
