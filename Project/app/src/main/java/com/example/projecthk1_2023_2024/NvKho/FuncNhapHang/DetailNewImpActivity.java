package com.example.projecthk1_2023_2024.NvKho.FuncNhapHang;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projecthk1_2023_2024.model.ProductBatch;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import com.example.projecthk1_2023_2024.Admin.clickhandler.ItemClick;
import com.example.projecthk1_2023_2024.R;
import com.example.projecthk1_2023_2024.model.ImportBatch;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class DetailNewImpActivity extends AppCompatActivity{
    Context context;
    RecyclerView recyclerView;
    ImageView back;

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    CollectionReference importBatchRef = db.collection("ImportBatch");
    CollectionReference productBatchRef = db.collection("ProductBatch");

    private List<Pair<String, ImportBatch>> listNewImpBatch = new ArrayList<>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nvk_f3_detail_imp_layout);
        recyclerView = findViewById(R.id.ctpn);
        back = findViewById(R.id.back32);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        Intent intent = getIntent();
        String idBatch = null;
        if (intent != null) {
            idBatch = intent.getStringExtra("IdBatch");
            // Bây giờ bạn có thể sử dụng idBatch theo nhu cầu của mình
            // Ví dụ: hiển thị trong Log
            Log.d("DetailNewImpActivity", "IdBatch: " + idBatch);
        }
        else
            Log.d("Lỗi: ", "Không lấy đc idBatch");
        productBatchRef.whereEqualTo("idBatch", idBatch)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                ProductBatch productBatch = document.toObject(ProductBatch.class);

                                // Tiếp tục truy vấn Product dựa trên idProduct
                                String idProduct = productBatch.getIdProduct();
                                queryProduct(idProduct);
                            }
                        } else {
                            Log.d(TAG, "Error getting documents: ", task.getException());
                        }
                    }
                });

    }


}
