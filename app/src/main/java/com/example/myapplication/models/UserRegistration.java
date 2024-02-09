package com.example.myapplication.models;

public class UserRegistration {
    String full_name, phone_number, email, password;
    int image;

    public UserRegistration(String full_name, String phone_number, String email, String password, int image) {
        this.full_name = full_name;
        this.phone_number = phone_number;
        this.email = email;
        this.password = password;
        this.image = image;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
