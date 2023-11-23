package com.example.projecthk1_2023_2024.model;

import com.google.firebase.Timestamp;
import com.google.firebase.firestore.DocumentReference;

import java.util.Date;

public class Import_Batch {
    private Timestamp Date;
    private boolean Enable;
    private Timestamp Date_success;
    private String Status;
    private int Quantity_import;
    private String Supplier;
    private DocumentReference IdUser;

    public Import_Batch() {
    }

    public Import_Batch(Timestamp date, boolean enable, Timestamp date_success, String status, int quantity_import, String supplier, DocumentReference idUser) {
        Date = date;
        Enable = enable;
        Date_success = date_success;
        Status = status;
        Quantity_import = quantity_import;
        Supplier = supplier;
        IdUser = idUser;
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

    public void setIdUser(DocumentReference idUser) {
        IdUser = idUser;
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

    public DocumentReference getIdUser() {
        return IdUser;
    }
}
