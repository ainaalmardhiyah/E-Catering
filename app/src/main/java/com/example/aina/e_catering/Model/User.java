package com.example.aina.e_catering.Model;

/**
 * Created by ASUS on 10/12/2017.
 */

public class User {
    private String Username;
    private String Password;
    private String Phone;

    public User() {
    }

    public User(String username, String password) {
        Username = username;
        Password = password;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }
}
