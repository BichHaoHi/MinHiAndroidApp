package com.example.projecthk1_2023_2024.Admin.importactivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Pair;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projecthk1_2023_2024.Admin.AdminHomeActivity;
import com.example.projecthk1_2023_2024.Admin.FragmentAdmin;
import com.example.projecthk1_2023_2024.Admin.adapter.ImportAdapter;
import com.example.projecthk1_2023_2024.Admin.clickhandler.ItemClick;
import com.example.projecthk1_2023_2024.Admin.productactivity.ProductAdminActivity;
import com.example.projecthk1_2023_2024.R;
import com.example.projecthk1_2023_2024.model.ImportBatch;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class ImportHomeActivity extends AppCompatActivity implements ItemClick {
    RecyclerView recyclerView;
    EditText edtSearch;
    ImageButton search;
    ImageView back;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference collectionReference = db.collection("ImportBatch");
    private List<Pair<String, ImportBatch>> listImport = new ArrayList<>();


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nvkho_func3_qlnhapkho_layout);
        recyclerView = findViewById(R.id.dspxMoi);
        search = findViewById(R.id.ic_search);
        edtSearch = findViewById(R.id.func_search);
        back = findViewById(R.id.back_home);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ImportHomeActivity.this, FragmentAdmin.class));
            }
        });
        collectionReference.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                for (QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots){
                    String idDocument = documentSnapshot.getId();
                    ImportBatch importBatch = documentSnapshot.toObject(ImportBatch.class);
                    Pair<String, ImportBatch> importBatchPair = new Pair<>(idDocument,importBatch);
                    listImport.add(importBatchPair);
                }
                recyclerView.setLayoutManager(new LinearLayoutManager(ImportHomeActivity.this));
                ImportAdapter importAdapter = new ImportAdapter(ImportHomeActivity.this, listImport);
                recyclerView.setAdapter(importAdapter);
                importAdapter.setClickListener(ImportHomeActivity.this);
                recyclerView.getAdapter().notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onClick(View v, int pos) {
        Intent i = new Intent(ImportHomeActivity.this, DetailImportActivity.class);
        i.putExtra("IdImport",listImport.get(pos).first);
        startActivity(i);
    }
}
