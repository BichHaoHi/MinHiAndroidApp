package com.example.projecthk1_2023_2024.Util;

import android.app.Application;

import com.example.projecthk1_2023_2024.model.User;

public class AuUser extends Application {
    private User user;

    private static AuUser instance;

    public static AuUser getInstance(){
        if (instance == null){
            instance = new AuUser();
        }
        return instance;
    }

    public AuUser() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
