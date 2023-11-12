package com.example.projecthk1_2023_2024.admin.activityuser;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.projecthk1_2023_2024.R;
import com.example.projecthk1_2023_2024.Util.ListUser;

public class UserDetailActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_layout);
        String idUser = getIntent().getStringExtra("IdUser");
        ListUser listUser = ListUser.getInstance();
        Log.d(TAG,listUser.find(idUser).second.getUserName());
    }
}
