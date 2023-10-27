package com.example.projecthk1_2023_2024.model;

import com.google.firebase.Timestamp;

public class User {
    private String Name;
    private String PostCode;
    private String Image;
    private Timestamp Start_Date;
    private boolean Enable;
    private Timestamp Birthday;
    private String Email;
    private String Sex;
    private String Phone;
    private String Address;
    private String Role;
    private String LoginId;

    public User() {
    }

    public User(String name, String postCode, String image, Timestamp start_Date, boolean enable, Timestamp birthday, String email, String sex, String phone, String address, String role, String loginId) {
        Name = name;
        PostCode = postCode;
        Image = image;
        Start_Date = start_Date;
        Enable = enable;
        Birthday = birthday;
        Email = email;
        Sex = sex;
        Phone = phone;
        Address = address;
        Role = role;
        LoginId = loginId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPostCode() {
        return PostCode;
    }

    public void setPostCode(String postCode) {
        PostCode = postCode;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public Timestamp getStart_Date() {
        return Start_Date;
    }

    public void setStart_Date(Timestamp start_Date) {
        Start_Date = start_Date;
    }

    public boolean isEnable() {
        return Enable;
    }

    public void setEnable(boolean enable) {
        Enable = enable;
    }

    public Timestamp getBirthday() {
        return Birthday;
    }

    public void setBirthday(Timestamp birthday) {
        Birthday = birthday;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }

    public String getLoginId() {
        return LoginId;
    }

    public void setLoginId(String loginId) {
        LoginId = loginId;
    }
}
