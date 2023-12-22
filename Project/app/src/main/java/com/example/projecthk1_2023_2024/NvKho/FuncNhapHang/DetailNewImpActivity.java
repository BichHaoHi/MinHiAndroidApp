package com.example.projecthk1_2023_2024.NvKho.FuncNhapHang;

import static android.content.ContentValues.TAG;

import java.util.HashMap;
import java.util.Map;
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
import androidx.recyclerview.widget.LinearLayoutManager;
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
    //CollectionReference productBatchRef = db.collection("ProductBatch");

    private List<Map<String, Object>> listDataProduct = new ArrayList();
    private List<Map<String, Object>> listDataProBatch = new ArrayList();

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

        db.collection("ProductBatch")
                .whereEqualTo("IDBatch", idBatch)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                // Lấy dữ liệu từ tài liệu chính
                                String documentId = document.getId();
                                Map<String, Object> dataProBatch = document.getData();
                                Log.d(TAG, "Document ID: " + documentId + ", Data: " + dataProBatch);
                                listDataProBatch.add(dataProBatch);
                                // Lấy subcollection
                                CollectionReference subcollectionRef = document.getReference().collection("Product");
                                subcollectionRef.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                                    @Override
                                    public void onComplete(@NonNull Task<QuerySnapshot> subcollectionTask) {
                                        if (subcollectionTask.isSuccessful()) {
                                            for (QueryDocumentSnapshot subdocument : subcollectionTask.getResult()) {
                                                // Xử lý từng tài liệu trong subcollection
                                                String subdocumentId = subdocument.getId();
                                                Map<String, Object> dataProduct = subdocument.getData();
                                                listDataProduct.add(dataProduct);
                                                Log.d(TAG, "Subdocument ID: " + subdocumentId + ", Subdocument Data: " + dataProduct);

                                                recyclerView.setLayoutManager(new LinearLayoutManager(DetailNewImpActivity.this));
                                                DetailNewImpAdapter adapter = new DetailNewImpAdapter(listDataProBatch, listDataProduct);
                                                recyclerView.setAdapter(adapter);
//                                                adapter.setClickListener((ItemClick) NewImpActivity.this);
                                                recyclerView.getAdapter().notifyDataSetChanged();
                                            }
                                        } else {
                                            Log.d(TAG, "Error getting subcollection documents: ", subcollectionTask.getException());
                                        }
                                    }
                                });
                            }
                        } else {
                            Log.d(TAG, "Error getting documents: ", task.getException());
                        }
                    }
                });


    }


}
