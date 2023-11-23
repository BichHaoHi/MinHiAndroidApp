package com.example.projecthk1_2023_2024.Util.ViewModel;

import android.app.Application;
import android.util.Pair;

import com.example.projecthk1_2023_2024.model.Import_Batch;
import com.example.projecthk1_2023_2024.model.Product;
import com.example.projecthk1_2023_2024.model.ProductBatch;

public class VMDetailNewImp extends Application {
    Pair<String, Product> productPair3;
    Pair<String, ProductBatch> batchPair3;
    Pair<String, Import_Batch> importPair3;

    public VMDetailNewImp(Pair<String, Product> productPair3, Pair<String, ProductBatch> batchPair3, Pair<String, Import_Batch> importPair3) {
        this.productPair3 = productPair3;
        this.batchPair3 = batchPair3;
        this.importPair3 = importPair3;
    }

    public VMDetailNewImp() {
    }

    public Pair<String, Product> getProductPair3() {
        return productPair3;
    }

    public void setProductPair3(Pair<String, Product> productPair3) {
        this.productPair3 = productPair3;
    }

    public Pair<String, ProductBatch> getBatchPair3() {
        return batchPair3;
    }

    public void setBatchPair3(Pair<String, ProductBatch> batchPair3) {
        this.batchPair3 = batchPair3;
    }

    public Pair<String, Import_Batch> getImportPair3() {
        return importPair3;
    }

    public void setImportPair3(Pair<String, Import_Batch> importPair3) {
        this.importPair3 = importPair3;
    }
}