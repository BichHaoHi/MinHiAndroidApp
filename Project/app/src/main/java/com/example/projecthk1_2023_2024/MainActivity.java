package com.example.projecthk1_2023_2024;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.projecthk1_2023_2024.Util.AuUser;
import com.example.projecthk1_2023_2024.admin.AdminActivity;
import com.example.projecthk1_2023_2024.kho.NvkhoActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
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
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
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
                                                    String role = snapshot.getString("Role");
                                                    AuUser auUser = AuUser.getInstance();
                                                    auUser.setUserId(snapshot.getString("LoginID"));
                                                    auUser.setUsername(snapshot.getString("Name"));
                                                    if ("Admin".equals(role)) {
                                                        startActivity(new Intent(MainActivity.this, AdminActivity.class));
                                                    } else {
                                                        startActivity(new Intent(MainActivity.this, NvkhoActivity.class));
                                                    }

                                                }
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