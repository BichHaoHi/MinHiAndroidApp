package com.example.projecthk1_2023_2024.admin;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projecthk1_2023_2024.R;
import com.example.projecthk1_2023_2024.Util.ListUser;
import com.example.projecthk1_2023_2024.admin.adapter.NotificationAdapter;
import com.example.projecthk1_2023_2024.admin.adapter.UserAdapter;
import com.example.projecthk1_2023_2024.admin.clickhandler.ItemClick;
import com.example.projecthk1_2023_2024.model.Notification;
import com.example.projecthk1_2023_2024.model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class UserAdminActivity extends AppCompatActivity implements ItemClick {
    RecyclerView recyclerView;
    private FirebaseFirestore firestore = FirebaseFirestore.getInstance();
    private CollectionReference collectionReference = firestore.collection("User");
    private List<Pair<String, User>> listUser = new ArrayList<>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nhan_vien);
        recyclerView = findViewById(R.id.recyclerViewNV);

        collectionReference.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
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
                    recyclerView.setLayoutManager(new LinearLayoutManager(UserAdminActivity.this));
                    recyclerView.setAdapter(new UserAdapter(listUser,UserAdminActivity.this));
                    recyclerView.getAdapter().notifyDataSetChanged();
                } else {
                    Log.d(TAG, "Error getting documents: ", task.getException());
                }
            }
        });
    }

    @Override
    public void onClick(View v,int pos) {
        Toast.makeText(this, "Choose" + listUser.get(pos).first, Toast.LENGTH_SHORT).show();
    }
}
