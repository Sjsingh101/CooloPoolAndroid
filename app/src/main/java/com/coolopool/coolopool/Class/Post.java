package com.coolopool.coolopool.Class;

import android.content.Context;

import com.coolopool.coolopool.Adapter.StackCardAdapter;

public class Post {

    String[] imageUrl;
    String title;
    String userInfo;
    String[] description;
    int heartCounts;
    StackCardAdapter adapter;
    Context context;

    public Post(String[] imageUrl, String title, String[] description, int heartCount, Context context) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.description = description;
        this.context = context;
        this.userInfo = "Default";
        this.setUpAdapter();
    }

    private void setUpAdapter(){
        adapter = new StackCardAdapter(imageUrl, description, context);
    }

    public StackCardAdapter getAdapter() {
        return adapter;
    }

    public int getHeartCounts() {
        return heartCounts;
    }

    public String getUserInfo() {
        return userInfo;
    }

    public String getTitle() {
        return title;
    }

    public int getImageLen(){
        return imageUrl.length;
    }

    public String[] getImageUrl() {
        return imageUrl;
    }

    public String[] getDescription() {
        return description;
    }

    public Context getContext() {
        return context;
    }
}
