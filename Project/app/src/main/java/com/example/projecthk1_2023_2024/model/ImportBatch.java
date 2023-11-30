package com.example.projecthk1_2023_2024.model;

import com.google.firebase.Timestamp;
import com.google.firebase.firestore.DocumentReference;

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
}
