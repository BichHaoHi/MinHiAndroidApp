package com.example.projecthk1_2023_2024.Util.ViewModel;

import android.app.Application;
import android.util.Pair;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.projecthk1_2023_2024.model.ImportBatch;
import com.example.projecthk1_2023_2024.model.Product;
import com.example.projecthk1_2023_2024.model.ProductBatch;

public class VMQlsp extends ViewModel {
    private MutableLiveData<ProductBatch> productBatch = new MutableLiveData<>();
    private MutableLiveData<ImportBatch> importBatch = new MutableLiveData<>();

    public MutableLiveData<ProductBatch> getProductBatch() {
        return productBatch;
    }

    public void setProductBatch(MutableLiveData<ProductBatch> productBatch) {
        this.productBatch = productBatch;
    }

    public MutableLiveData<ImportBatch> getImportBatch() {
        return importBatch;
    }

    public void setImportBatch(MutableLiveData<ImportBatch> importBatch) {
        this.importBatch = importBatch;
    }
}