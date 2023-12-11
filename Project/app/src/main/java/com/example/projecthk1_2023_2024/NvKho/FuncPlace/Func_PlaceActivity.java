package com.example.projecthk1_2023_2024.NvKho.FuncPlace;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projecthk1_2023_2024.NvKho.NvkFragHome;
import com.example.projecthk1_2023_2024.R;

import java.util.ArrayList;

public class Func_PlaceActivity extends AppCompatActivity {
    Context context;
    ImageView back;
    TextView empty, have, full;

    AdapterKhu adapterKhu;
    RecyclerView recyListKhu;
    //ArrayList<Khu> arrKhu;

    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nvkho_func1_qlvtri_layout);
        context = this;
        // 1. xu ly back
        back = findViewById(R.id.backHomeKho);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Func_PlaceActivity.this, NvkFragHome.class);
                startActivity(i);
            }
        });
        //2. xu ly hien thi space kho
//        recyListKhu = findViewById(R.id.recy_khu_f1);
//        arrKhu = new ArrayList<Khu>();
//        Khu khuA = new Khu("Khu A");
//        Khu khuB = new Khu("Khu B");
//        Khu khuC = new Khu("Khu C");
//        Khu khuD = new Khu("Khu D");
//        arrKhu.add(khuA);
//        arrKhu.add(khuB);
//        arrKhu.add(khuC);
//        arrKhu.add(khuD);

//        adapterKhu = new AdapterKhu(arrKhu); // Khởi tạo adapter

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyListKhu.setLayoutManager(layoutManager);

        recyListKhu.setAdapter(adapterKhu);


    }
}
