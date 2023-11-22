package com.example.projecthk1_2023_2024.model;

import java.util.Date;

public class ProductBatch {
    private String id_product;
    private int quantity;
    private Date expride_date;
    private boolean enable;
    private double imp_price;
    private String id_sheft;

    public ProductBatch(String id_product, int quantity, Date expride_date, boolean enable, double imp_price, String id_sheft) {
        this.id_product = id_product;
        this.quantity = quantity;
        this.expride_date = expride_date;
        this.enable = enable;
        this.imp_price = imp_price;
        this.id_sheft = id_sheft;
    }

    public String getId_product() {
        return id_product;
    }

    public void setId_product(String id_product) {
        this.id_product = id_product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getExpride_date() {
        return expride_date;
    }

    public void setExpride_date(Date expride_date) {
        this.expride_date = expride_date;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public double getImp_price() {
        return imp_price;
    }

    public void setImp_price(double imp_price) {
        this.imp_price = imp_price;
    }

    public String getId_sheft() {
        return id_sheft;
    }

    public void setId_sheft(String id_sheft) {
        this.id_sheft = id_sheft;
    }
}
