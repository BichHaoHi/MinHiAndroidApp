package com.example.projecthk1_2023_2024.model;

import androidx.databinding.BaseObservable;

public class Zone extends BaseObservable {
    private int Total;
    private boolean Enable;
    private String Name;

    public Zone() {
    }

    public Zone(int total, boolean enable, String name) {
        Total = total;
        Enable = enable;
        Name = name;
    }

    public int getTotal() {
        return Total;
    }

    public void setTotal(int total) {
        Total = total;
    }

    public boolean isEnable() {
        return Enable;
    }

    public void setEnable(boolean enable) {
        Enable = enable;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
