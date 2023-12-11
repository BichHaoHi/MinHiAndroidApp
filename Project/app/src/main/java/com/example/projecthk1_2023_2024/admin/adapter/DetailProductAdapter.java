package com.example.projecthk1_2023_2024.Admin.adapter;

import android.content.Context;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projecthk1_2023_2024.R;
import com.example.projecthk1_2023_2024.model.ProductBatch;

import java.util.List;



public class DetailProductAdapter extends RecyclerView.Adapter<DetailProductAdapter.MyViewHolder> {
    Context context;
    private List<Pair<String, ProductBatch>> listProductBatch;

    public DetailProductAdapter(Context context, List<Pair<String, ProductBatch>> listProductBatch){
        this.context = context;
        this.listProductBatch = listProductBatch;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.func4_item_detail_product_nvk,parent,false);
        return new MyViewHolder(view,context);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Pair<String, ProductBatch> productBatchPair = listProductBatch.get(position);
        holder.maLo.setText(productBatchPair.second.getIdDocument(productBatchPair.first));
        holder.sl.setText(String.valueOf(productBatchPair.second.getQuantity()));
        holder.slValid.setText(String.valueOf(productBatchPair.second.getQuantity_Valid()));
    }

    @Override
    public int getItemCount() {
        return listProductBatch.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView maLo, sl, slValid,exp_date;


        public MyViewHolder(@NonNull View itemView, Context ctx) {
            super(itemView);
            context = ctx;
            maLo = itemView.findViewById(R.id.maLo4);
            sl = itemView.findViewById(R.id.slht4);
            slValid = itemView.findViewById(R.id.sltt4);
            exp_date = itemView.findViewById(R.id.hsd4);
        }
    }
}
