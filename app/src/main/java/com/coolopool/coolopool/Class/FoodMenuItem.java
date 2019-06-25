package com.coolopool.coolopool.Class;

public class FoodMenuItem {

    String mItem;
    int mType;// veg: 0 and non-veg: 1

    public FoodMenuItem(String mItem, int mType) {
        this.mItem = mItem;
        this.mType = mType;
    }

    public String getmItem() {
        return mItem;
    }

    public int getmType() {
        return mType;
    }

}
