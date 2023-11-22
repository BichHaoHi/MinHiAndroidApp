package com.example.projecthk1_2023_2024.model;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;

import org.w3c.dom.Document;

public class Exp_Batch {

    private DocumentReference id_batch;
    private DocumentReference id_exp;
    private int quantity;

    public Exp_Batch(DocumentReference id_batch, DocumentReference id_exp, int quantity) {
        this.id_batch = id_batch;
        this.id_exp = id_exp;
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

    public DocumentReference getId_batch() {
        return id_batch;
    }

    public void setId_batch(DocumentReference id_batch) {
        this.id_batch = id_batch;
    }

    public DocumentReference getId_exp() {
        return id_exp;
    }

    public void setId_exp(DocumentReference id_exp){
        this.id_exp = id_exp;
    }
    public Product getProduct(DocumentReference id_batch){
        final Product[] product = {new Product()};
        id_batch.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
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
