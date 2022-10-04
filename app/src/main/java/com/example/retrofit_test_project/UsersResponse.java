package com.example.retrofit_test_project;

public class UsersResponse {
    private int id;
    private String name;
    private String username;
    private String email;
    private address address;

    public int getId () {
        return id;
    }

    public void setId (int id) {
        this.id = id;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getUsername () {
        return username;
    }

    public void setUsername (String username) {
        this.username = username;
    }

    public String getEmail () {
        return email;
    }

    public void setEmail (String email) {
        this.email = email;
    }

    public com.example.retrofit_test_project.address getAddress () {
        return address;
    }

    public void setAddress (com.example.retrofit_test_project.address address) {
        this.address = address;
    }
}
