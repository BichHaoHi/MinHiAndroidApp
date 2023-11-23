package com.example.projecthk1_2023_2024.Util.ViewModel;

import android.app.Application;
import android.util.Pair;

import com.example.projecthk1_2023_2024.model.Product;

import java.util.List;

public class VMProductListAdd extends Application {
    List<Pair<String, Product>> productList;
    public static VMProductListAdd instance;
    public static VMProductListAdd getInstance(){
        if (instance == null){
            instance = new VMProductListAdd();
        }
        return instance;
    }

    public VMProductListAdd(List<Pair<String, Product>> productList) {
        this.productList = productList;
    }

    public VMProductListAdd() {
    }

    public List<Pair<String, Product>> getProductList() {
        return productList;
    }

    public void setProductList(List<Pair<String, Product>> productList) {
        this.productList = productList;
    }
}
