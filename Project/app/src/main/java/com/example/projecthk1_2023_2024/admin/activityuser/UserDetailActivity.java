package com.example.projecthk1_2023_2024.Admin.activityuser;

import android.os.Bundle;
import android.util.Pair;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projecthk1_2023_2024.R;
import com.example.projecthk1_2023_2024.Util.ViewModel.VMListUser;
import com.example.projecthk1_2023_2024.model.User;

public class UserDetailActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_layout);
        String idUser = getIntent().getStringExtra("IdUser");
        VMListUser listUser = VMListUser.getInstance();
        Pair<String, User> userPair = listUser.find(idUser);
    }
}
