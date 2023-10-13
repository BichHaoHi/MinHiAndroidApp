package com.example.appmanager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment_Report extends Fragment {
    LinearLayout tkNhap, tkXuat;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_report_layout, container, false);
//        tkNhap = view.findViewById(R.id.func_tk_nhap);
//        tkNhap.setOnClickListener(new View.OnClickListener() {
//        });

        return view;
    }
}
