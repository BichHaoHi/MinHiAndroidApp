package com.example.projecthk1_2023_2024.Util.ViewModel;

import android.app.Application;
import android.util.Pair;

import com.example.projecthk1_2023_2024.model.Product;
import com.example.projecthk1_2023_2024.model.ProductBatch;

public class VMQlsp extends Application {
    Pair<String, Product> productPair4;
    Pair<String, ProductBatch> batchPair4;

    public VMQlsp(Pair<String, Product> productPair4, Pair<String, ProductBatch> batchPair4) {
        this.productPair4 = productPair4;
        this.batchPair4 = batchPair4;
    }

    public VMQlsp() {
    }

    public Pair<String, Product> getProductPair4() {
        return productPair4;
    }

    public void setProductPair4(Pair<String, Product> productPair4) {
        this.productPair4 = productPair4;
    }

    public Pair<String, ProductBatch> getBatchPair4() {
        return batchPair4;
    }

    public void setBatchPair4(Pair<String, ProductBatch> batchPair4) {
        this.batchPair4 = batchPair4;
    }
}
