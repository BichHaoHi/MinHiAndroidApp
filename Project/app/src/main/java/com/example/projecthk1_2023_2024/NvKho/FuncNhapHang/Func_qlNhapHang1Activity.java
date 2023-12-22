package com.example.projecthk1_2023_2024.NvKho.FuncNhapHang;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projecthk1_2023_2024.Admin.activityuser.AddUserActivity;
import com.example.projecthk1_2023_2024.Admin.clickhandler.ItemClick;
import com.example.projecthk1_2023_2024.R;
import com.example.projecthk1_2023_2024.Util.ListImportBatch;
import com.example.projecthk1_2023_2024.model.ImportBatch;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class Func_qlNhapHang1Activity extends AppCompatActivity implements ItemClick {
    Context context;
    RecyclerView recyclerView;
    ImageView back;
    ImageButton btnNewImp;
    private FirebaseAuth firebaseAuth;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference collectionReferenceIB = db.collection("ImportBatch");
    private List<Pair<String, ImportBatch>> listImpBatch = new ArrayList<>();
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nvkho_func3_qlnhapkho_layout);
        recyclerView = findViewById(R.id.dspn);
        back = findViewById(R.id.back3);
        btnNewImp = findViewById(R.id.btnNewImp);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        btnNewImp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Func_qlNhapHang1Activity.this, NewImpActivity.class));
            }
        });

        collectionReferenceIB.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        String IdDocument = document.getId();
                        ImportBatch imp = document.toObject(ImportBatch.class);
                        Pair<String, ImportBatch> impPair = new Pair<>(IdDocument, imp);
                        listImpBatch.add(impPair);
                    }
                    ListImportBatch listImp = ListImportBatch.getInstance();
                    listImp.setListImportBatch(listImpBatch);
                    recyclerView.setLayoutManager(new LinearLayoutManager(Func_qlNhapHang1Activity.this));
                    ListImp1Adapter adapter = new ListImp1Adapter(Func_qlNhapHang1Activity.this,listImpBatch);
                    recyclerView.setAdapter(adapter);
                    adapter.setClickListener(Func_qlNhapHang1Activity.this);
                    recyclerView.getAdapter().notifyDataSetChanged();
                } else {
                    Toast.makeText(context, "No able get data", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    public void onClick(View v, int pos) {

    }

}