package com.example.projecthk1_2023_2024.admin.activityuser;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projecthk1_2023_2024.R;
import com.example.projecthk1_2023_2024.Util.ListUser;
import com.example.projecthk1_2023_2024.admin.adapter.UserAdapter;
import com.example.projecthk1_2023_2024.admin.clickhandler.ItemClick;
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
                    UserAdapter adapter = new UserAdapter(listUser,UserAdminActivity.this);
                    recyclerView.setAdapter(adapter);
                    adapter.setClickListener(UserAdminActivity.this);
                    recyclerView.getAdapter().notifyDataSetChanged();

                } else {
                    Log.d(TAG, "Error getting documents: ", task.getException());
                }
            }
        });
    }

    @Override
    public void onClick(View v,int pos) {
        Intent i = new Intent(this, UserDetailActivity.class);
        i.putExtra("IdUser", listUser.get(pos).first);
        startActivity(i);
    }
}
