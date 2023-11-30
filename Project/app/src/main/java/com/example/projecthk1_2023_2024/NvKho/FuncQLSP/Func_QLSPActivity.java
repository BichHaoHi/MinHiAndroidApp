package com.example.projecthk1_2023_2024.NvKho.FuncQLSP;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projecthk1_2023_2024.NvKho.NvkActivity;
import com.example.projecthk1_2023_2024.R;
import com.example.projecthk1_2023_2024.Util.ViewModel.VMQlsp;
import com.example.projecthk1_2023_2024.Admin.clickhandler.ItemClick;
import com.example.projecthk1_2023_2024.model.Product;
import com.example.projecthk1_2023_2024.model.ProductBatch;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class Func_QLSPActivity extends AppCompatActivity implements ItemClick {
    RecyclerView recyclerView;
    ImageView back;
    private FirebaseAuth firebaseAuth;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference CRefBatch = db.collection("ProductBatch");
//    private List<VMQlsp> listPr = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nvkho_func4_qlsp_layout);
        recyclerView = findViewById(R.id.recy_phieuSP_f4);
        back = findViewById(R.id.back_home4);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Func_QLSPActivity.this, NvkActivity.class));
            }
        });
//        CRefBatch.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                if (task.isSuccessful()) {
//                    for (QueryDocumentSnapshot document : task.getResult()) {
//                        String idDocBatch = document.getId();
//                        ProductBatch batch = document.toObject(ProductBatch.class);
//                        String idProduct = batch.getId_product();
//
//                        if (idProduct != null) {
//                            CollectionReference CRefProduct = db.collection("Product");
//                            CRefProduct.document(idProduct).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                                @Override
//                                public void onSuccess(DocumentSnapshot ProductDocument) {
//                                    Product product = ProductDocument.toObject(Product.class);
//                                    Pair<String, Product> productPair = new Pair<>(idProduct, product);
//                                    Pair<String, ProductBatch> batchPair = new Pair<>(idDocBatch, batch);
//                                    VMQlsp dssp = new VMQlsp(productPair, batchPair);
//
//                                    listPr.add(dssp);
//
//                                    if (listPr.size() == task.getResult().size()) {
//                                        setupRecyclerView();
//                                    }
//                                }
//                            });
//                        } else {
//                            Log.e(TAG, "idProduct is null");
//                        }
//                    }
//                } else {
//                    Log.d(TAG, "Error getting documents: ", task.getException());
//                }
//            }
//        });
    }

    @Override
    public void onClick(View v, int pos) {

    }

    private void setupRecyclerView() {
        LinearLayoutManager llm = new LinearLayoutManager(Func_QLSPActivity.this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);

//        QLSPAdapter adapter = new QLSPAdapter(Func_QLSPActivity.this, listPr);
//        recyclerView.setAdapter(adapter);
//        adapter.setClickListener(Func_QLSPActivity.this);
//        adapter.notifyDataSetChanged();
    }
}
