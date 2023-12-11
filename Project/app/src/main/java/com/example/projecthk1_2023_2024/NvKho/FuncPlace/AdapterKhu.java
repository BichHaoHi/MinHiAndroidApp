package com.example.projecthk1_2023_2024.NvKho.FuncPlace;

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
import com.example.projecthk1_2023_2024.model.Zone;

import java.util.ArrayList;

public class AdapterKhu extends RecyclerView.Adapter<AdapterKhu.MyViewHolder> {
    private ArrayList<Pair<String, Zone>> dsKhu;
    Context context;
    ItemClick itemClick;


    public AdapterKhu(ArrayList<Pair<String, Zone>> dsKhu, Context context, ItemClick itemClick) {
        this.dsKhu = dsKhu;
        this.context = context;
        this.itemClick = itemClick;
    }
    public void setClickListener(ItemClick itemClick){
        this.itemClick = itemClick;
    }

    @NonNull
    @Override
    public AdapterKhu.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.nvkho_func1_item_khu, parent, false);
        return new MyViewHolder(itemView);
    }



    @Override
    public void onBindViewHolder(@NonNull AdapterKhu.MyViewHolder holder, int position) {
//        Zone item = dsKhu.get(position);
//        holder.txtNameKhu.setText(item.getNameKhu());
//
//
//        int itemPosition = holder.getAdapterPosition();


    }

    @Override
    public int getItemCount() {
        return dsKhu.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView txtNameKhu;

        public MyViewHolder(@NonNull View itemView) {

                super(itemView);
                txtNameKhu = itemView.findViewById(R.id.nameKhu);




        }
    }


}
