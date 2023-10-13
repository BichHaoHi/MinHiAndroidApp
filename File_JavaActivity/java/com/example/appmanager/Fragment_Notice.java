package com.example.appmanager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class Fragment_Notice extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notice_layout, container, false);
            ListView lv_tb = view.findViewById(R.id.listViewNotice);
        ArrayList<Tbao> tb = new ArrayList<>();
        tb.add(new Tbao("Thông báo nhâp hàng","Hihi"));
        tb.add(new Tbao("Thông báo xuất hàng","Hahaa"));
        tb.add(new Tbao("Thông báo mới","Huhuhu"));


        NoticeCusActivity adapter = new NoticeCusActivity(tb, getContext());
        lv_tb.setAdapter(adapter);
        return view;
    }

    }
