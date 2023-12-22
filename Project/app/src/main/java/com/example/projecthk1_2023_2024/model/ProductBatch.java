package com.example.projecthk1_2023_2024.model;

import android.util.Log;
import android.util.Pair;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductBatch {
    private int Quantity;
    private int Quantity_Valid;
    private Timestamp ExpiryDate;
    private boolean Enable;
    private double ImportPrice;
    private DocumentReference IDProduct;
    private DocumentReference IDShelf;
    private DocumentReference IDBatch;

    public ProductBatch() {
    }

    public ProductBatch(int Quantity,int Quantity_Valid ,Timestamp ExpiryDate, boolean Enable, double ImportPrice, DocumentReference IDProduct, DocumentReference IDShelf, DocumentReference IDBatch) {
        this.Quantity = Quantity;
        this.Quantity_Valid = Quantity_Valid;
        this.ExpiryDate = ExpiryDate;
        this.Enable = Enable;
        this.ImportPrice = ImportPrice;
        this.IDProduct = IDProduct;
        this.IDShelf = IDShelf;
        this.IDBatch = IDBatch;
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

    public DocumentReference getIDProduct() {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        CollectionReference collectionRef = db.collection("ProductBatch");

        collectionRef.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {

            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        DocumentReference idProductReference = (DocumentReference) document.get("IDProduct");

                        if (idProductReference != null) {
                            // Lấy ID của idProduct từ DocumentReference
                            String idProduct = idProductReference.getId();
                            Log.d("Firestore", "idProduct: " + idProduct);
                        }
                    }
                } else {
                    Log.d("Firestore", "Error getting documents: ", task.getException());
                }
            }
        });

        return IDProduct;
    }

    public void setIDProduct(DocumentReference IDProduct) {
        this.IDProduct = IDProduct;
    }

    public DocumentReference getIDShelf() {
        return IDShelf;
    }

    public void setIDShelf(DocumentReference IDShelf) {
        this.IDShelf = IDShelf;
    }

    public DocumentReference getIDBatch() {
        return IDBatch;
    }

    public void setIDBatch(DocumentReference IDBatch) {
        this.IDBatch = IDBatch;
    }

    public int getQuantity_Valid() {
        return Quantity_Valid;
    }

    public void setQuantity_Valid(int quantity_Valid) {
        Quantity_Valid = quantity_Valid;
    }
    public void getIdDocument(String id, final MyCallback myCallback) {
        FirebaseFirestore.getInstance().collection("ProductBatch").document(id)
                .get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if (documentSnapshot.exists()) {
                            DocumentReference idBatch = documentSnapshot.getDocumentReference("IDBatch");
                            idBatch.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                                @Override
                                public void onSuccess(DocumentSnapshot documentSnapshot) {
                                    String result = documentSnapshot.getId();
                                    myCallback.onCallback(result);
                                }
                            });
                        } else {
                            // Handle the case where the document does not exist
                        }
                    }
                });
    }

    // Define a callback interface
    public interface MyCallback {
        void onCallback(String result);
    }

}
