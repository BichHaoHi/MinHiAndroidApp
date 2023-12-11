package com.example.projecthk1_2023_2024.NvKho.FuncNhapHang;

import android.content.Context;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projecthk1_2023_2024.R;
import com.example.projecthk1_2023_2024.Util.ViewModel.VMNewExport;
import com.example.projecthk1_2023_2024.Admin.clickhandler.ItemClick;
import com.example.projecthk1_2023_2024.model.ImportBatch;
import com.example.projecthk1_2023_2024.model.Product;

import java.util.List;

public class NewImportAdapter extends RecyclerView.Adapter<NewImportAdapter.MyViewHolder>  {
    Context context;
    ItemClick itemClick;
    private List<Pair<String, ImportBatch>> listNewExp;

    public NewImportAdapter(Context context, List<Pair<String, ImportBatch>> listNewExp) {
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
        Pair<String, ImportBatch> NewImpPair = listNewExp.get(position);
        holder.txtMapn.setText(NewImpPair.first);
        holder.txtNCC.setText(NewImpPair.second.getSupplier());

        Boolean statusDeli = NewImpPair.second.getStausDeli();
        if(statusDeli == true){// true la 1
            holder.txtTTdon.setText("Đã đến kho");
        }
        else{
            holder.txtTTdon.setText("Đang vận chuyển");
        }
        holder.txtSlNhap.setText(String.valueOf(NewImpPair.second.getQuantity_import()));

    }

    @Override
    public int getItemCount() {
        return listNewExp.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView txtMapn, txtNCC, txtTTdon, txtSlNhap;

        public MyViewHolder(@NonNull View itemView, Context ctx) {
            super(itemView);
            context = ctx;
            txtMapn = itemView.findViewById(R.id.mapn3);
            txtNCC = itemView.findViewById(R.id.ncc3);
            txtTTdon = itemView.findViewById(R.id.statusDon3);
            txtSlNhap = itemView.findViewById(R.id.slnhap3);
        }

        @Override
        public void onClick(View v) {
            if (itemClick!=null){
                itemClick.onClick(v,getAdapterPosition());
            }
        }
    }
}