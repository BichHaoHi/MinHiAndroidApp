package com.example.appmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;



import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText edtEmail;
    EditText edtPassword;
    TextView txtForgetPass;
    Button btnLogin;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        context = this;
        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        txtForgetPass = findViewById(R.id.txtForgetPass);
        btnLogin = findViewById(R.id.btnLogin);

        //1.2. nhân lại emali từ giao diện quen mk
        Intent intent = getIntent();
        String email = intent.getStringExtra("emailBack");
        edtEmail.setText(email);
        //1.1. click forget pass
        txtForgetPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                getEmail();
                gotoForget();

            }
        });

        //2. Xử lý phân quyền đăng nhập???
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //chỉ mới đến được home nhân viên thủ kho
                edtEmail = findViewById(R.id.edtEmail);
                edtPassword = findViewById(R.id.edtPassword);
                String email = edtEmail.getText().toString().trim();
                String pass = edtPassword.getText().toString().trim();
                if (!email.isEmpty() && !pass.isEmpty()) {
                    Intent intent = new Intent(LoginActivity.this, MainFragmentActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(LoginActivity.this,
                            "Vui lòng điền email và mật khẩu",
                            Toast.LENGTH_SHORT).show();

                }
            }
        });

            }
    // CÁCH CHUYỂN TRANG
    // Bấm vào forget pass thì chuyển trang là 1 phương thức được gọi đến khi bấm vào nút
    @SuppressLint("WrongViewCast")
    public void gotoForget(){
        edtEmail = findViewById(R.id.edtEmail);
        String getEmail = edtEmail.getText().toString().trim();
        Intent intent = new Intent(LoginActivity.this, ForgetPassActivity.class);
        intent.putExtra("emaill", getEmail);
        startActivity(intent);

    }
// LẤY EMAIL TỪ ĐĂNG NHẬP ĐƯA QUA QUÊN MẬT KHẨU
//    public void getEmail(){
//        edtEmail = findViewById(R.id.edtEmail);
//        String getEmail = edtEmail.getText().toString().trim();
//        Intent i = new Intent(this, ForgetPassActivity.class);
//        i.putExtra("email", getEmail);
//        startActivity(i);
//    }
//    CÁCH TRUY CẬP LINK KHÁC
    public void gotoGoogle(){
        Uri link = Uri.parse("https://www.google.com/?hl=vi");
        Intent toGG = new Intent(Intent.ACTION_VIEW, link);
        startActivity(toGG);
    }


}