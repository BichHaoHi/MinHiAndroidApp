package com.example.projecthk1_2023_2024.NvKho.FuncQLSP;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projecthk1_2023_2024.NvKho.NvkFragHome;
import com.example.projecthk1_2023_2024.R;
import com.example.projecthk1_2023_2024.Util.ProListAd;
import com.example.projecthk1_2023_2024.Util.QLSP;
import com.example.projecthk1_2023_2024.Util.ViewModel.VMQlsp;
import com.example.projecthk1_2023_2024.admin.AdminActivity;
import com.example.projecthk1_2023_2024.admin.adapter.ProductAdapter;
import com.example.projecthk1_2023_2024.admin.clickhandler.ItemClick;
import com.example.projecthk1_2023_2024.admin.productactivity.ProductAdminActivity;
import com.example.projecthk1_2023_2024.model.Product;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
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
    private CollectionReference collectionReferenceProduct = db.collection("Product");
    private CollectionReference collectionReferenceBatch = db.collection("ProductBatch");

    private List<VMQlsp> listPr = new ArrayList<>();// ??

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sanpham);
        recyclerView = findViewById(R.id.recyclerViewSP);
        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Func_QLSPActivity.this, AdminActivity.class));
            }
        });
        collectionReference.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        String IdDocument = document.getId();
                        Product product = document.toObject(Product.class);
                        Pair<String, Product> productPair = new Pair<>(IdDocument,product);
                        listPr.add(productPair);
                    }
                    ProListAd proListAd = ProListAd.getInstance();
                    proListAd.setProductList(listProduct);
                    recyclerView.setLayoutManager(new LinearLayoutManager(Func_QLSPActivity.this));
                    QLSPAdapter adapter = new QLSPAdapter(Func_QLSPActivity.this, listPr);
                    recyclerView.setAdapter(adapter);
                    adapter.setClickListener(Func_QLSPActivity.this);
                    recyclerView.getAdapter().notifyDataSetChanged();
                } else {
                    Log.d(TAG, "Error getting documents: ", task.getException());
                }
            }
        });
    }

    @Override
    public void onClick(View v, int pos) {

    }
}
