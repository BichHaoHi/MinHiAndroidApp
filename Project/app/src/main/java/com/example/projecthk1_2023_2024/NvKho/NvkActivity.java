package com.example.projecthk1_2023_2024.NvKho;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.projecthk1_2023_2024.R;

public class NvkActivity extends AppCompatActivity {
    ConstraintLayout transFrag;
    LinearLayout lHome, lReport, lNotice, lSetting;

    ImageView imgHome, imgReport, imgNotice, imgSetting, imgScan;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nvkho_frag_main);

        transFrag = findViewById(R.id.cons_trans_frag);
        loadFragment(new NvkFragHome());
        lHome = findViewById(R.id.layout_click_home);
        lReport = findViewById(R.id.layout_click_report);
        lNotice = findViewById(R.id.layout_click_notice);
        lSetting = findViewById(R.id.layout_click_setting);
        imgScan = findViewById(R.id.scanSP);
        imgHome = findViewById(R.id.imgHome);
        imgReport = findViewById(R.id.imgReport);
        imgNotice = findViewById(R.id.imgNotice);
        imgSetting = findViewById(R.id.imgSetting);

        lHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgHome.setImageResource(R.drawable.ic_home_run);
                imgReport.setImageResource(R.drawable.ic_report);
                imgNotice.setImageResource(R.drawable.ic_bell);
                imgSetting.setImageResource(R.drawable.ic_menu);


                loadFragment(new NvkFragHome());
            }
        });

        lReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgReport.setImageResource(R.drawable.ic_report_run);
                imgHome.setImageResource(R.drawable.ic_home);
                imgNotice.setImageResource(R.drawable.ic_bell);
                imgSetting.setImageResource(R.drawable.ic_menu);

                loadFragment(new NvkFragReport());
            }
        });

        lNotice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgNotice.setImageResource(R.drawable.ic_bell_run);
                imgReport.setImageResource(R.drawable.ic_report);
                imgHome.setImageResource(R.drawable.ic_home);
                imgSetting.setImageResource(R.drawable.ic_menu);

                loadFragment(new NvkFragNotice());
            }
        });

        lSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgSetting.setImageResource(R.drawable.ic_menu_run);
                imgReport.setImageResource(R.drawable.ic_report);
                imgNotice.setImageResource(R.drawable.ic_bell);
                imgHome.setImageResource(R.drawable.ic_home);

                loadFragment(new NvkFragSetting());
            }
        });
    }

    public void loadFragment(Fragment fragment){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.cons_trans_frag, fragment);// thay thế một fragment đã thiết lập ở main.xml đã chỉ định vị trí hiển thị trước đó
        ft.commit();
    }
}
