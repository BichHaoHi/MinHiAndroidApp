package com.example.projecthk1_2023_2024.NvKho.FuncQLSP;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.example.projecthk1_2023_2024.Admin.adapter.DetailProductAdapter;
import com.example.projecthk1_2023_2024.R;
import com.example.projecthk1_2023_2024.model.ImportBatch;
import com.example.projecthk1_2023_2024.model.ProductBatch;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class DetailProductNVKAdapter extends RecyclerView.Adapter<DetailProductNVKAdapter.MyViewHolder> {
    Context context;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    CollectionReference collectionReferenceIB = db.collection("ImportBatch");

    private List<Pair<String, ProductBatch>> listProductBatch;
    private List<Pair<String, ImportBatch>> listImportBatch = new ArrayList<>();

    public DetailProductNVKAdapter(Context context, List<Pair<String, ProductBatch>> listProductBatch){
        this.context = context;
        this.listProductBatch = listProductBatch;
    }

    @NonNull
    @Override
    public DetailProductNVKAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.func4_item_detail_product_nvk,parent,false);
        return new DetailProductNVKAdapter.MyViewHolder(view,context);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Pair<String, ProductBatch> productBatchPair = listProductBatch.get(position);
        DocumentReference idBatchRef = productBatchPair.second.getIDBatch();

        holder.slht.setText(String.valueOf(productBatchPair.second.getQuantity()));
        holder.slValid.setText(String.valueOf(productBatchPair.second.getQuantity_Valid()));
        holder.exp_date.setText(StampToString(productBatchPair.second.getExpiryDate()));

        collectionReferenceIB.get()
        .addOnSuccessListener(queryDocumentSnapshots -> {
        for (QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots) {
            // Lấy đường dẫn của mỗi document
            String documentPath = documentSnapshot.getReference().getPath();

            // So sánh với DocumentReference idBatchReference
            if (documentSnapshot.getReference().equals(idBatchRef)) {
                String IdDocumentIB = documentSnapshot.getId();
                ImportBatch impBatch = documentSnapshot.toObject(ImportBatch.class);
                Pair<String, ImportBatch> impBatchPair = new Pair<>(IdDocumentIB, impBatch);
                listImportBatch.add(impBatchPair);
            }
        }

    })
            .addOnFailureListener(e -> {
        Log.e("Firestore Query", "Error getting documents: " + e.getMessage());
    });
        Pair<String, ImportBatch> impBatchPair = listImportBatch.get(position);
        holder.maLo.setText(impBatchPair.second.getNameBatch());
    }

    @Override
    public int getItemCount() {
        return listProductBatch.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView maLo, slht, exp_date;
        EditText slValid;


        public MyViewHolder(@NonNull View itemView, Context ctx) {
            super(itemView);
            context = ctx;
            maLo = itemView.findViewById(R.id.maLo4);
            exp_date = itemView.findViewById(R.id.hsd4);
            slht = itemView.findViewById(R.id.slht4);// là số lượng đã nhập kho, không quan tâm lên kệ hay chưa
            slValid = itemView.findViewById(R.id.sltt4);// là số lượng khả dụng có thể sử dụng cho hoạt động xuất quantity_valid

//            slValid.setOnFocusChangeListener((v, hasFocus) -> {
//                if (hasFocus) {
//                    // Mở bàn phím khi ô EditText được chọn
//                    InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
//                    imm.showSoftInput(slValid, InputMethodManager.SHOW_IMPLICIT);
//                }
//            });
        }
    }

    private String StampToString(Timestamp timestamp) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        Date date = timestamp.toDate();
        return dateFormat.format(date);
    }

}
