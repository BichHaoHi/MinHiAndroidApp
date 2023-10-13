package com.example.appmanager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class Fragment_Home extends Fragment {
    TextView nameAcount;
    ImageView avtAcount;
    ImageView nhap, xuat, ls;
    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         View view =  inflater.inflate(R.layout.fragment_home_layout, container, false);
        // thiet lap cac su kien tai day tren fragment con
        //1. xử lý hiện thông báo mới nhất
        ListView newNotice = view.findViewById(R.id.listViewNoticeHome);

        ArrayList<Tbao> listTB = new ArrayList<Tbao>();
        listTB.add(new Tbao("Thông báo nhập kho", "Có 1 đơn nhập mới"));
        listTB.add(new Tbao("Thông báo xuất kho", "Có 1 đơn xuất mới"));
        NoticeCusActivity adapter = new NoticeCusActivity(listTB, getContext());
        newNotice.setAdapter(adapter);
// 2. xử lý xem và sửa thông tin tài khoản cá nhân
        nameAcount = view.findViewById(R.id.nameAcount);
        avtAcount = view.findViewById(R.id.imgAvt);
        avtAcount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), AcountActivity.class);
                startActivity(i);
            }
        });

        //3. bắt sự kiện Nhập hàng
        nhap = view.findViewById(R.id.func_nhapHang);
        nhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), ActiFunc_Nhap_TKho.class);
                startActivity(i);

            }
        });
        // 4. bắt sự kiện xuất hàng
        xuat = view.findViewById(R.id.func_xuathang);
        xuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), ActiFunc_Xuat_TKho.class);
                startActivity(i);
            }
        });
        // 5. bắt sự kiện xem lịch sử nhập xuất
        ls = view.findViewById(R.id.func_ls);
        ls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), ActiFunc_Ls_TKho.class);
                startActivity(i);
            }
        });
        return view;


    }




}
