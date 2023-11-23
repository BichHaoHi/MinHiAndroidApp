package com.example.projecthk1_2023_2024;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.projecthk1_2023_2024.NvKho.NvkActivity;
import com.example.projecthk1_2023_2024.Util.AuUser;
import com.example.projecthk1_2023_2024.Admin.AdminActivity;
import com.example.projecthk1_2023_2024.model.User;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class MainActivity extends AppCompatActivity {

    EditText emailEDT, passEDT;
    Button btnLogin, forgot;
    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener authStateListener;
    private FirebaseUser currentUser;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference collectionReference = db.collection("User");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
//        firebaseAuth.signOut();
        emailEDT = findViewById(R.id.edtEmail);
        passEDT = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        forgot = findViewById(R.id.btnForgetPass);
        firebaseAuth = FirebaseAuth.getInstance();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginEmailPasswordUser(
                        emailEDT.getText().toString().trim(),
                        passEDT.getText().toString().trim()
                );
            }
        });

        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ForgetPassActivity.class));
            }
        });
    }
    private void LoginEmailPasswordUser(String email, String password) {
        if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)){
            firebaseAuth.signInWithEmailAndPassword(email,password)
                    .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {
                            FirebaseUser user = firebaseAuth.getCurrentUser();
                            final String currentUserId = user.getUid();
                            collectionReference.whereEqualTo("LoginID",currentUserId)
                                    .addSnapshotListener(new EventListener<QuerySnapshot>() {
                                        @Override
                                        public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                                            if (error != null){
                                                Toast.makeText(MainActivity.this, error.getMessage() + "Line 71", Toast.LENGTH_SHORT).show();
                                            }


                                            assert value != null;
                                            if (!value.isEmpty()){
                                                for(QueryDocumentSnapshot snapshot : value){
                                                    User user = snapshot.toObject(User.class);
                                                    String role = snapshot.getString("Role");
                                                    AuUser auUser = AuUser.getInstance();
                                                    auUser.setUser(user);
                                                    Log.d(TAG,role);
                                                    if ("Admin".equals(role) && user.getEnable()) {
                                                        startActivity(new Intent(MainActivity.this, AdminActivity.class));
                                                    } else if ("Kho".equals(role) && user.getEnable()) {
                                                        startActivity(new Intent(MainActivity.this, NvkActivity.class));
                                                    }

                                                }
                                            } else{
                                                Toast.makeText(MainActivity.this, "Disable Login", Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    });

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(MainActivity.this, "Password or Email wrong!!", Toast.LENGTH_SHORT).show();
                        }
                    });
        } else {
            Toast.makeText(this, "Please Enter Fulfil Field!", Toast.LENGTH_SHORT).show();
        }
    }
}