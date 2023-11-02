package com.example.projecthk1_2023_2024.admin;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projecthk1_2023_2024.MainActivity;
import com.example.projecthk1_2023_2024.R;
import com.example.projecthk1_2023_2024.admin.adapter.NotificationAdapter;
import com.example.projecthk1_2023_2024.databinding.AdminHomeBinding;
import com.example.projecthk1_2023_2024.model.Notification;
import com.example.projecthk1_2023_2024.model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class AdminActivity extends AppCompatActivity {
    ImageView imgUser;
    FrameLayout nhanVien, nhapHang, xuatHang, product;
    RecyclerView recyclerView;
    AdminHomeBinding adminHomeBinding;
    private List<Pair<String, Notification>> notificationList = new ArrayList<>();
    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener authStateListener;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference collectionReferenceUser = db.collection("User");
    private CollectionReference collectionReferenceNotification = db.collection("Notification");
    private FirebaseUser currentUser;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_home);
        nhanVien = findViewById(R.id.frameLayout1);
        nhapHang = findViewById(R.id.frameLayout3);
        xuatHang = findViewById(R.id.frameLayout4);
        product = findViewById(R.id.frameLayout2);

        firebaseAuth = FirebaseAuth.getInstance();
        currentUser = firebaseAuth.getCurrentUser();
        String loginId = currentUser.getUid();
        final User[] user = new User[1];
        collectionReferenceUser.whereEqualTo("loginId",loginId)
                        .get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                // 3. Lấy dữ liệu từ tài liệu và gán vào đối tượng User
                                user[0] = document.toObject(User.class);

                                // Giờ bạn có thể sử dụng đối tượng User với dữ liệu từ tài liệu
                                // user.getName(), user.getEmail(), v.v.
                            }
                        } else {
                            Log.d(TAG, "Error getting documents: ", task.getException());
                        }
                    }
                });
        adminHomeBinding = DataBindingUtil.setContentView(this, R.layout.admin_home);
        adminHomeBinding.setAccount(user[0]);


        collectionReferenceNotification.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        String IdDocument = document.getId();
                        Notification notification = document.toObject(Notification.class);
                        Pair<String, Notification> notificationPair = new Pair<>(IdDocument,notification);
                        if (notification.getEnable() == false) {
                            notificationList.add(notificationPair);
                        }
                    }
                } else {
                    Log.d(TAG, "Error getting documents: ", task.getException());
                }
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setHasFixedSize(true);
//        NotificationAdapter notificationAdapter = new NotificationAdapter(AdminActivity.this,notificationList);

        recyclerView.setAdapter(new NotificationAdapter(AdminActivity.this, notificationList));
        nhanVien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity();
            }
        });
        nhapHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity();

            }
        });
        xuatHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity();

            }
        });
        product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity();

            }
        });
    }
}
