package com.coolopool.coolopool.Class;

public class Photolist {

    private int mPhoto;
    private  String mPhotoPlace, mPhotoName;

    public Photolist(int Photo, String PhotoName, String PhotoPlace){
        mPhoto = Photo;
        mPhotoName = PhotoName;
        mPhotoPlace = PhotoPlace;
    }

    public int getmPhoto(){return mPhoto;}

    public  String getmPhotoName(){return mPhotoName;}

    public  String getmPhotoPlace(){return mPhotoPlace;}
}
