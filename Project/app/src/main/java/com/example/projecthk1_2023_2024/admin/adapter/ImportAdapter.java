package com.example.projecthk1_2023_2024.Admin.adapter;

import android.content.Context;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projecthk1_2023_2024.Admin.clickhandler.ItemClick;
import com.example.projecthk1_2023_2024.R;
import com.example.projecthk1_2023_2024.model.ImportBatch;

import java.util.List;

public class ImportAdapter extends RecyclerView.Adapter<ImportAdapter.MyViewHolder> {

    Context context;
    ItemClick itemClick;
    List<Pair<String, ImportBatch>> listImport;

    public ImportAdapter(Context context, List<Pair<String, ImportBatch>> listImport) {
        this.listImport = listImport;
        this.context = context;
    }
    public void setClickListener(ItemClick itemClick){
        this.itemClick = itemClick;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.nvkho_func3_item,parent,false);
        return new MyViewHolder(view,context);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Pair<String, ImportBatch> importBatchPair = listImport.get(position);
        holder.idImport.setText(importBatchPair.first);
        holder.quantity.setText(String.valueOf(importBatchPair.second.getQuantity_import()));
        holder.sup.setText(importBatchPair.second.getSupplier());
        holder.status.setText(importBatchPair.second.getStatus());
    }

    @Override
    public int getItemCount() {
        return listImport.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView idImport, sup, quantity, status;

        public MyViewHolder(@NonNull View itemView,Context ctx) {
            super(itemView);
            context = ctx;
            idImport = itemView.findViewById(R.id.mapn3);
            sup = itemView.findViewById(R.id.ncc3);
            quantity = itemView.findViewById(R.id.slnhap3);
            status = itemView.findViewById(R.id.ttnhap3);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            itemClick.onClick(v,getAdapterPosition());
        }
    }
}
