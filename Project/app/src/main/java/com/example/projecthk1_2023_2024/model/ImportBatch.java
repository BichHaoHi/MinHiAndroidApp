package com.example.projecthk1_2023_2024.model;

import android.util.Pair;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class ImportBatch {
    private Timestamp Date;
    private boolean Enable;
    private Timestamp Date_success;
    private String Status;
    private int Quantity_import;
    private String Supplier;
    private DocumentReference IDUser;

    public ImportBatch() {
    }

    public ImportBatch(Timestamp Date, boolean Enable, Timestamp Date_success, String Status, int Quantity_import, String Supplier, DocumentReference IDUser) {
        this.Date = Date;
        this.Enable = Enable;
        this.Date_success = Date_success;
        this.Status = Status;
        this.Quantity_import = Quantity_import;
        this.Supplier = Supplier;
        this.IDUser = IDUser;
    }

    public void setDate(Timestamp date) {
        Date = date;
    }

    public void setEnable(boolean enable) {
        Enable = enable;
    }

    public void setDate_success(Timestamp date_success) {
        Date_success = date_success;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public void setQuantity_import(int quantity_import) {
        Quantity_import = quantity_import;
    }

    public void setSupplier(String supplier) {
        Supplier = supplier;
    }

    public void setIDUser(DocumentReference IDUser) {
        IDUser = IDUser;
    }

    public Timestamp getDate() {
        return Date;
    }

    public boolean isEnable() {
        return Enable;
    }

    public Timestamp getDate_success() {
        return Date_success;
    }

    public String getStatus() {
        return Status;
    }

    public int getQuantity_import() {
        return Quantity_import;
    }

    public String getSupplier() {
        return Supplier;
    }

    public DocumentReference getIDUser() {
        return IDUser;
    }
    public List<Pair<String, ProductBatch>> getDetailImport(String id){
        List<Pair<String, ProductBatch>> results = new ArrayList<>();
        DocumentReference documentReference =  FirebaseFirestore.getInstance().collection("ImportBatch").document(id);
        FirebaseFirestore.getInstance().collection("ProductBatch").whereEqualTo("IDBatch",documentReference)
                .get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        for (QueryDocumentSnapshot snapshot : queryDocumentSnapshots){
                            String idDocument = snapshot.getId();
                            ProductBatch productBatch = snapshot.toObject(ProductBatch.class);
                            Pair<String, ProductBatch> productBatchPair = new Pair<>(idDocument,productBatch);
                            results.add(productBatchPair);
                        }
                    }
                });
        return results;
    }
}
