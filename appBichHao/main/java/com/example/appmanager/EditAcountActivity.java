package com.example.appmanager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class EditAcountActivity extends AppCompatActivity {
    ImageView backAcount;
    Button btnSaveEdit;
    @SuppressLint("MissingInflatedId")
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_acount_layout);
        backAcount = findViewById(R.id.back_acount);
        backAcount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(EditAcountActivity.this, AcountActivity.class);
                startActivity(i);
            }
        });

        btnSaveEdit = findViewById(R.id.btn_save);
        btnSaveEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // xu ly luu data, hien tb va cap nhat tt ve giao dien truoc
                Toast.makeText(EditAcountActivity.this, "Lưu thông tin thành công", Toast.LENGTH_SHORT).show();
                // sử dụng bundel trong Intent để lấy tất cả dữ liệu người dùng nhập trả lại cho giao diện Acount
            }
        });
    }
}
