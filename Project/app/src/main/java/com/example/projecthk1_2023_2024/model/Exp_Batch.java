package com.example.projecthk1_2023_2024.model;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;

import org.w3c.dom.Document;

public class Exp_Batch {

    private DocumentReference IdProductBatch;
    private DocumentReference IDExport;
    private int quantity;

    public Exp_Batch(DocumentReference IdProductBatch, DocumentReference IDExport, int quantity) {
        this.IdProductBatch = IdProductBatch;
        this.IDExport = IDExport;
        this.quantity = quantity;
    }

    public Exp_Batch() {
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public DocumentReference getIdProductBatch() {
        return IdProductBatch;
    }

    public void setIdProductBatch(DocumentReference IdProductBatch) {
        this.IdProductBatch = IdProductBatch;
    }

    public DocumentReference getIDExport() {
        return IDExport;
    }

    public void setIDExport(DocumentReference IDExport){
        this.IDExport = IDExport;
    }
    public Product getProduct(DocumentReference IdProductBatch){
        final Product[] product = {new Product()};
        IdProductBatch.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()){
                    product[0] = documentSnapshot.toObject(Product.class);
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });
        return product[0];
    }
}
