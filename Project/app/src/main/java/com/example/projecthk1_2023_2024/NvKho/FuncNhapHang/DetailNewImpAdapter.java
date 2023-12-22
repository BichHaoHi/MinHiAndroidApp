package com.example.projecthk1_2023_2024.NvKho.FuncNhapHang;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projecthk1_2023_2024.R;
import com.example.projecthk1_2023_2024.Util.ViewModel.VMDetailNewImp;
import com.example.projecthk1_2023_2024.Admin.clickhandler.ItemClick;

import java.util.List;
import java.util.Map;

public class DetailNewImpAdapter extends RecyclerView.Adapter<DetailNewImpAdapter.MyViewHolder>  {
    Context context;
    //ItemClick itemClick;
    private List<Map<String, Object>> listDataProBatch;
    private List<Map<String, Object>> listDataProduct;

    // Constructor để nhận dữ liệu từ Activity/Fragment
    public DetailNewImpAdapter(List<Map<String, Object>> dataListMain, List<Map<String, Object>> dataListSub) {

        this.listDataProBatch = dataListMain;
        this.listDataProduct = dataListSub;
    }

//    public void setClickListener(ItemClick itemClick){
//        this.itemClick = itemClick;
//    }

    @NonNull
    @Override
    public DetailNewImpAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.nvkho_f3_1_detail_item,parent,false);
        return new DetailNewImpAdapter.MyViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailNewImpAdapter.MyViewHolder holder, int position) {
        Map<String, Object> mainData = listDataProBatch.get(position);
        Map<String, Object> subData = listDataProduct.get(position);

        holder.txtTenSp.setText((String)subData.get("Name"));
        holder.txtMaLo.setText((String)mainData.get("IDBatch"));
        holder.txtHsd.setText((String)mainData.get("ExpiryDate"));
        holder.txtSlt.setText((String)subData.get("Quantity_Valid"));
        holder.txtSln.setText((String)subData.get("Quantity"));
        holder.txtGia.setText((String)mainData.get("ImportPrice"));



    }

    @Override
    public int getItemCount() {
        return 0;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView txtTenSp, txtMaLo, txtHsd, txtSlt, txtSln,txtGia;

        public MyViewHolder(@NonNull View itemView, Context ctx) {
            super(itemView);
            context = ctx;
            txtTenSp = itemView.findViewById(R.id.namePr31);
            txtSlt = itemView.findViewById(R.id.slTon31);
            txtSln = itemView.findViewById(R.id.slNhap31);
            txtMaLo= itemView.findViewById(R.id.maLo31);
            txtHsd = itemView.findViewById(R.id.hsd31);
            txtGia= itemView.findViewById(R.id.gia31);
        }


        @Override
        public void onClick(View v) {

        }
    }
}
