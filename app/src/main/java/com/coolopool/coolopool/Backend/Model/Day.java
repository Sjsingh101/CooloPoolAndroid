package com.coolopool.coolopool.Backend.Model;

import android.net.Uri;

import java.util.ArrayList;

public class Day {

    String dayCout;
    String title;
    ArrayList<Uri> images;

    public Day(String dayCout, String title, ArrayList<Uri> images) {
        this.dayCout = dayCout;
        this.title = title;
        this.images = images;
    }

    public String getDayCout() {
        return dayCout;
    }

    public void setDayCout(String dayCout) {
        this.dayCout = dayCout;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<Uri> getImages() {
        return images;
    }

    public void setImages(ArrayList<Uri> images) {
        this.images = images;
    }
}
