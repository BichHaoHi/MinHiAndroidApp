package com.example.projecthk1_2023_2024.NvKho.FuncXuatHang;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projecthk1_2023_2024.R;
import com.example.projecthk1_2023_2024.Util.ViewModel.VMNewExport;
import com.example.projecthk1_2023_2024.admin.clickhandler.ItemClick;

import java.util.List;

public class NewExportAdapter extends RecyclerView.Adapter<NewExportAdapter.MyViewHolder>  {
    Context context;
    ItemClick itemClick;
    private List<VMNewExport> listNewExp;

    public NewExportAdapter(Context context, List<VMNewExport> listNewExp) {
        this.context = context;
        this.listNewExp = listNewExp;
    }

    public void setClickListener(ItemClick itemClick){
        this.itemClick = itemClick;
    }

    @NonNull
    @Override
    public NewExportAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.nvkho_f2_1_detail_px_layout,parent,false);
        return new NewExportAdapter.MyViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        VMNewExport NewExpPair = listNewExp.get(position);
        holder.txtMapx.setText(NewExpPair.getExpPair().first);//Tong -> Exp --> idExp
        holder.txtTensp.setText(NewExpPair.getExp_batchPair().second
                .getProduct(NewExpPair.getExp_batchPair().second.getId_batch()).getName()); //Tong -> exp -> getIdPr -> getNamePr
        holder.txtSl.setText(NewExpPair.getExp_batchPair().second.getQuantity());

//        Glide.with(context)
//                .load(productPair.second.getLink_Photo())
//                //.placeholder()
//                .fitCenter()
//                .into(holder.img);
    }

    @Override
    public int getItemCount() {
        return listNewExp.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView txtMapx, txtTensp, txtSl;

        public MyViewHolder(@NonNull View itemView, Context ctx) {
            super(itemView);
            context = ctx;
            txtMapx = itemView.findViewById(R.id.mapx2);
            txtTensp = itemView.findViewById(R.id.tensp2);
            txtSl = itemView.findViewById(R.id.slx2);
        }

        @Override
        public void onClick(View v) {
            if (itemClick!=null){
                itemClick.onClick(v,getAdapterPosition());
            }
        }
    }
}