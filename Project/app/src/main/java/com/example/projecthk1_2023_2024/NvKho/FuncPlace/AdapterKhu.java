package com.example.projecthk1_2023_2024.NvKho.FuncPlace;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projecthk1_2023_2024.R;
import com.example.projecthk1_2023_2024.Util.Khu;

import java.util.ArrayList;

public class AdapterKhu extends RecyclerView.Adapter<AdapterKhu.MyViewHolder> {
    private ArrayList<Khu> dsKhu;


    public AdapterKhu(ArrayList<Khu> listNV){
        this.dsKhu = listNV;
    }

    @NonNull
    @Override
    public AdapterKhu.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.nvkho_func1_item_khu, parent, false);
        return new MyViewHolder(itemView);
    }



    @Override
    public void onBindViewHolder(@NonNull AdapterKhu.MyViewHolder holder, int position) {
        Khu item = dsKhu.get(position);
        holder.txtNameKhu.setText(item.getNameKhu());


        int itemPosition = holder.getAdapterPosition();


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
