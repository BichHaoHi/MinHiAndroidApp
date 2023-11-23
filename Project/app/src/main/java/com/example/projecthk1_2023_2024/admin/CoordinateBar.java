package com.example.projecthk1_2023_2024.Admin;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.example.projecthk1_2023_2024.R;

public class CoordinateBar extends AppCompatActivity {
    private static CoordinatorLayout coordinateBar;
    public static void setCoordinateBar(CoordinatorLayout layout)
    {
        coordinateBar = layout;
    }

    public static void setEventBar(Context context){
        LinearLayout lnHome = coordinateBar.findViewById(R.id.homeButton);
        LinearLayout lnReport = coordinateBar.findViewById(R.id.reportButton);
        LinearLayout lnNotify = coordinateBar.findViewById(R.id.notificationButton);
        LinearLayout lnSetting = coordinateBar.findViewById(R.id.settingButton);

        lnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, AdminActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
        lnReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, ReportAdminActivity.class));
            }
        });
        lnNotify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, NotificationAdminActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

        lnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SettingAdminActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }
}
