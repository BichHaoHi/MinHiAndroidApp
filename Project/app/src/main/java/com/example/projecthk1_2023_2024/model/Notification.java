package com.example.projecthk1_2023_2024.model;

import androidx.databinding.BaseObservable;

import com.google.firebase.Timestamp;
import com.google.firebase.firestore.DocumentReference;

public class Notification extends BaseObservable {
    private Timestamp Date_Create;
    private String Description;
    private Boolean Enable;
    private DocumentReference IDProductBatch;
    private DocumentReference IDProduct;
    private DocumentReference IDExport;
    private DocumentReference IDImport;
    private Boolean Role;

    public Notification() {
    }

    public Notification(Timestamp Date_Create, String Description, Boolean Enable, DocumentReference IDProductBatch, DocumentReference IDProduct, DocumentReference IDExport, DocumentReference IDImport, Boolean Role) {
        this.Date_Create = Date_Create;
        this.Description = Description;
        this.Enable = Enable;
        this.IDProductBatch = IDProductBatch;
        this.IDProduct = IDProduct;
        this.IDExport = IDExport;
        this.IDImport = IDImport;
        this.Role = Role;
    }

    public Timestamp getDate_Create() {
        return Date_Create;
    }

    public void setDate_Create(Timestamp date_Create) {
        Date_Create = date_Create;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Boolean getEnable() {
        return Enable;
    }

    public void setEnable(Boolean enable) {
        Enable = enable;
    }

    public DocumentReference getIDProductBatch() {
        return IDProductBatch;
    }

    public void setIDProductBatch(DocumentReference IDProductBatch) {
        this.IDProductBatch = IDProductBatch;
    }

    public DocumentReference getIDProduct() {
        return IDProduct;
    }

    public void setIDProduct(DocumentReference IDProduct) {
        this.IDProduct = IDProduct;
    }

    public DocumentReference getIDExport() {
        return IDExport;
    }

    public void setIDExport(DocumentReference IDExport) {
        this.IDExport = IDExport;
    }

    public DocumentReference getIDImport() {
        return IDImport;
    }

    public void setIDImport(DocumentReference IDImport) {
        this.IDImport = IDImport;
    }

    public Boolean getRole() {
        return Role;
    }

    public void setRole(Boolean role) {
        Role = role;
    }

    public DocumentReference getValidReference(){
        if (IDExport != null){
            return IDExport;
        } else if (IDImport != null) {
            return IDImport;
        } else if (IDProduct != null){
            return IDProduct;
        } else return IDProductBatch;
    }
}
