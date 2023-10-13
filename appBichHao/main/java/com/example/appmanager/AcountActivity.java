package com.example.appmanager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AcountActivity extends AppCompatActivity {
    ImageView back;
    ImageView editAcount;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acount_layout);
        back = findViewById(R.id.back_home);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AcountActivity.this, Fragment_Home.class);
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
