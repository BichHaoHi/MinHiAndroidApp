package com.example.projecthk1_2023_2024.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.google.firebase.Timestamp;

public class User extends BaseObservable {
    private String Address;
    private Timestamp Birthday;
    private String Email;
    private Boolean Enable;
    private String Image;
    private String LoginID;
    private String UserName;
    private String Phone;
    private String Postcode;
    private String Role;
    private String Sex;
    private Timestamp Start_Date;


    public User() {
    }

    public User(String address, Timestamp birthday, String email, Boolean enable, String image, String loginID, String name, String phone, String postcode, String role, String sex, Timestamp start_Date) {
        Address = address;
        Birthday = birthday;
        Email = email;
        Enable = enable;
        Image = image;
        LoginID = loginID;
        UserName = name;
        Phone = phone;
        Postcode = postcode;
        Role = role;
        Sex = sex;
        Start_Date = start_Date;
    }

    @Bindable
    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    @Bindable
    public Timestamp getBirthday() {
        return Birthday;
    }

    public void setBirthday(Timestamp birthday) {
        Birthday = birthday;
    }

    @Bindable
    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    @Bindable
    public Boolean getEnable() {
        return Enable;
    }

    public void setEnable(Boolean enable) {
        Enable = enable;
    }

    @Bindable
    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    @Bindable
    public String getLoginID() {
        return LoginID;
    }

    public void setLoginID(String loginID) {
        LoginID = loginID;
    }

    @Bindable
    public String getUserName() {
        return UserName;
    }

    public void setUserName(String name) {
        UserName = name;
    }

    @Bindable
    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    @Bindable
    public String getPostcode() {
        return Postcode;
    }

    public void setPostcode(String postcode) {
        Postcode = postcode;
    }

    @Bindable
    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }

    @Bindable
    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    @Bindable
    public Timestamp getStart_Date() {
        return Start_Date;
    }

    public void setStart_Date(Timestamp start_Date) {
        Start_Date = start_Date;
    }
}
