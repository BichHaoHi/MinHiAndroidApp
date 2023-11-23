package com.example.projecthk1_2023_2024.Util.ViewModel;

import android.app.Application;
import android.util.Pair;

import com.example.projecthk1_2023_2024.model.Exp_Batch;
import com.example.projecthk1_2023_2024.model.Export;
import com.example.projecthk1_2023_2024.model.ProductBatch;

public class VMNewExport extends Application {
    Pair<String, Export> expPair;
    Pair<String, ProductBatch> batchPair;
    Pair<String, Exp_Batch> exp_batchPair;

    public VMNewExport(Pair<String, Export> expPair, Pair<String, ProductBatch> batchPair, Pair<String, Exp_Batch> exp_batchPair) {
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

    public Pair<String, Exp_Batch> getExp_batchPair() {
        return exp_batchPair;
    }

    public void setExp_batchPair(Pair<String, Exp_Batch> exp_batchPair) {
        this.exp_batchPair = exp_batchPair;
    }
}
