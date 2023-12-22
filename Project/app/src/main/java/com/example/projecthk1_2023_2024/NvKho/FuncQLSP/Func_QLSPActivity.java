package com.example.projecthk1_2023_2024.NvKho.FuncQLSP;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import android.annotation.SuppressLint;
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

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;

public class Func_QLSPActivity extends AppCompatActivity implements ItemClick {
    RecyclerView recyclerView;
    ImageView back;
    SearchView search;
    private FirebaseAuth firebaseAuth;
    QLSPAdapter adapter;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference collectionReference = db.collection("Product");
    private List<Pair<String, Product>> listProduct = new ArrayList<>();

    @SuppressLint("MissingInflatedId")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nvkho_func4_qlsp_layout);
        recyclerView = findViewById(R.id.recy_phieuSP_f4);
        back = findViewById(R.id.back_home4);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        search = findViewById(R.id.searchSP);

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
                    adapter = new QLSPAdapter(Func_QLSPActivity.this,listProduct);
                    recyclerView.setAdapter(adapter);
                    adapter.setClickListener(Func_QLSPActivity.this);
                    recyclerView.getAdapter().notifyDataSetChanged();
                } else {
                    Log.d(TAG, "Error getting documents: ", task.getException());
                }
            }
        });
// Search
        search.clearFocus();
        recyclerView.setHasFixedSize(true);
        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);
                return true;
            }

            private void filterList(String text) {
                List<Pair<String, Product>> filtedList = new ArrayList<>();
                String searchTextWithoutDiacritics = removeDiacritics(text.toLowerCase());
                for(Pair<String, Product> product: listProduct){
                    if(removeDiacritics(product.second.getName().toLowerCase()).contains(searchTextWithoutDiacritics)){
                        filtedList.add(product);
                    }

                }
                if(filtedList.isEmpty() == true && text.isEmpty() == false){
                    adapter.setFilterList(Func_QLSPActivity.this, new ArrayList<>());
                }
                else {
                    adapter.setFilterList(Func_QLSPActivity.this, filtedList);
                }
            }

            public String removeDiacritics(String input) {
                String normalized = Normalizer.normalize(input, Normalizer.Form.NFD);
                return normalized.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
            }



        });



    }

    @Override
    public void onClick(View v, int pos) {
        Intent i = new Intent(Func_QLSPActivity.this, DetailProductNVKActivity.class);
        i.putExtra("IdProduct",listProduct.get(pos).first);
        i.putExtra("nameProduct",listProduct.get(pos).second.getName());
        startActivity(i);
    }
}
