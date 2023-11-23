package com.example.projecthk1_2023_2024.Util.ViewModel;

import android.app.Application;
import android.util.Pair;

import com.example.projecthk1_2023_2024.model.Export;
import com.example.projecthk1_2023_2024.model.Import_Batch;
import com.example.projecthk1_2023_2024.model.Product;
import com.example.projecthk1_2023_2024.model.ProductBatch;

public class VMNewImport extends Application {
    Pair<String, Import_Batch> impPair;
    Pair<String, Product> productPair;
    Pair<String, ProductBatch> batchPair;

    public VMNewImport(Pair<String, Import_Batch> impPair, Pair<String, Product> productPair, Pair<String, ProductBatch> batchPair) {
        this.impPair = impPair;
        this.productPair = productPair;
        this.batchPair = batchPair;
    }

    public VMNewImport() {
    }

    public Pair<String, Import_Batch> getImpPair() {
        return impPair;
    }

    public void setImpPair(Pair<String, Import_Batch> impPair) {
        this.impPair = impPair;
    }

    public Pair<String, Product> getProductPair() {
        return productPair;
    }

    public void setProductPair(Pair<String, Product> productPair) {
        this.productPair = productPair;
    }

    public Pair<String, ProductBatch> getBatchPair() {
        return batchPair;
    }

    public void setBatchPair(Pair<String, ProductBatch> batchPair) {
        this.batchPair = batchPair;
    }
}
