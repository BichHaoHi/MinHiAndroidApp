package com.example.projecthk1_2023_2024.model;

import java.util.Date;

public class Import_Batch {
    private String name;
    private Date date;
    private boolean enable;
    private Date date_success;
    private String status_check;// đã sửa
    private String status_import;// đax sửa
    private int quantity_import;// da sua
    private String supplier;
    private String id_user;

    public Import_Batch(int quantity, String name, Date date, boolean enable, Date date_success, String status_check, String status_import, String supplier, String id_user) {
        this.name = name;
        this.quantity_import= quantity;
        this.date = date;
        this.enable = enable;
        this.date_success = date_success;
        this.status_check = status_check;
        this.status_import = status_import;
        this.supplier = supplier;
        this.id_user = id_user;
    }

    public Import_Batch() {
    }

    public int getQuantity_import() {
        return quantity_import;
    }

    public void setQuantity_import(int quantity_import) {
        this.quantity_import = quantity_import;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public Date getDate_success() {
        return date_success;
    }

    public void setDate_success(Date date_success) {
        this.date_success = date_success;
    }

    public String getStatus_check() {
        return status_check;
    }

    public void setStatus_check(String status_check) {
        this.status_check = status_check;
    }

    public String getStatus_import() {
        return status_import;
    }

    public void setStatus_import(String status_import) {
        this.status_import = status_import;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }
}
