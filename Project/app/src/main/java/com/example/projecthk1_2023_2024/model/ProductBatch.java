package com.example.projecthk1_2023_2024.model;

import com.google.firebase.Timestamp;
import com.google.firebase.firestore.DocumentReference;

import java.util.Date;

public class ProductBatch {
    private int Quantity;
    private Timestamp ExpiryDate;
    private boolean Enable;
    private double ImportPrice;
    private DocumentReference IdProduct;
    private DocumentReference IdShelf;
    private DocumentReference IdBatch;

    public ProductBatch() {
    }

    public ProductBatch(int quantity, Timestamp expiryDate, boolean enable, double importPrice, DocumentReference idProduct, DocumentReference idShelf, DocumentReference idBatch) {
        Quantity = quantity;
        ExpiryDate = expiryDate;
        Enable = enable;
        ImportPrice = importPrice;
        IdProduct = idProduct;
        IdShelf = idShelf;
        IdBatch = idBatch;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public Timestamp getExpiryDate() {
        return ExpiryDate;
    }

    public void setExpiryDate(Timestamp expiryDate) {
        ExpiryDate = expiryDate;
    }

    public boolean isEnable() {
        return Enable;
    }

    public void setEnable(boolean enable) {
        Enable = enable;
    }

    public double getImportPrice() {
        return ImportPrice;
    }

    public void setImportPrice(double importPrice) {
        ImportPrice = importPrice;
    }

    public DocumentReference getIdProduct() {
        return IdProduct;
    }

    public void setIdProduct(DocumentReference idProduct) {
        IdProduct = idProduct;
    }

    public DocumentReference getIdShelf() {
        return IdShelf;
    }

    public void setIdShelf(DocumentReference idShelf) {
        IdShelf = idShelf;
    }

    public DocumentReference getIdBatch() {
        return IdBatch;
    }

    public void setIdBatch(DocumentReference idBatch) {
        IdBatch = idBatch;
    }
}
