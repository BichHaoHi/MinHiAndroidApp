package com.example.projecthk1_2023_2024.NvKho.FuncNhapHang;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projecthk1_2023_2024.R;
import com.example.projecthk1_2023_2024.Util.ViewModel.VMDetailNewImp;
import com.example.projecthk1_2023_2024.Admin.clickhandler.ItemClick;

import java.util.List;

public class DetailNewImpAdapter extends RecyclerView.Adapter<DetailNewImpAdapter.MyViewHolder>  {
    Context context;
    ItemClick itemClick;
    private List<VMDetailNewImp> listDetail;

    public DetailNewImpAdapter(Context context, List<VMDetailNewImp> listDetail) {
        this.context = context;
        this.listDetail = listDetail;
    }

    public void setClickListener(ItemClick itemClick){
        this.itemClick = itemClick;
    }

    @NonNull
    @Override
    public DetailNewImpAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.nvkho_f3_1_detail_item,parent,false);
        return new DetailNewImpAdapter.MyViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailNewImpAdapter.MyViewHolder holder, int position) {
        VMDetailNewImp DetailPair = listDetail.get(position);
        holder.txtTenSp.setText(DetailPair.getProductPair3().second.getName());
        holder.txtSlt.setText(DetailPair.getProductPair3().second.getQuantity());
        holder.txtSln.setText(DetailPair.getImportPair3().second.getQuantity_import());
        holder.txtMaLo.setText(DetailPair.getBatchPair3().first);

    }

    @Override
    public int getItemCount() {
        return listDetail.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView txtTenSp, txtSlt, txtSln, txtMaLo;

        public MyViewHolder(@NonNull View itemView, Context ctx) {
            super(itemView);
            context = ctx;
            txtTenSp = itemView.findViewById(R.id.namePr31);
            txtSlt = itemView.findViewById(R.id.slTon31);
            txtSln = itemView.findViewById(R.id.slNhap31);
            txtMaLo= itemView.findViewById(R.id.maLo31);
        }

        @Override
        public void onClick(View v) {
            if (itemClick!=null){
                itemClick.onClick(v,getAdapterPosition());
            }
        }
    }
}
