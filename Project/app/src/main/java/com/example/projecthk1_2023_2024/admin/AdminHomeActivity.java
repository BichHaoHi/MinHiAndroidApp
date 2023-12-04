package com.example.projecthk1_2023_2024.Admin;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

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
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projecthk1_2023_2024.Admin.adapter.NotificationAdapter;
import com.example.projecthk1_2023_2024.Admin.clickhandler.ItemClick;
import com.example.projecthk1_2023_2024.R;
import com.example.projecthk1_2023_2024.Util.ListUser;
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

public class AdminHomeActivity extends Fragment implements ItemClick {
    ImageView imgUser;
    TextView textView;
    FrameLayout nhanVien, nhapHang, xuatHang, product;
    RecyclerView recyclerView;
    private User user;
    private List<Pair<String, Notification>> notificationList = new ArrayList<>();
    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener authStateListener;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference collectionReferenceNotification = db.collection("Notification");
    private CollectionReference collectionReferenceUser = db.collection("User");
    private FirebaseUser currentUser;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.admin_home,container,false);
        nhanVien = view.findViewById(R.id.frameLayout1);
        nhapHang = view.findViewById(R.id.frameLayout3);
        xuatHang = view.findViewById(R.id.frameLayout4);
        product = view.findViewById(R.id.frameLayout2);
        recyclerView = view.findViewById(R.id.notification);
        firebaseAuth = FirebaseAuth.getInstance();
        currentUser = firebaseAuth.getCurrentUser();
        textView = view.findViewById(R.id.nameAccount);
        String loginId = currentUser.getUid();
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
                    LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                    recyclerView.setLayoutManager(layoutManager);
                    recyclerView.setAdapter(new NotificationAdapter(getActivity(), notificationList));
                } else {
                    Log.d(TAG, "Error getting documents: ", task.getException());
                }
            }
        });
        collectionReferenceUser.whereEqualTo("LoginID",loginId)
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                        if (error != null){
                            Toast.makeText(getActivity(), error.getMessage() + "Line 97", Toast.LENGTH_SHORT).show();
                        }
                        assert value != null;
                        if (!value.isEmpty()){
                            for(QueryDocumentSnapshot snapshot : value){
                                user = snapshot.toObject(User.class);
                                String name = snapshot.getString("Role");
                                textView.setText(user.getUserName());

                            }
                        }
                    }
                });
        List<Pair<String, User>> listUser = new ArrayList<>();
        collectionReferenceUser.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        String IdDocument = document.getId();
                        User user = document.toObject(User.class);
                        Pair<String, User> userPair = new Pair<>(IdDocument,user);
                        listUser.add(userPair);
                    }
                    Log.d(TAG, String.valueOf(listUser.size()),task.getException());
                    ListUser listUserInstance = ListUser.getInstance();
                    listUserInstance.setListUser(listUser);
                } else {
                    Log.d(TAG, "Error getting documents: ", task.getException());
                }
            }
        });
        return view;
    }

    @Override
    public void onClick(View v, int pos) {

    }
}
