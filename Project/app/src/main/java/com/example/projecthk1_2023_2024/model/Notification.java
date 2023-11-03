package com.example.projecthk1_2023_2024.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.google.firebase.Timestamp;

public class Notification extends BaseObservable {
    private Timestamp Date_Create;
    private String Description;
    private Boolean Enable;
    private String IDBatch;
    private String IDExport;
    private String IDImport;

    public Notification() {
    }

    public Notification(Timestamp date_Create, String description, Boolean enable, String IDBatch, String IDExport, String IDImport) {
        Date_Create = date_Create;
        Description = description;
        Enable = enable;
        this.IDBatch = IDBatch;
        this.IDExport = IDExport;
        this.IDImport = IDImport;
    }

    @Bindable
    public Timestamp getDate_Create() {
        return Date_Create;
    }

    public void setDate_Create(Timestamp date_Create) {
        Date_Create = date_Create;
    }
    @Bindable
    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
    @Bindable
    public Boolean getEnable() {
        return Enable;
    }

    public void setEnable(Boolean enable) {
        Enable = enable;
    }
    @Bindable
    public String getIDBatch() {
        return IDBatch;
    }

    public void setIDBatch(String IDBatch) {
        this.IDBatch = IDBatch;
    }
    @Bindable
    public String getIDExport() {
        return IDExport;
    }

    public void setIDExport(String IDExport) {
        this.IDExport = IDExport;
    }
    @Bindable
    public String getIDImport() {
        return IDImport;
    }

    public void setIDImport(String IDImport) {
        this.IDImport = IDImport;
    }
}
