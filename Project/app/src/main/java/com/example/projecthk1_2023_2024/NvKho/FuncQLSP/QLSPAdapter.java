package com.example.projecthk1_2023_2024.NvKho.FuncQLSP;

import android.content.Context;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.projecthk1_2023_2024.R;
import com.example.projecthk1_2023_2024.Admin.clickhandler.ItemClick;
import com.example.projecthk1_2023_2024.model.Product;

import java.util.List;

public class QLSPAdapter extends RecyclerView.Adapter<QLSPAdapter.MyViewHolder>  {
    Context context;
    ItemClick itemClick;
    private List<Pair<String, Product>> listProduct;

    public QLSPAdapter(Context context, List<Pair<String, Product>> listProduct) {
        this.context = context;
        this.listProduct = listProduct;
    }
    public void setFilterList(Context context, List<Pair<String, Product>> filtedList){
        this.context = context;
        this.listProduct = filtedList;
        notifyDataSetChanged();
    }

    public void setClickListener(ItemClick itemClick){
        this.itemClick = itemClick;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.nvkho_func4_qlsp_item,parent,false);
        return new MyViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Pair<String, Product> productPair = listProduct.get(position);
        holder.nameView.setText(productPair.second.getName());
        holder.totalView.setText(String.valueOf(productPair.second.getQuantity()));
        holder.stockView.setText(String.valueOf(productPair.second.getQuantity_Stock()));
        /**
         *  Using Glide Library to Display the images
         * */

        Glide.with(context)
                .load(productPair.second.getLink_Photo())
                //.placeholder()
                .fitCenter()
                .into(holder.img);
    }

    @Override
    public int getItemCount() {
        return listProduct.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView nameView, totalView, stockView;
        ImageView img;

        public MyViewHolder(@NonNull View itemView, Context ctx) {
            super(itemView);
            context = ctx;
            nameView = itemView.findViewById(R.id.nameView);
            totalView = itemView.findViewById(R.id.totalView);
            stockView = itemView.findViewById(R.id.stockView);
            img = itemView.findViewById(R.id.imgSP);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (itemClick!=null){
                itemClick.onClick(v,getAdapterPosition());
            }
        }
    }
}
