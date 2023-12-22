package com.example.projecthk1_2023_2024.NvKho.FuncNhapHang;

import static com.google.android.material.color.utilities.MaterialDynamicColors.error;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.projecthk1_2023_2024.Admin.activityuser.UserDetailActivity;
import com.example.projecthk1_2023_2024.Admin.clickhandler.ItemClick;
import com.example.projecthk1_2023_2024.R;
import com.example.projecthk1_2023_2024.Util.ListImportBatch;
import com.example.projecthk1_2023_2024.model.ImportBatch;
import com.example.projecthk1_2023_2024.model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;

public class NewImpActivity extends AppCompatActivity implements ItemClick{
    Context context;
    RecyclerView recyclerView;
    ImageView back;
    SearchView search;
    ListImp1Adapter adapter;

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    CollectionReference importBatchRef = db.collection("ImportBatch");
    private List<Pair<String, ImportBatch>> listNewImpBatch = new ArrayList<>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.f3_new_imp_layout);
        recyclerView = findViewById(R.id.dspnMoi1);
        back = findViewById(R.id.back31);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        importBatchRef.whereEqualTo("Status", "Waiting")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                String importBatchId = document.getId();
                                ImportBatch importBatch = document.toObject(ImportBatch.class);
                                Pair<String, ImportBatch> impPair = new Pair<>(importBatchId, importBatch);
                                listNewImpBatch.add(impPair);
                            }

                            recyclerView.setLayoutManager(new LinearLayoutManager(NewImpActivity.this));
                            ListImp1Adapter adapter = new ListImp1Adapter(NewImpActivity.this, listNewImpBatch);
                            recyclerView.setAdapter(adapter);
                            adapter.setClickListener((ItemClick) NewImpActivity.this);
                            recyclerView.getAdapter().notifyDataSetChanged();

                        } else {
                            // Xử lý khi có lỗi xảy ra
                            Exception e = task.getException();
                            if (e != null) {
                                Log.e("Firestore", "Error getting documents: " + e.getMessage());
                            }
                        }
                    }
        });

        ///
        search = findViewById(R.id.searchPNnew);
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
                for(Pair<String, ImportBatch> product: listNewImpBatch){
                    if(removeDiacritics(product.second.getSupplier().toLowerCase()).contains(searchTextWithoutDiacritics)
                            ||
                            removeDiacritics(product.first).equals(searchTextWithoutDiacritics)
                    ){
                        filtedList.add(product);
                    }

                }
                if(filtedList.isEmpty() == true && text.isEmpty() == false){
                    adapter.setFilterList(NewImpActivity.this, new ArrayList<>());
                }
                else {
                    adapter.setFilterList(NewImpActivity.this, filtedList);
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
        Pair<String, ImportBatch> ImpPair = listNewImpBatch.get(pos);
        Intent i = new Intent(this, DetailNewImpActivity.class);
        i.putExtra("IdBatch", listNewImpBatch.get(pos).first);
        startActivity(i);
    }


}
