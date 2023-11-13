package com.example.projecthk1_2023_2024.admin.adapter;

import android.content.Context;
import android.hardware.lights.LightState;
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
import com.example.projecthk1_2023_2024.admin.clickhandler.ItemClick;
import com.example.projecthk1_2023_2024.model.Product;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder>  {
    Context context;
    ItemClick itemClick;
    private List<Pair<String, Product>> listProduct;

    public ProductAdapter(Context context, List<Pair<String, Product>> listProduct) {
        this.context = context;
        this.listProduct = listProduct;
    }

    public void setClickListener(ItemClick itemClick){
        this.itemClick = itemClick;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_view_sanpham,parent,false);
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
        }

        @Override
        public void onClick(View v) {
            if (itemClick!=null){
                itemClick.onClick(v,getAdapterPosition());
            }
        }
    }
}
