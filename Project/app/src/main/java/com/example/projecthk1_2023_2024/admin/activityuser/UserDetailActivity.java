package com.example.projecthk1_2023_2024.Admin.activityuser;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.projecthk1_2023_2024.R;
import com.example.projecthk1_2023_2024.Util.ListUser;
import com.example.projecthk1_2023_2024.Admin.activityuser.UserAdminActivity;
import com.example.projecthk1_2023_2024.model.User;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.Firebase;
import com.google.firebase.firestore.FirebaseFirestore;

public class UserDetailActivity extends AppCompatActivity {
    TextView nameView, addressView, phoneView, postView, sexView, birthView;
    ImageView edit,avt,back;
    Button del;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_layout);
        nameView = findViewById(R.id.name);
        addressView = findViewById(R.id.address);
        phoneView = findViewById(R.id.phone);
        postView = findViewById(R.id.postcode);
        sexView = findViewById(R.id.sex);
        birthView = findViewById(R.id.bir);
        back = findViewById(R.id.back_homeA);
        del = findViewById(R.id.buttonDelete);
        String idUser = getIntent().getStringExtra("IdUser");
        ListUser listUser = ListUser.getInstance();
        Pair<String, User> userPair = listUser.find(idUser);
        avt = findViewById(R.id.avt);
        edit = findViewById(R.id.edit_account);
        if(userPair != null){

            Glide.with(getApplicationContext())
                    .load(userPair.second.getImage())
                    //.placeholder()
                    .fitCenter()
                    .into(avt);
            nameView.setText(userPair.second.getUserName());
            addressView.setText(userPair.second.getAddress());
            phoneView.setText(userPair.second.getPhone());
            postView.setText(userPair.second.getPostcode());
            sexView.setText(userPair.second.getSex());
            birthView.setText(userPair.second.StampToString(userPair.second.getBirthday()));

            if (!userPair.second.getEnable()){
                del.setVisibility(View.VISIBLE);
            }
            del.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FirebaseFirestore.getInstance().collection("User").document(userPair.first)
                            .delete()
                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Log.d(TAG, "DocumentSnapshot successfully deleted!");

                                    // Intent về HomeAdminActivity
                                    Intent intent = new Intent(UserDetailActivity.this, UserAdminActivity.class);
                                    startActivity(intent);

                                    // Hiển thị Toast
                                    Toast.makeText(UserDetailActivity.this, "Delete Successfully", Toast.LENGTH_SHORT).show();
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.w(TAG, "Error deleting document", e);
                                }
                            });

                }
            });
            back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });
            edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(UserDetailActivity.this, com.example.projecthk1_2023_2024.Admin.activityuser.EditUserActivity.class);
                    i.putExtra("IdUser",idUser);
                    startActivity(i);
                }
            });
        } else {

        }
    }
}
