package com.example.projecthk1_2023_2024.NvKho.FuncQLSP;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.projecthk1_2023_2024.Admin.adapter.DetailProductAdapter;
import com.example.projecthk1_2023_2024.Admin.productactivity.DetailProductActivity;
import com.example.projecthk1_2023_2024.R;
import com.example.projecthk1_2023_2024.model.ProductBatch;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;
// THuật toán cập nhật kiểm kho: tại ProductBatch lấy IDBatch, quantity( tổng số lượng ) cho 2 ô hiênr thị, HSD tại IDProduct xác định
// Có IDBatch --> ImportBatch lấy NameBatch để hiển thị tại maLo
// lấy được HSD kiêủ tampstime chuyển về định dạng kiểu String và cho hiển thị vào textView
public class DetailProductNVKActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    TextView nameProductTV;
    ImageView back;

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    CollectionReference collectionReferencePB = db.collection("ProductBatch");

    List<Pair<String, ProductBatch>> listProductBatch = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.func4_detail_product_nvk_layout);
        String IdProduct = getIntent().getStringExtra("IdProduct");
        String nameProduct = getIntent().getStringExtra("nameProduct");
        recyclerView = findViewById(R.id.recyclerViewDTSP);
        nameProductTV = findViewById(R.id.detail_sp);
        back = findViewById(R.id.back_detailsp);

        DocumentReference documentReferencePr = db.collection("Product").document(IdProduct);
        nameProductTV.setText(nameProduct);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        collectionReferencePB.whereEqualTo("IDProduct",documentReferencePr)
                .get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        for (QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots){
                            String IdDocument = documentSnapshot.getId();
                            ProductBatch productBatch = documentSnapshot.toObject(ProductBatch.class);
                            Pair<String, ProductBatch> productBatchPair = new Pair<>(IdDocument, productBatch);
                            listProductBatch.add(productBatchPair);
                        }
                        DetailProductNVKAdapter detailProductAdapter = new DetailProductNVKAdapter(DetailProductNVKActivity.this,listProductBatch);
                        recyclerView.setLayoutManager(new LinearLayoutManager(DetailProductNVKActivity.this));
                        recyclerView.setAdapter(detailProductAdapter);
                        recyclerView.getAdapter().notifyDataSetChanged();

                    }
                });

    }
}
