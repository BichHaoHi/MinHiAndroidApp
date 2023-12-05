package com.example.projecthk1_2023_2024.Admin.productactivity;

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

import com.example.projecthk1_2023_2024.Admin.FragmentAdmin;
import com.example.projecthk1_2023_2024.R;
import com.example.projecthk1_2023_2024.Util.ProductListAdd;
import com.example.projecthk1_2023_2024.Admin.AdminHomeActivity;
import com.example.projecthk1_2023_2024.Admin.adapter.ProductAdapter;
import com.example.projecthk1_2023_2024.Admin.clickhandler.ItemClick;
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

public class ProductAdminActivity extends AppCompatActivity implements ItemClick {
    RecyclerView recyclerView;
    ImageView back;
    private FirebaseAuth firebaseAuth;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference collectionReference = db.collection("Product");
    private List<Pair<String, Product>> listProduct = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sanpham);
        recyclerView = findViewById(R.id.recyclerViewSP);
        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProductAdminActivity.this, FragmentAdmin.class));
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
                    recyclerView.setLayoutManager(new LinearLayoutManager(ProductAdminActivity.this));
                    ProductAdapter adapter = new ProductAdapter(ProductAdminActivity.this,listProduct);
                    recyclerView.setAdapter(adapter);
                    adapter.setClickListener(ProductAdminActivity.this);
                    recyclerView.getAdapter().notifyDataSetChanged();
                } else {
                    Log.d(TAG, "Error getting documents: ", task.getException());
                }
            }
        });
    }

    @Override
    public void onClick(View v, int pos) {
        Intent i = new Intent(ProductAdminActivity.this,DetailProductActivity.class);
        i.putExtra("IdProduct",listProduct.get(pos).first);
        i.putExtra("nameProduct",listProduct.get(pos).second.getName());
        startActivity(i);
    }
}
