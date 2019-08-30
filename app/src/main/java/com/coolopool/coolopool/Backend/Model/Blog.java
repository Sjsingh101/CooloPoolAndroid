package com.coolopool.coolopool.Backend.Model;

import java.util.ArrayList;
import java.util.Map;

public class Blog {

    String title;
    String description;
    int Views;
    int likes;
    int experienced;
    ArrayList<Day> days;

    public Blog(String title, String description, int views, int likes, int experienced, ArrayList<Day> days) {
        this.title = title;
        this.description = description;
        Views = views;
        this.likes = likes;
        this.experienced = experienced;
        this.days = days;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getViews() {
        return Views;
    }

    public void setViews(int views) {
        Views = views;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getExperienced() {
        return experienced;
    }

    public void setExperienced(int experienced) {
        this.experienced = experienced;
    }

    public ArrayList<Day> getDays() {
        return days;
    }

    public void setDays(ArrayList<Day> days) {
        this.days = days;
    }
}
