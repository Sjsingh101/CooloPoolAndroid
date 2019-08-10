package com.coolopool.coolopool.Class;

public class RoomType {

    String mType;
    int mAvailability;

    public RoomType(String mType, int mAvailability) {
        this.mType = mType;
        this.mAvailability = mAvailability;
    }

    public String getmType() {
        return mType;
    }

    public String getmAvailability() {
        return ""+mAvailability;
    }
}
