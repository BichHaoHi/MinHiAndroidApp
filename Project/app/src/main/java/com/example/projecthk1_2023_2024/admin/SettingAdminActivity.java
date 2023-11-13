package com.example.projecthk1_2023_2024.admin;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.projecthk1_2023_2024.MainActivity;
import com.example.projecthk1_2023_2024.R;
import com.example.projecthk1_2023_2024.Util.AuUser;
import com.example.projecthk1_2023_2024.admin.clickhandler.ItemClick;
import com.example.projecthk1_2023_2024.model.User;
import com.google.android.material.color.utilities.CorePalette;
import com.google.firebase.Timestamp;
import com.google.firebase.auth.FirebaseAuth;

import org.checkerframework.checker.units.qual.A;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SettingAdminActivity extends AppCompatActivity  {
    ImageView img, back;
    TextView nameView, phoneView, sexView, startView, roleView;
    Button btnLogOut;
    private FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_nv);
        img = findViewById(R.id.avt_nv);
        phoneView = findViewById(R.id.Text_phone);
        nameView = findViewById(R.id.Name);
        sexView = findViewById(R.id.Text_sex);
        startView = findViewById(R.id.Text_start_date);
        roleView = findViewById(R.id.Text_role);
        back = findViewById(R.id.back);
        btnLogOut = findViewById(R.id.btnLogout);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        AuUser auUser = AuUser.getInstance();

        User user = auUser.getUser();
        /**
         *  Using Glide Library to Display the images
         * */

        Glide.with(getApplicationContext())
                .load(user.getImage())
                //.placeholder()
                .fitCenter()
                .into(img);
        nameView.setText(user.getUserName());
        phoneView.setText(user.getPhone());
        sexView.setText(user.getSex());
        startView.setText(ChangeDaytoString(user.getStart_Date()));
        roleView.setText(user.getRole());

        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.signOut();
                startActivity(new Intent(SettingAdminActivity.this, MainActivity.class));
            }
        });



    }

    private String ChangeDaytoString(Timestamp startDate) {
        Date date = startDate.toDate();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String dateString = sdf.format(date);
        return dateString;
    }


}
