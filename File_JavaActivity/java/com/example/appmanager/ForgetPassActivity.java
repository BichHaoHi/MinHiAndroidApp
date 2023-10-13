package com.example.appmanager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import java.util.Random;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;



public class ForgetPassActivity extends AppCompatActivity {

    EditText edtEmailAgain;
    Button btnSend;
    Context context;
    ImageView back;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forget_passs_layout);

        edtEmailAgain = findViewById(R.id.edtEmailAgain);
        Intent intent = getIntent();
        String emailX = intent.getStringExtra("emaill");
        edtEmailAgain.setText(emailX);

        //1.2. xử lý trở lại đăng nhập sau khi lấy được pass tại mail
        back = findViewById(R.id.imgBack);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ForgetPassActivity.this, LoginActivity.class);
                String getEmailBack = edtEmailAgain.getText().toString().trim();
                intent.putExtra("emailBack", getEmailBack);
                startActivity(intent);
            }
        });

        btnSend = findViewById(R.id.btnSendPass);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                randomPass();
            }
            private int randomPass(){
                Random random = new Random();
                int num_limit = 99999999;
                int ranPass = random.nextInt(num_limit);
                return ranPass;
                
            }
        });
            // hàm tạo pass tự động 8 ký tự số ngẫu nhiên

}
}
