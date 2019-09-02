package com.coolopool.coolopool.Backend.Model;

import android.net.Uri;

import java.util.ArrayList;

public class Day {

    String dayCount;
    String title;
    String description;
    ArrayList<String> images;

    public Day(String dayCount, String title, String description, ArrayList<String> images) {
        this.dayCount = dayCount;
        this.title = title;
        this.description = description;
        this.images = images;
    }

    public String getDayCount() {
        return dayCount;
    }

    public void setDayCount(String dayCount) {
        this.dayCount = dayCount;
    }

    public String gettitle() {
        return title;
    }


    public String getdescription() {
        return description;
    }


    public ArrayList<String> getImages() {
        return images;
    }

    public void setImages(ArrayList<String> images) {
        this.images = images;
    }
}
