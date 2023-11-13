package com.example.projecthk1_2023_2024.Util;

import android.app.Application;
import android.util.Pair;

import com.example.projecthk1_2023_2024.model.Product;
import com.example.projecthk1_2023_2024.model.User;

import java.util.List;

public class ProListAd extends Application {
    List<Pair<String, Product>> productList;
    public static ProListAd instance;
    public static ProListAd getInstance(){
        if (instance == null){
            instance = new ProListAd();
        }
        return instance;
    }

    public ProListAd(List<Pair<String, Product>> productList) {
        this.productList = productList;
    }

    public ProListAd() {
    }

    public List<Pair<String, Product>> getProductList() {
        return productList;
    }

    public void setProductList(List<Pair<String, Product>> productList) {
        this.productList = productList;
    }
}
