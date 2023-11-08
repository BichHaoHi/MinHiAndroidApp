package com.example.projecthk1_2023_2024.NvKho.Report;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.projecthk1_2023_2024.R;
import com.example.projecthk1_2023_2024.NvKho.Report.*;

public class NvkFragReport extends Fragment {
    LinearLayout tkNhap, tkXuat, tkSP;
    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.nvkho_frag_report_layout, container, false);
        tkNhap = view.findViewById(R.id.func_tk_nhap);
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

        return view;
    }
}
