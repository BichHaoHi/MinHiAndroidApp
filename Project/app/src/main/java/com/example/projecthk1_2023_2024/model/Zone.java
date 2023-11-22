package com.example.projecthk1_2023_2024.model;

import androidx.databinding.BaseObservable;

public class Zone extends BaseObservable {
    private int total;
    private boolean enable;
    private String name;// thêm thuoc tinh

    public Zone(int total, boolean enable, String name) {
        this.total = total;
        this.enable = enable;
        this.name = name;
    }

    public Zone() {
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
