package com.example.projecthk1_2023_2024.Util;

import android.app.Application;
import android.util.Pair;

import com.example.projecthk1_2023_2024.model.Product;

import java.util.List;

public class ProductListAdd extends Application {
    List<Pair<String, Product>> productList;
    public static ProductListAdd instance;
    public static ProductListAdd getInstance(){
        if (instance == null){
            instance = new ProductListAdd();
        }
        return instance;
    }

    public ProductListAdd(List<Pair<String, Product>> productList) {
        this.productList = productList;
    }

    public ProductListAdd() {
    }

    public List<Pair<String, Product>> getProductList() {
        return productList;
    }

    public void setProductList(List<Pair<String, Product>> productList) {
        this.productList = productList;
    }
}
