package com.example.projecthk1_2023_2024.Util;

import android.app.Application;
import android.util.Pair;

import com.example.projecthk1_2023_2024.model.ImportBatch;
import com.example.projecthk1_2023_2024.model.Product;

import java.util.List;

public class ListImportBatch extends Application {
    List<Pair<String, ImportBatch>> impList;
    public static ListImportBatch instance;
    public static ListImportBatch getInstance(){
        if (instance == null){
            instance = new ListImportBatch();
        }
        return instance;
    }

    public ListImportBatch(List<Pair<String, ImportBatch>> impList) {
        this.impList = impList;
    }

    public ListImportBatch() {
    }

    public List<Pair<String, ImportBatch>> getProductList() {
        return impList;
    }

    public void setListImportBatch(List<Pair<String, ImportBatch>> impList) {
        this.impList = impList;
    }
}

