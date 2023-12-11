package com.example.projecthk1_2023_2024.NvKho;
import static com.google.firebase.firestore.FirebaseFirestore.*;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.projecthk1_2023_2024.R;
import com.example.projecthk1_2023_2024.NvKho.Report.*;
import com.example.projecthk1_2023_2024.model.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class NvkFragReport extends Fragment {
    LinearLayout tkNhap, tkXuat, tkSP;
    TextView txtName;
    private User user;
    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener authStateListener;
    private FirebaseFirestore db = getInstance();
    private CollectionReference collectionReferenceUser = db.collection("User");
    private FirebaseUser currentUser;
    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.nvkho_frag_report_layout, container, false);
        txtName = view.findViewById(R.id.nameReport);
        tkNhap = view.findViewById(R.id.func_tk_nhap);
        firebaseAuth = FirebaseAuth.getInstance();
        currentUser = firebaseAuth.getCurrentUser();
        String loginId = currentUser.getUid();
        tkNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), Acti_TK_PN.class);
                startActivity(i);
            }
        });

        tkXuat = view.findViewById(R.id.func_tk_xuat);
        tkXuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), Acti_TK_PX.class);
                startActivity(i);
            }
        });

        tkSP = view.findViewById(R.id.func_tk_sp);
        tkSP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), Acti_TK_SP.class);
                startActivity(i);
            }
        });

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
                                txtName.setText(user.getUserName());

                            }
                        }
                    }
                });

        return view;
    }
}
