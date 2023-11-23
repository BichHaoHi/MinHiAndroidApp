package com.example.projecthk1_2023_2024.NvKho.FuncQLSP;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projecthk1_2023_2024.R;
import com.example.projecthk1_2023_2024.Util.ViewModel.VMQlsp;
import com.example.projecthk1_2023_2024.Admin.clickhandler.ItemClick;
import com.google.firebase.Timestamp;

import java.util.Date;
import java.util.List;

public class QLSPAdapter extends RecyclerView.Adapter<QLSPAdapter.MyViewHolder> {
    Context context;
    ItemClick itemClick;
    private List<VMQlsp> listSP;

    public QLSPAdapter(Context context, List<VMQlsp> listSP) {
        this.context = context;
        this.listSP = listSP;
    }

    public void setClickListener(ItemClick itemClick){
        this.itemClick = itemClick;
    }

    @NonNull
    @Override
    public QLSPAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.nvkho_func4_qlsp_item,parent,false);
        return new QLSPAdapter.MyViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(@NonNull QLSPAdapter.MyViewHolder holder, int position) {
        VMQlsp SPPair = listSP.get(position);
        holder.txtTensp.setText(SPPair.getProductPair4().second.getName());
        holder.txtSlt.setText(SPPair.getProductPair4().second.getQuantity());
        holder.txtMaLo.setText(SPPair.getBatchPair4().first);

        Timestamp exprided = SPPair.getBatchPair4().second.getExpiryDate();
        //Định dạng ngày thành kiểu String
        String exDate = String.valueOf(exprided);
        //Đặt giá trị cho TextView
        holder.txtHsd.setText(exDate);
    }

    @Override
    public int getItemCount() {
        return listSP.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView txtTensp;
        TextView txtSlt;
        TextView txtMaLo;
        TextView txtHsd;

        public MyViewHolder(@NonNull View itemView, Context ctx) {
            super(itemView);
            context = ctx;
            txtTensp = itemView.findViewById(R.id.namePr4);
            txtSlt = itemView.findViewById(R.id.slTon4);
            txtMaLo = itemView.findViewById(R.id.maLo4);
            txtHsd = itemView.findViewById(R.id.hsd4);
        }

        @Override
        public void onClick(View v) {
            if (itemClick!=null){
                itemClick.onClick(v,getAdapterPosition());
            }
        }
    }
}
