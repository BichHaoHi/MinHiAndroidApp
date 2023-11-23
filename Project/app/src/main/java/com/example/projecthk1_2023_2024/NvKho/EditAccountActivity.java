package com.example.projecthk1_2023_2024.NvKho;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.projecthk1_2023_2024.R;

public class EditAccountActivity extends AppCompatActivity {
    ImageView backAcount;
    Button btnSaveEdit;
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_account_layout);
        backAcount = findViewById(R.id.back);
        backAcount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(EditAccountActivity.this, AccountActivity.class);
                startActivity(i);
            }
        });

        btnSaveEdit = findViewById(R.id.btn_save);
        btnSaveEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // xu ly luu data, hien tb va cap nhat tt ve giao dien truoc
                Toast.makeText(EditAccountActivity.this, "Lưu thông tin thành công", Toast.LENGTH_SHORT).show();
                // sử dụng bundel trong Intent để lấy tất cả dữ liệu người dùng nhập trả lại cho giao diện Acount
            }
        });
    }
}
