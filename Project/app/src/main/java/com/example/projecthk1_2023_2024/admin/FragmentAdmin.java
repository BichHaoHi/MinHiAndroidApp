package com.example.projecthk1_2023_2024.Admin;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.projecthk1_2023_2024.R;

public class FragmentAdmin extends AppCompatActivity {
    ConstraintLayout mainLayout;
    LinearLayout home, report, notify, setting;
    ImageView imgHome, imgReport, imgNotify, imgSetting;
    ImageButton scan;
    @SuppressLint("MissingInflatedId")
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_frag_main);

        mainLayout = findViewById(R.id.cons_trans_frag);
        loadFragment(new AdminHomeActivity());
        home = findViewById(R.id.layout_click_home);
        report = findViewById(R.id.layout_click_report);
        notify = findViewById(R.id.layout_click_notice);
        setting = findViewById(R.id.layout_click_setting);
        scan = findViewById(R.id.buttonScan);

        imgHome = findViewById(R.id.imgHome);
        imgReport = findViewById(R.id.imgReport);
        imgNotify = findViewById(R.id.imgNotice);
        imgSetting = findViewById(R.id.imgSetting);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgHome.setImageResource(R.drawable.ic_home_run);
                imgReport.setImageResource(R.drawable.ic_report);
                imgNotify.setImageResource(R.drawable.ic_bell);
                imgSetting.setImageResource(R.drawable.ic_menu);


                loadFragment(new AdminHomeActivity());
            }
        });
        report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgHome.setImageResource(R.drawable.ic_home);
                imgReport.setImageResource(R.drawable.ic_report_run);
                imgNotify.setImageResource(R.drawable.ic_bell);
                imgSetting.setImageResource(R.drawable.ic_menu);


                loadFragment(new ReportAdminActivity());
            }
        });
        notify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgHome.setImageResource(R.drawable.ic_home);
                imgReport.setImageResource(R.drawable.ic_report);
                imgNotify.setImageResource(R.drawable.ic_bell_run);
                imgSetting.setImageResource(R.drawable.ic_menu);


                loadFragment(new NotificationAdminActivity());
            }
        });
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgHome.setImageResource(R.drawable.ic_home);
                imgReport.setImageResource(R.drawable.ic_report);
                imgNotify.setImageResource(R.drawable.ic_bell);
                imgSetting.setImageResource(R.drawable.ic_menu_run);


                loadFragment(new SettingAdminActivity());
            }
        });
        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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
