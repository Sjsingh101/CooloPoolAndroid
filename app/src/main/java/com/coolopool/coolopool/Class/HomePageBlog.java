package com.coolopool.coolopool.Class;

public class HomePageBlog {

    private String title;

    private String description;

    private int heartCount;

    private String imageUrl;

    public HomePageBlog(String title, String description, int heartCount, String imageUrl) {
        this.title = title;
        this.description = description;
        this.heartCount = heartCount;
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getHeartCount() {
        return heartCount;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
