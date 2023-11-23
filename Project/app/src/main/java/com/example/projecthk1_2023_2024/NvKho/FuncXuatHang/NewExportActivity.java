package com.example.projecthk1_2023_2024.NvKho.FuncXuatHang;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.projecthk1_2023_2024.R;
import com.example.projecthk1_2023_2024.Util.ViewModel.VMNewExport;
import com.example.projecthk1_2023_2024.Admin.clickhandler.ItemClick;
import com.example.projecthk1_2023_2024.model.Export;
import com.example.projecthk1_2023_2024.model.Product;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class NewExportActivity extends AppCompatActivity implements ItemClick {
    RecyclerView recycler;
    private CollectionReference collectionReference = FirebaseFirestore.getInstance().collection("Export");
    private FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
    private List<VMNewExport> listNewExp = new ArrayList<>();


    @SuppressLint("MissingInflatedId")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nvkho_func2_qlxkho_layout);
        recycler = findViewById(R.id.dspxMoi);
        collectionReference.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        String IdDocument = document.getId();
                        Export exp = document.toObject(Export.class);
                        Product product = document.toObject(Product.class);
                        NewExportAdapter adapter = new NewExportAdapter(NewExportActivity.this, listNewExp);
                        //adapter.sortStatus();
                        recycler.setLayoutManager(new LinearLayoutManager(NewExportActivity.this));
                        recycler.setAdapter(adapter);
                        recycler.getAdapter().notifyDataSetChanged();
                    }
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
