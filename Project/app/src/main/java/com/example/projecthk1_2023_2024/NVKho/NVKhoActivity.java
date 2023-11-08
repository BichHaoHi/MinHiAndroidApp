package com.example.projecthk1_2023_2024.NVKho;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.projecthk1_2023_2024.R;

public class NvkActivity extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nvkho_frag_main);

        Intent i = new Intent(this, NvkFragMain.class);
        startActivity(i);


    }
}
