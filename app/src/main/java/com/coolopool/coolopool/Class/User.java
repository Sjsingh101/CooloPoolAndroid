package com.coolopool.coolopool.Class;

public class User {

    private String username;
    private String password;
    private String name;
    private String phoneNo;
    private String email;

    public User(String username, String password, String name, String phoneNo, String email) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.phoneNo = phoneNo;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

}
