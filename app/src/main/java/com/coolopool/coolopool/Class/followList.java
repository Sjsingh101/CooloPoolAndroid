package com.coolopool.coolopool.Class;

import android.widget.Button;

public class followList{

    private int mUserProfilePic;
    private String mUserName, mFullName;

    public  followList(int userProfilePic, String userName, String userFullName){
        mUserProfilePic = userProfilePic;
        mUserName = userName;
        mFullName = userFullName;
    }

    public int getmUserProfilePic(){return mUserProfilePic;}
    public  String getmUserName(){return mUserName;}
    public  String getmFullName(){return  mFullName;}
}
