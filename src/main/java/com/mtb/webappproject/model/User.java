package com.mtb.webappproject.model;

public class User {

    private String email;
    private String username;
    private String password;

    public User(String email) {
        this.email = email;
        this.password="1111";
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
