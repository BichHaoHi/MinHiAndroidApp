package com.example.projecthk1_2023_2024.NvKho.FuncNhapHang;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projecthk1_2023_2024.Admin.clickhandler.ItemClick;
import com.example.projecthk1_2023_2024.NvKho.FuncQLSP.Func_QLSPActivity;
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

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;

public class Func_qlNhapHang1Activity extends AppCompatActivity implements ItemClick {
    Context context;
    RecyclerView recyclerView;
    ImageView back;
    ImageButton btnNewImp;
    ListImp1Adapter adapter;
    SearchView search;
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
                    adapter = new ListImp1Adapter(Func_qlNhapHang1Activity.this,listImpBatch);
                    recyclerView.setAdapter(adapter);
                    adapter.setClickListener(Func_qlNhapHang1Activity.this);
                    recyclerView.getAdapter().notifyDataSetChanged();
                } else {
                    Toast.makeText(context, "No able get data", Toast.LENGTH_SHORT).show();
                }
            }
        });

        ///
        search = findViewById(R.id.searchPN);
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
                List<Pair<String, ImportBatch>> filtedList = new ArrayList<>();
                String searchTextWithoutDiacritics = removeDiacritics(text.toLowerCase());
                for(Pair<String, ImportBatch> product: listImpBatch){
                    if(removeDiacritics(product.second.getStatus().toLowerCase()).contains(searchTextWithoutDiacritics) ||
                            removeDiacritics(product.second.getSupplier().toLowerCase()).contains(searchTextWithoutDiacritics)
                            ||
                            removeDiacritics(product.first).equals(searchTextWithoutDiacritics)
                    ){
                        filtedList.add(product);
                    }

                }
                if(filtedList.isEmpty() == true && text.isEmpty() == false){
                    adapter.setFilterList(Func_qlNhapHang1Activity.this, new ArrayList<>());
                }
                else {
                    adapter.setFilterList(Func_qlNhapHang1Activity.this, filtedList);
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

    }

}