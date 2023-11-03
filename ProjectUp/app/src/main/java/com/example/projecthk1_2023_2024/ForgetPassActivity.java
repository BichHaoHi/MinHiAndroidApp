package com.example.projecthk1_2023_2024;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgetPassActivity extends AppCompatActivity {
    Button btnSend;
    EditText emailEDT;
    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener authStateListener;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        firebaseAuth = FirebaseAuth.getInstance();
        setContentView(R.layout.forget_pass_layout);
        emailEDT = findViewById(R.id.edtEmailAgain);
        btnSend = findViewById(R.id.btnSendPass);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ResetPassword(emailEDT.getText().toString().trim());

            }
        });

    }

    private void ResetPassword(String email) {
        firebaseAuth.sendPasswordResetEmail(email)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(ForgetPassActivity.this, "Password is reset", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(ForgetPassActivity.this, MainActivity.class));
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(ForgetPassActivity.this, "Email wrong!", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
