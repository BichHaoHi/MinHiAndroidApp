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

import com.example.projecthk1_2023_2024.Admin.AdminHomeActivity;
import com.example.projecthk1_2023_2024.Admin.adapter.ProductAdapter;
import com.example.projecthk1_2023_2024.Admin.productactivity.ProductAdminActivity;
import com.example.projecthk1_2023_2024.NvKho.NvkActivity;
import com.example.projecthk1_2023_2024.NvKho.NvkFragHome;
import com.example.projecthk1_2023_2024.R;
import com.example.projecthk1_2023_2024.Util.ProductListAdd;
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
    private CollectionReference collectionReference = db.collection("Product");
    private List<Pair<String, Product>> listProduct = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nvkho_func4_qlsp_layout);
        recyclerView = findViewById(R.id.recy_phieuSP_f4);
        back = findViewById(R.id.back_home4);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Func_QLSPActivity.this, NvkFragHome.class));
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
                        listProduct.add(productPair);
                    }
                    ProductListAdd proListAd = ProductListAdd.getInstance();
                    proListAd.setProductList(listProduct);
                    recyclerView.setLayoutManager(new LinearLayoutManager(Func_QLSPActivity.this));
                    ProductAdapter adapter = new ProductAdapter(Func_QLSPActivity.this,listProduct);
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
        Intent i = new Intent(Func_QLSPActivity.this, com.example.projecthk1_2023_2024.Admin.productactivity.DetailProductActivity.class);
        i.putExtra("IdProduct",listProduct.get(pos).first);
        i.putExtra("nameProduct",listProduct.get(pos).second.getName());
        startActivity(i);
    }
}
