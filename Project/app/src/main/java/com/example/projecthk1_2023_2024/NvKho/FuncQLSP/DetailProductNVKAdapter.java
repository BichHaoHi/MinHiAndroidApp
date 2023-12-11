package com.example.projecthk1_2023_2024.NvKho.FuncQLSP;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projecthk1_2023_2024.Admin.adapter.DetailProductAdapter;
import com.example.projecthk1_2023_2024.MainActivity;
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

    private List<Pair<String, ProductBatch>> listProductBatch;

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

        holder.slht.setText(String.valueOf(productBatchPair.second.getQuantity()));
        holder.slValid.setText(String.valueOf(productBatchPair.second.getQuantity_Valid()));
        holder.exp_date.setText(StampToString(productBatchPair.second.getExpiryDate()));
        productBatchPair.second.getIdDocument(productBatchPair.first, new ProductBatch.MyCallback() {
            @Override
            public void onCallback(String result) {
                holder.maLo.setText(result);
            }
        });

        holder.btn_update.setOnClickListener(v -> {
            // Perform update operation when the confirm button is clicked
            String maLo = listProductBatch.get(position).first;
            int newQuantityValid = Integer.parseInt(holder.slValid.getText().toString());

            // Call the method to update data in Firestore
            updateDataInFirestore(maLo, newQuantityValid, holder.slValid);

            // Close the soft keyboard
            closeSoftKeyboard(holder.slValid);
        });
    }

    @Override
    public int getItemCount() {
        return listProductBatch.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView maLo, slht, exp_date;
        EditText slValid;
        Button btn_update;

        public MyViewHolder(@NonNull View itemView, Context ctx) {
            super(itemView);
            context = ctx;
            maLo = itemView.findViewById(R.id.maLo4);
            exp_date = itemView.findViewById(R.id.hsd4);
            slht = itemView.findViewById(R.id.slht4);// là số lượng đã nhập kho, không quan tâm lên kệ hay chưa
            slValid = itemView.findViewById(R.id.sltt4);// là số lượng khả dụng có thể sử dụng cho hoạt động xuất quantity_valid
            btn_update = itemView.findViewById(R.id.btn_updateQLSP);
        }
    }

    private String StampToString(Timestamp timestamp) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        Date date = timestamp.toDate();
        return dateFormat.format(date);
    }

    private void updateDataInFirestore(String maLo, int newQuantityValid, EditText editText) {
        // Use Firebase Firestore to update data in Firestore
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        CollectionReference collectionReferencePB = db.collection("ProductBatch");

        // Create a reference to the document that needs to be updated
        DocumentReference documentReference = collectionReferencePB.document(maLo);

        // Perform the update operation
        documentReference.update("Quantity_Valid", newQuantityValid)
                .addOnSuccessListener(aVoid -> {
                    // Handle the success of the update operation
                    Toast.makeText(context, "Cập nhật số lượng sản phẩm thành công!!", Toast.LENGTH_SHORT).show();
                    editText.setTextColor(Color.parseColor("#355438"));
                })
                .addOnFailureListener(e -> {
                    // Handle any errors that occurred during the update operation
                    Toast.makeText(context, "Lỗi cập nhật số lượng sản phẩm!!", Toast.LENGTH_SHORT).show();
                });
    }

    private void closeSoftKeyboard(View view) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

}
