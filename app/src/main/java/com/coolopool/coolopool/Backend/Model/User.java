package com.coolopool.coolopool.Backend.Model;

public class User {

    String email;
    String username;
    String name;
    String password;
    String noOfTrips;
    String noOfPhotos;
    String noOfFollowers;

    public User(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public User(String email, String username, String name, String password, String noOfTrips, String noOfPhotos, String noOfFollowers) {
        this.email = email;
        this.username = username;
        this.name = name;
        this.password = password;
        this.noOfTrips = noOfTrips;
        this.noOfPhotos = noOfPhotos;
        this.noOfFollowers = noOfFollowers;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getNoOfTrips() {
        return noOfTrips;
    }

    public String getNoOfPhotos() {
        return noOfPhotos;
    }

    public String getNoOfFollowers() {
        return noOfFollowers;
    }
}
