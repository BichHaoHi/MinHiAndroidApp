package com.example.appmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

public class ActiFunc_Nhap_TKho extends AppCompatActivity {
    ImageView back;
    ListView phieuNhap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_func_nhap_tkho);
        back = findViewById(R.id.back_home);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ActiFunc_Nhap_TKho.this, Fragment_Home.class);
                startActivity(i);
            }
        });
    }
}