package com.coolopool.coolopool.Class;

import android.content.Context;
import android.net.Uri;

import com.coolopool.coolopool.Adapter.NestedImageAdapter;

import java.util.ArrayList;
import java.util.List;

public class NewDay {

    public static int COUNT = 1;

    String mDays;
    String mDescription;
    ArrayList<Uri> mImageUri;
    NestedImageAdapter mAdapter;
    Context mContext;

    public NewDay() {
    }

    public NewDay(String mDescription, Context context) {
        this.mDescription = mDescription;
        this.mImageUri = new ArrayList<>();
        this.mContext = context;
        this.mDays = "DAY "+COUNT;
        this.setUpAdapter();
        COUNT ++ ;
    }

    public NewDay(String mDescription, Context context, ArrayList<Uri> images) {
        this.mDescription = mDescription;
        this.mImageUri = images;
        this.mContext = context;
        this.mDays = "DAY "+COUNT;
        this.setUpAdapter();
        COUNT ++ ;
    }

    private void setUpAdapter(){
        mAdapter = new NestedImageAdapter(this.getmImageUri(), mContext);
    }

    public NestedImageAdapter getmAdapter() {
        return mAdapter;
    }

    public void addmImageUri(List<Uri> uri) {
        this.mImageUri.addAll(uri);
        this.mAdapter.notifyDataSetChanged();
    }

    public String getmDays() {
        return mDays;
    }

    public String getmDescription() {
        return mDescription;
    }

    public ArrayList<Uri> getmImageUri() {
        return mImageUri;
    }
}
