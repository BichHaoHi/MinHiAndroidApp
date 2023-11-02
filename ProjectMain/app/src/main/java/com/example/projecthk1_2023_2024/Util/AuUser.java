package com.example.projecthk1_2023_2024.Util;

import android.app.Application;

public class AuUser extends Application {
    private String username;
    private String loginId;

    private static AuUser instance;

    public static AuUser getInstance(){
        if (instance == null){
            instance = new AuUser();
        }
        return instance;
    }

    public AuUser() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setUserId(String userId) {
        this.loginId = userId;
    }
}
