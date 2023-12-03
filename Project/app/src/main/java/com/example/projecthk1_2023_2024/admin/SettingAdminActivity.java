package com.example.projecthk1_2023_2024.admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.projecthk1_2023_2024.MainActivity;
import com.example.projecthk1_2023_2024.R;
import com.example.projecthk1_2023_2024.Util.AuUser;
import com.example.projecthk1_2023_2024.model.User;
import com.google.firebase.Timestamp;
import com.google.firebase.auth.FirebaseAuth;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SettingAdminActivity extends AppCompatActivity  {// extends Fragment mới dùng được Fragmnet
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
                Intent intent = new Intent(SettingAdminActivity.this, MainActivity.class);

                // Đặt cờ để xóa hết Activity khác và tạo ngăn xếp mới
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                startActivity(intent);

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
