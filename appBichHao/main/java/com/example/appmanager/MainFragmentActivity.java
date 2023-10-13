package com.example.appmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainFragmentActivity extends AppCompatActivity {
    ImageView btnHome, btnReport, btnNotice, btnSetting;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_fragment);

        btnHome = findViewById(R.id.btnHome);
        btnReport = findViewById(R.id.btnReport);
        btnNotice = findViewById(R.id.btnNotice);
        btnSetting = findViewById(R.id.btnSetting);

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnHome.setImageResource(R.drawable.ic_home_run);
                btnReport.setImageResource(R.drawable.ic_report_non);
                btnNotice.setImageResource(R.drawable.ic_notice_non);
                btnSetting.setImageResource(R.drawable.ic_setting_non);


                loadFragment(new Fragment_Home());
            }
        });

        btnReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnReport.setImageResource(R.drawable.ic_report_run);
                btnHome.setImageResource(R.drawable.ic_home_non);
                btnNotice.setImageResource(R.drawable.ic_notice_non);
                btnSetting.setImageResource(R.drawable.ic_setting_non);

                loadFragment(new Fragment_Report());
            }
        });

        btnNotice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnNotice.setImageResource(R.drawable.ic_notice_run);
                btnReport.setImageResource(R.drawable.ic_report_non);
                btnHome.setImageResource(R.drawable.ic_home_non);
                btnSetting.setImageResource(R.drawable.ic_setting_non);

                loadFragment(new Fragment_Notice());
            }
        });

        btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnSetting.setImageResource(R.drawable.ic_setting_run);
                btnReport.setImageResource(R.drawable.ic_report_non);
                btnNotice.setImageResource(R.drawable.ic_notice_non);
                btnHome.setImageResource(R.drawable.ic_home_non);

                loadFragment(new Fragment_Setting());
            }
        });
    }

    public void loadFragment(Fragment fragment){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragment_main, fragment);// thay thế một fragment đã thiết lập ở main.xml đã chỉ định vị trí hiển thị trước đó
        ft.commit();
    }
}