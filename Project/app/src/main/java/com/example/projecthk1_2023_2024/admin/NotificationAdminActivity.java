package com.example.projecthk1_2023_2024.Admin;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projecthk1_2023_2024.R;
import com.example.projecthk1_2023_2024.Admin.adapter.NotificationAdapter;
import com.example.projecthk1_2023_2024.Admin.clickhandler.ItemClick;
import com.example.projecthk1_2023_2024.model.Notification;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class NotificationAdminActivity extends AppCompatActivity implements ItemClick {
    CoordinatorLayout coordinatorLayout;
    RecyclerView recyclerView;
    private CollectionReference collectionReference = FirebaseFirestore.getInstance().collection("Notification");
    private FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
    private List<Pair<String, Notification>> listNotification = new ArrayList<>();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification);
        recyclerView = findViewById(R.id.recyclerViewTB);
        coordinatorLayout = findViewById(R.id.coordinateLayout);
        CoordinateBar.setCoordinateBar(coordinatorLayout);
        CoordinateBar.setEventBar(getApplicationContext());
        collectionReference.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        String IdDocument = document.getId();
                        Notification notification = document.toObject(Notification.class);
                        Pair<String, Notification> notificationPair = new Pair<>(IdDocument,notification);
                        listNotification.add(notificationPair);
                        NotificationAdapter adapter = new NotificationAdapter(NotificationAdminActivity.this,listNotification);
                        adapter.sortStatus();
                        recyclerView.setLayoutManager(new LinearLayoutManager(NotificationAdminActivity.this));
                        recyclerView.setAdapter(adapter);
                        recyclerView.getAdapter().notifyDataSetChanged();
                    }
                } else {
                    Log.d(TAG, "Error getting documents: ", task.getException());
                }
            }
        });

    }

    @Override
    public void onClick(View v, int pos) {

    }
}
