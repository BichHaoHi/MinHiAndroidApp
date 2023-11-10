package com.example.projecthk1_2023_2024.admin;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.Toast;

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
                showBottomsheet(context);
            }
        });
    }
    public static void showBottomsheet(Context context) {
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.fragment_nuttinhnang);

        LinearLayout accountLayout = dialog.findViewById(R.id.layoutAccount);
        LinearLayout logoutLayout = dialog.findViewById(R.id.layoutLogout);

        accountLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "...", Toast.LENGTH_SHORT).show();
            }
        });

        logoutLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "...", Toast.LENGTH_SHORT).show();
            }
        });

        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = androidx.appcompat.R.style.Animation_AppCompat_Dialog;
        dialog.getWindow().setGravity(Gravity.BOTTOM);
    }
}
