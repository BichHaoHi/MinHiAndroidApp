package com.example.projecthk1_2023_2024.NvKho.FuncNhapHang;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.projecthk1_2023_2024.NvKho.FuncXuatHang.NewExportAdapter;
import com.example.projecthk1_2023_2024.R;
import com.example.projecthk1_2023_2024.Util.ViewModel.VMNewExport;
import com.example.projecthk1_2023_2024.admin.clickhandler.ItemClick;
import java.util.List;

public class NewImportAdapter extends RecyclerView.Adapter<NewExportAdapter.MyViewHolder>  {
    Context context;
    ItemClick itemClick;
    private List<VMNewExport> listNewExp;

    public NewImportAdapter(Context context, List<VMNewExport> listNewExp) {
        this.context = context;
        this.listNewExp = listNewExp;
    }

    public void setClickListener(ItemClick itemClick){
        this.itemClick = itemClick;
    }

    @NonNull
    @Override
    public NewImportAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.nvkho_func3_item,parent,false);
        return new NewImportAdapter.MyViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(@NonNull NewImportAdapter.MyViewHolder holder, int position) {
        VMNewExport NewImpPair = listNewExp.get(position);
        holder.txtMapn.setText(NewImpPair.getExpPair().first);//Tong -> Exp --> idExp
        holder.txtTensp.setText(NewImpPair.getExp_batchPair().second
                .getProduct(NewImpPair.getExp_batchPair().second.getId_batch()).getName()); //Tong -> exp -> getIdPr -> getNamePr
        holder.txtTTNhap.setText(NewImpPair.getExp_batchPair().second.getQuantity());

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
        TextView txtMapn, txtTensp, txtTTNhap;

        public MyViewHolder(@NonNull View itemView, Context ctx) {
            super(itemView);
            context = ctx;
            txtMapn = itemView.findViewById(R.id.mapn3);
            txtTensp = itemView.findViewById(R.id.tensp3);
            txtTTNhap = itemView.findViewById(R.id.ttnhap3);
        }

        @Override
        public void onClick(View v) {
            if (itemClick!=null){
                itemClick.onClick(v,getAdapterPosition());
            }
        }
    }
}