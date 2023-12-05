package com.example.projecthk1_2023_2024.NvKho;

import static com.example.projecthk1_2023_2024.NvKho.NvkFragHome.isImgBack;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.bumptech.glide.Glide;
import com.example.projecthk1_2023_2024.Admin.SettingAdminActivity;
import com.example.projecthk1_2023_2024.MainActivity;
import com.example.projecthk1_2023_2024.NvKho.FuncNhapHang.Func_qlNhapHangActivity;
import com.example.projecthk1_2023_2024.R;
import com.example.projecthk1_2023_2024.Util.AuUser;
import com.example.projecthk1_2023_2024.model.User;
import com.google.firebase.Timestamp;
import com.google.firebase.auth.FirebaseAuth;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NvkFragSetting extends Fragment {


    ImageView img, back, imgHome, imgSetting;
    TextView nameView, phoneView, sexView, startView, roleView;
    Button btnLogOut;
    private FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.detail_nv, container, false);
        img = view.findViewById(R.id.avt_nv);
        phoneView = view.findViewById(R.id.Text_phone);
        nameView = view.findViewById(R.id.Name);
        sexView = view.findViewById(R.id.Text_sex);
        startView = view.findViewById(R.id.Text_start_date);
        roleView = view.findViewById(R.id.Text_role);
        back = view.findViewById(R.id.back);
        btnLogOut = view.findViewById(R.id.btnLogout);

        imgHome = view.findViewById(R.id.imgHome);
        imgSetting = view.findViewById(R.id.imgSetting);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goBack();

            }
        });
        AuUser auUser = AuUser.getInstance();

        User user = auUser.getUser();
        /**
         *  Using Glide Library to Display the images
         * */

        Glide.with(getContext())
                .load(user.getImage())
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
                Intent intent = new Intent(getContext(), MainActivity.class);

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
    private void goBack() {
        // Tạo một FragmentTransaction
        FragmentTransaction transaction = getParentFragmentManager().beginTransaction();

        // Thay thế Fragment hiện tại bằng Fragment mới (có thể là Fragment trước đó)
        transaction.replace(R.id.cons_trans_frag, new NvkFragHome());

        // Thực hiện giao dịch
        transaction.commit();

        NvkFragHome fragHome = new NvkFragHome();
        fragHome.isImgBack = true;
        updateIconFragment();

    }

    private void updateIconFragment() {
        if (imgHome != null) {
            if (isImgBack) {
                imgHome.setImageResource(R.drawable.ic_home_run);
                imgSetting.setImageResource(R.drawable.ic_menu);
            } else {
                imgHome.setImageResource(R.drawable.ic_home);
                imgSetting.setImageResource(R.drawable.ic_menu_run);
            }
        }
    }


}


