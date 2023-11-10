package com.example.projecthk1_2023_2024.Util;

import android.app.Application;
import android.util.Pair;

import com.example.projecthk1_2023_2024.model.User;

import java.util.List;

public class ListUser extends Application {
    List<Pair<String, User>> listUser;
    public static ListUser instance;
    public static ListUser getInstance(){
        if (instance == null){
            instance = new ListUser();
        }
        return instance;
    }

    public ListUser() {
    }

    public List<Pair<String, User>> getListUser() {
        return listUser;
    }

    public void setListUser(List<Pair<String, User>> listUser) {
        this.listUser = listUser;
    }
}
