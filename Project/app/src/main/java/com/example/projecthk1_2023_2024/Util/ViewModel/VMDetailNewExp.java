package com.example.projecthk1_2023_2024.Util.ViewModel;

import android.app.Application;
import android.util.Pair;

import com.example.projecthk1_2023_2024.model.Exp_Batch;
import com.example.projecthk1_2023_2024.model.Export;
import com.example.projecthk1_2023_2024.model.Product;
import com.example.projecthk1_2023_2024.model.ProductBatch;
import com.example.projecthk1_2023_2024.model.Shelf;
import com.example.projecthk1_2023_2024.model.Zone;

public class VMDetailNewExp extends Application {
    Pair<String, Product> productPair2;
    Pair<String, Shelf> shelfPair2;
    Pair<String, Exp_Batch> exp_batchPair2;
    Pair<String, ProductBatch> batchPair2;
    Pair<String, Zone> zonePair2;

    public VMDetailNewExp(Pair<String, Product> productPair2, Pair<String, Shelf> shelfPair2, Pair<String, Exp_Batch> exp_batchPair2, Pair<String, ProductBatch> batchPair2, Pair<String, Zone> zonePair2) {
        this.productPair2 = productPair2;
        this.shelfPair2 = shelfPair2;
        this.exp_batchPair2 = exp_batchPair2;
        this.batchPair2 = batchPair2;
        this.zonePair2 = zonePair2;
    }

    public VMDetailNewExp() {
    }

    public Pair<String, Product> getProductPair2() {
        return productPair2;
    }

    public void setProductPair2(Pair<String, Product> productPair2) {
        this.productPair2 = productPair2;
    }

    public Pair<String, Shelf> getShelfPair2() {
        return shelfPair2;
    }

    public void setShelfPair2(Pair<String, Shelf> shelfPair2) {
        this.shelfPair2 = shelfPair2;
    }

    public Pair<String, Exp_Batch> getExp_batchPair2() {
        return exp_batchPair2;
    }

    public void setExp_batchPair2(Pair<String, Exp_Batch> exp_batchPair2) {
        this.exp_batchPair2 = exp_batchPair2;
    }

    public Pair<String, ProductBatch> getBatchPair2() {
        return batchPair2;
    }

    public void setBatchPair2(Pair<String, ProductBatch> batchPair2) {
        this.batchPair2 = batchPair2;
    }

    public Pair<String, Zone> getZonePair2() {
        return zonePair2;
    }

    public void setZonePair2(Pair<String, Zone> zonePair2) {
        this.zonePair2 = zonePair2;
    }

}