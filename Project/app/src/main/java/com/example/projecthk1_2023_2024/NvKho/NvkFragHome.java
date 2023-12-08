package com.example.projecthk1_2023_2024.NvKho;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projecthk1_2023_2024.NvKho.FuncNhapHang.Func_qlNhapHangActivity;
import com.example.projecthk1_2023_2024.NvKho.FuncPlace.Func_PlaceActivity;
import com.example.projecthk1_2023_2024.NvKho.FuncQLSP.Func_QLSPActivity;
import com.example.projecthk1_2023_2024.NvKho.FuncXuatHang.Func_qlXuatHangActivity;
import com.example.projecthk1_2023_2024.R;
import com.example.projecthk1_2023_2024.Util.ListUser;
import com.example.projecthk1_2023_2024.Admin.adapter.NotificationAdapter;
import com.example.projecthk1_2023_2024.model.Notification;
import com.example.projecthk1_2023_2024.model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class NvkFragHome extends Fragment {
    static boolean isImgBack = false;
    TextView nameAccount;
    ImageView avtAcount;
    FrameLayout vtri, qlXuat, qlNhap, qlSP;
    RecyclerView recyNote;
    private User user;
    private List<Pair<String, Notification>> notificationList = new ArrayList<>();
    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener authStateListener;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference collectionReferenceNotification = db.collection("Notification");
    private CollectionReference collectionReferenceUser = db.collection("User");
    private FirebaseUser currentUser;
    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.nvkho_frag_home_layout, container, false);
        recyNote = view.findViewById(R.id.newNote);
        firebaseAuth = FirebaseAuth.getInstance();
        currentUser = firebaseAuth.getCurrentUser();
        nameAccount = view.findViewById(R.id.nameAccountNV);
        String loginId = currentUser.getUid();

// Xử lý hiển thị thông báo mới
        collectionReferenceNotification.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        String IdDocument = document.getId();
                        Notification notification = document.toObject(Notification.class);
                        Pair<String, Notification> notificationPair = new Pair<>(IdDocument,notification);
                        if (notification.getEnable() == false) {//?? xử lý hiển thị đúng thông báo cho nhân viên cần thêm điều kiện
                            notificationList.add(notificationPair);
                        }
                    }
                    LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                    recyNote.setLayoutManager(layoutManager);

                    NotificationAdapter notificationAdapter = new NotificationAdapter(getActivity(), notificationList);
                    recyNote.setAdapter(notificationAdapter);
                } else {
                    Log.d(TAG, "Error getting documents: ", task.getException());
                }
            }
        });

// Xử lý hiển thị tên người dùng
        collectionReferenceUser.whereEqualTo("LoginID",loginId)
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                        if (error != null){
                            Toast.makeText(getActivity(), error.getMessage() + "Line 87", Toast.LENGTH_SHORT).show();
                        }
                        assert value != null;
                        if (!value.isEmpty()){
                            for(QueryDocumentSnapshot snapshot : value){
                                user = snapshot.toObject(User.class);
                                String name = snapshot.getString("Role");
                                nameAccount.setText(user.getUserName());

                            }
                        }
                    }
                });

// 2. xử lý xem và sửa thông tin tài khoản cá nhân
//        nameAccount = view.findViewById(R.id.nameAccount);
        avtAcount = view.findViewById(R.id.imgAvt);
        avtAcount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), AccountActivity.class);
                startActivity(i);
            }
        });
        // 3. Xử lý vị trí sản phẩm
        vtri = view.findViewById(R.id.func_viTriSP);
        vtri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), Func_PlaceActivity.class);
                startActivity(i);
            }
        });
        //4. Xu ly xuat kho
        qlXuat = view.findViewById(R.id.func_qlXuat);
        qlXuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), Func_qlXuatHangActivity.class);
                startActivity(i);
                // bắt các sự kiện để xem tt detail
            }
        });
        // 5.xu ly nhap
        qlNhap = view.findViewById(R.id.func_qlNhap);
        qlNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), Func_qlNhapHangActivity.class);
                startActivity(i);
                // bắt các sự kiện để xem tt detail
            }
        });
        // 6. Quan ly san phaam
        qlSP = view.findViewById(R.id.func_qlsp);
        qlSP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent i = new Intent(getContext(), Func_QLSPActivity.class);
                startActivity(i);
            }
        });
        return view;


    }

}
