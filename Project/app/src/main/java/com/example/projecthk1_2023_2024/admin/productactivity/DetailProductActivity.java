package com.example.projecthk1_2023_2024.Admin.productactivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Pair;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projecthk1_2023_2024.Admin.adapter.DetailProductAdapter;
import com.example.projecthk1_2023_2024.R;
import com.example.projecthk1_2023_2024.model.ProductBatch;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class DetailProductActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    TextView nameProduct;
    Button back;

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    CollectionReference collectionReference = db.collection("ProductBatch");
    List<Pair<String, ProductBatch>> listProductBatch = new ArrayList<>();
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_sp);
        recyclerView = findViewById(R.id.recyclerViewDTSP);
        nameProduct = findViewById(R.id.detail_sp);
        back = findViewById(R.id.back_detailsp);

        collectionReference.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                for (QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots){
                    String IdDocument = documentSnapshot.getId();
                    ProductBatch productBatch = documentSnapshot.toObject(ProductBatch.class);
                    Pair<String, ProductBatch> productBatchPair = new Pair<>(IdDocument, productBatch);
                    listProductBatch.add(productBatchPair);
                }
                DetailProductAdapter detailProductAdapter = new DetailProductAdapter(DetailProductActivity.this,listProductBatch);
                recyclerView.setLayoutManager(new LinearLayoutManager(DetailProductActivity.this));
                recyclerView.setAdapter(detailProductAdapter);
                recyclerView.getAdapter().notifyDataSetChanged();

            }
        })

    }
}
