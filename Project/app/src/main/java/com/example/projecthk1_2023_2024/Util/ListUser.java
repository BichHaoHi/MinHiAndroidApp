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
    public Pair<String, User> find(String id){
        for (Pair<String, User> user : listUser){
            if (user.first.equals(id)){
                return user;
            }
        }
        return null;
    }
    public int setIdDocument(){
        for (int i = 0; i<listUser.size()-1 ; i++){
            if (Integer.parseInt(listUser.get(i+1).first) - Integer.parseInt(listUser.get(i).first) != 1){
                 return Integer.parseInt(listUser.get(i).first);
            }
        }
        return listUser.size()+1;
    }
}
