package com.example.projecthk1_2023_2024.Util.ViewModel;

import android.app.Application;
import android.util.Pair;

import com.example.projecthk1_2023_2024.model.ExpBatch;
import com.example.projecthk1_2023_2024.model.Export;
import com.example.projecthk1_2023_2024.model.ProductBatch;

public class VMNewExport extends Application {
    Pair<String, Export> expPair;
    Pair<String, ProductBatch> batchPair;
    Pair<String, ExpBatch> exp_batchPair;

    public VMNewExport(Pair<String, Export> expPair, Pair<String, ProductBatch> batchPair, Pair<String, ExpBatch> exp_batchPair) {
        this.expPair = expPair;
        this.batchPair = batchPair;
        this.exp_batchPair = exp_batchPair;
    }

    public VMNewExport() {
    }

    public Pair<String, Export> getExpPair() {
        return expPair;
    }

    public void setExpPair(Pair<String, Export> expPair) {
        this.expPair = expPair;
    }

    public Pair<String, ProductBatch> getBatchPair() {
        return batchPair;
    }

    public void setBatchPair(Pair<String, ProductBatch> batchPair) {
        this.batchPair = batchPair;
    }

    public Pair<String, ExpBatch> getExp_batchPair() {
        return exp_batchPair;
    }

    public void setExp_batchPair(Pair<String, ExpBatch> exp_batchPair) {
        this.exp_batchPair = exp_batchPair;
    }
}
