package com.example.projecthk1_2023_2024.NvKho;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.projecthk1_2023_2024.R;

public class AcountActivity extends AppCompatActivity {
    ImageView back;
    ImageView editAcount;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_layout);
        back = findViewById(R.id.back_homeA);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AcountActivity.this, NvkFragMain.class);
                startActivity(i);
            }
        });

        editAcount = findViewById(R.id.edit_acount);
        editAcount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AcountActivity.this, EditAcountActivity.class);
                startActivity(i);
            }
        });
    }
}
