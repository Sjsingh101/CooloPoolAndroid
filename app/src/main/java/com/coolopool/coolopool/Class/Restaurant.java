package com.coolopool.coolopool.Class;

import java.util.ArrayList;

public class Restaurant {

    String mThumbnailUrl;
    String mName;
    String mCost;
    String mOpeningTime;
    String mClosingTime;
    int mTypeOfFood; //veg = 0, non-veg = 1 or both = 2
    ArrayList<String> mTypeOfCuisine; // italian, indian, american etc...

    public Restaurant(String mThumbnailUrl, String mName, String mCost, String mOpeningTime, String mClosingTime, int mTypeOfFood, ArrayList<String> mTypeOfCuisine) {
        this.mThumbnailUrl = mThumbnailUrl;
        this.mName = mName;
        this.mCost = mCost;
        this.mOpeningTime = mOpeningTime;
        this.mClosingTime = mClosingTime;
        this.mTypeOfFood = mTypeOfFood;
        this.mTypeOfCuisine = mTypeOfCuisine;
    }

    public String getmThumbnailUrl() {
        return mThumbnailUrl;
    }

    public void setmThumbnailUrl(String mThumbnailUrl) {
        this.mThumbnailUrl = mThumbnailUrl;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public int getmTypeOfFood() {
        return mTypeOfFood;
    }

    public void setmTypeOfFood(int mTypeOfFood) {
        this.mTypeOfFood = mTypeOfFood;
    }

    public String getmCost() {
        return mCost;
    }

    public void setmCost(String mCost) {
        this.mCost = mCost;
    }

    public String getmOpeningTime() {
        return mOpeningTime;
    }

    public void setmOpeningTime(String mOpeningTime) {
        this.mOpeningTime = mOpeningTime;
    }

    public String getmClosingTime() {
        return mClosingTime;
    }

    public void setmClosingTime(String mClosingTime) {
        this.mClosingTime = mClosingTime;
    }


    public String getmTypeOfCuisine() {
        String result = "";
        if(mTypeOfCuisine.size() == 1){
            result = mTypeOfCuisine.get(0);
        }else{
            for(int i=0; i<mTypeOfCuisine.size(); i++){
                result += mTypeOfCuisine.get(i) + " | ";
            }
        }
        return result;

    }

    public void setmTypeOfCuisine(ArrayList<String> mTypeOfCuisine) {
        this.mTypeOfCuisine = mTypeOfCuisine;
    }
}
