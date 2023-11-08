package com.example.projecthk1_2023_2024.NvKho.FuncQLSP;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projecthk1_2023_2024.R;

import com.example.projecthk1_2023_2024.Util.QLSP;

import java.util.ArrayList;

public class AdapterQLSP extends RecyclerView.Adapter<AdapterQLSP.MyViewHolder> {
    private ArrayList<QLSP> dsTTSP;

    public AdapterQLSP(ArrayList<QLSP> listTTSP){
        this.dsTTSP = listTTSP;
    }


    public AdapterQLSP.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.nvkho_func4_qlsp_item, parent, false);
        return new MyViewHolder(itemView);
    }



    @Override
    public void onBindViewHolder(@NonNull AdapterQLSP.MyViewHolder holder, int position) {
        QLSP item = dsTTSP.get(position);
        holder.txtTenSP.setText(item.getTenSP());
        holder.txtMaLo.setText(item.getMaLo());
        holder.txtSLTon.setText(item.getSlTon());
        holder.txtTTXuat.setText(item.getTtXuat());
        holder.txtHSD.setText(item.getHsd());
    }

    @Override
    public int getItemCount() {
        return dsTTSP.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView txtTenSP;
        TextView txtMaLo;
        TextView txtSLTon;
        TextView txtHSD;
        TextView txtTTXuat;

        public MyViewHolder(@NonNull View itemView) {

                super(itemView);
                txtTenSP = itemView.findViewById(R.id.namePr1);
                txtMaLo = itemView.findViewById(R.id.maLo1);
                txtSLTon = itemView.findViewById(R.id.slTon1);
                txtTTXuat = itemView.findViewById(R.id.ttXuat1);
                txtHSD = itemView.findViewById(R.id.hsd1);
        }
    }

    public void filterList(ArrayList<QLSP> filteredList) {
        dsTTSP = filteredList;
        notifyDataSetChanged(); // Cập nhật RecyclerView với danh sách mới
    }


}