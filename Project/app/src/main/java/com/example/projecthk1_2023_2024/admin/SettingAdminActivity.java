package com.example.projecthk1_2023_2024.admin;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.projecthk1_2023_2024.R;
import com.example.projecthk1_2023_2024.admin.clickhandler.ItemClick;
import com.google.android.material.color.utilities.CorePalette;

import org.checkerframework.checker.units.qual.A;

public class SettingAdminActivity extends AppCompatActivity implements ItemClick {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_home);

        ImageView imageView = findViewById(R.id.imageView8);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBottomSheet();
            }
        });
    }
    private void showBottomSheet() {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.fragment_nuttinhnang);

        LinearLayout accountLayout = dialog.findViewById(R.id.layoutAccount);
        LinearLayout logoutLayout = dialog.findViewById(R.id.layoutLogout);

        accountLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SettingAdminActivity.this, "...", Toast.LENGTH_SHORT).show();
            }
        });
        
        logoutLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SettingAdminActivity.this, "...", Toast.LENGTH_SHORT).show();
            }
        });

        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = androidx.appcompat.R.style.Animation_AppCompat_Dialog;
        dialog.getWindow().setGravity(Gravity.BOTTOM);
    }

    @Override
    public void onClick(View v, int pos) {

    }
}
