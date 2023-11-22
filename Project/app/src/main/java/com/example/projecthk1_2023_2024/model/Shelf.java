package com.example.projecthk1_2023_2024.model;

import androidx.databinding.BaseObservable;

public class Shelf extends BaseObservable {
    private String name;
    private int total;
    private boolean enable;

    public Shelf(String name, int total, boolean enable) {
        this.name = name;
        this.total = total;
        this.enable = enable;
    }

    public Shelf() {
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
