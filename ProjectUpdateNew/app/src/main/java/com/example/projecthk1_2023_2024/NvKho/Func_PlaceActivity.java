package com.example.projecthk1_2023_2024.NvKho;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projecthk1_2023_2024.R;

import java.util.ArrayList;

public class Func_PlaceActivity extends AppCompatActivity {
    Context context;
    ImageView back;
    TextView empty, have, full;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nvkho_func1_qlsp_layout);
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
//        //2. xu ly hien thi space kho
//        ListView lvDSKhu = findViewById(R.id.listKhu);
//
//        ArrayList<Khu> dsKhu = new ArrayList<Khu>();
//        dsKhu.add(new Khu("Khu A"));
//        dsKhu.add(new Khu("Khu B"));
//        dsKhu.add(new Khu("Khu C"));
//
//        KhuCusActivity adapter = new KhuCusActivity(context, dsKhu);
//        lvDSKhu.setAdapter(adapter);


//        empty = findViewById(R.id.trongHang);
//        empty.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                loadFragment(new Frag_empty);
//            }
//        });
//
//        have = findViewById(R.id.coHang);
//        empty.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                loadFragment(new Frag_have);
//            }
//        });
//
//        full = findViewById(R.id.daDay);
//        full.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                loadFragment(new Frag_full);
//            }
//        });
//
//    }
//
//    public void loadFragment(Fragment fragment){
//        FragmentManager fm = getSupportFragmentManager();
//        FragmentTransaction ft = fm.beginTransaction();
//        ft.replace(R.id.listKhu, fragment);// thay thế một fragment đã thiết lập ở main.xml đã chỉ định vị trí hiển thị trước đó
//        ft.commit();
//    }

    }
}
