package com.example.projecthk1_2023_2024.Admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.projecthk1_2023_2024.MainActivity;
import com.example.projecthk1_2023_2024.R;
import com.example.projecthk1_2023_2024.Util.AuUser;
import com.example.projecthk1_2023_2024.model.User;
import com.google.firebase.Timestamp;
import com.google.firebase.auth.FirebaseAuth;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SettingAdminActivity extends Fragment {// extends Fragment mới dùng được Fragmnet
    ImageView img, back;
    TextView nameView, phoneView, sexView, startView, roleView;
    Button btnLogOut;
    private FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.detail_nv,container,false);
        img = view.findViewById(R.id.avt_nv);
        phoneView = view.findViewById(R.id.Text_phone);
        nameView = view.findViewById(R.id.Name);
        sexView = view.findViewById(R.id.Text_sex);
        startView = view.findViewById(R.id.Text_start_date);
        roleView = view.findViewById(R.id.Text_role);
        back = view.findViewById(R.id.back);
        btnLogOut = view.findViewById(R.id.btnLogout);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });
        AuUser auUser = AuUser.getInstance();

        User user = auUser.getUser();
        /**
         *  Using Glide Library to Display the images
         * */

        Glide.with(this)
                .load(user.getImage())
                //.placeholder()
                .fitCenter()
                .into(img);
        nameView.setText(user.getUserName());
        phoneView.setText(user.getPhone());
        sexView.setText(user.getSex());
        startView.setText(ChangeDaytoString(user.getStart_Date()));
        roleView.setText(user.getRole());

        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.signOut();
                Intent intent = new Intent(getActivity(), MainActivity.class);

                // Đặt cờ để xóa hết Activity khác và tạo ngăn xếp mới
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                startActivity(intent);

            }
        });
        return view;
    }

    private String ChangeDaytoString(Timestamp startDate) {
        Date date = startDate.toDate();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String dateString = sdf.format(date);
        return dateString;
    }


}
