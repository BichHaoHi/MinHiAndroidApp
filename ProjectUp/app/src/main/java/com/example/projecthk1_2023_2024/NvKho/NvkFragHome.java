package com.example.projecthk1_2023_2024.NvKho;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.projecthk1_2023_2024.NvKho.FuncPlace.Func_PlaceActivity;
import com.example.projecthk1_2023_2024.R;

public class NvkFragHome extends Fragment {

    TextView nameAcount;
    ImageView avtAcount;
    FrameLayout vtri, qlXuat, qlNhap, qlSP;
    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.nvkho_frag_home_layout, container, false);
        // thiet lap cac su kien tai day tren fragment con
//        //1. xử lý hiện thông báo mới nhất
//        ListView newNotice = view.findViewById(R.id.listViewNoticeHome);
//
//        ArrayList<Tbao> listTB = new ArrayList<Tbao>();
//        listTB.add(new Tbao("Thông báo nhập kho", "Có 1 đơn nhập mới"));
//        listTB.add(new Tbao("Thông báo xuất kho", "Có 1 đơn xuất mới"));
//        NoticeCusActivity adapter = new NoticeCusActivity(listTB, getContext());
//        newNotice.setAdapter(adapter);
// 2. xử lý xem và sửa thông tin tài khoản cá nhân
        nameAcount = view.findViewById(R.id.nameAccount);
        avtAcount = view.findViewById(R.id.imgAvt);
        avtAcount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), AcountActivity.class);
                startActivity(i);
            }
        });
        // 3. Xử lý vị trí sản phẩm
        vtri = view.findViewById(R.id.func_viTriSP);
        vtri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), Func_PlaceActivity.class);
                startActivity(i);
            }
        });
        //4. Xu ly xuat kho
        qlXuat = view.findViewById(R.id.func_qlXuat);
        qlXuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), Func_qlXuatHang.class);
                startActivity(i);
                // bắt các sự kiện để xem tt detail
            }
        });
        // 5.xu ly nhap
        qlNhap = view.findViewById(R.id.func_qlNhap);
        qlNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), Func_qlNhapHang.class);
                startActivity(i);
                // bắt các sự kiện để xem tt detail
            }
        });
        // 6. Quan ly san phaam
        qlSP = view.findViewById(R.id.func_qlsp);
        qlSP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent i = new Intent(getContext(), Func_PlaceActivity.class);
                startActivity(i);
            }
        });
        return view;


    }

}
