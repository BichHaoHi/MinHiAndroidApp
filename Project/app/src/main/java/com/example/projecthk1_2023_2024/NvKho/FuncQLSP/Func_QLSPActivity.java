package com.example.projecthk1_2023_2024.NvKho.FuncQLSP;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.projecthk1_2023_2024.NvKho.FuncPlace.AdapterKhu;
import com.example.projecthk1_2023_2024.NvKho.NvkFragHome;
import com.example.projecthk1_2023_2024.R;
import com.example.projecthk1_2023_2024.Util.Khu;
import com.example.projecthk1_2023_2024.Util.QLSP;
import java.util.ArrayList;
import java.util.List;

public class Func_QLSPActivity extends AppCompatActivity {

    ImageView back;
    AdapterQLSP adapter;
    RecyclerView recyPhieuSP;
    ArrayList<QLSP> arrP;

    EditText edtSearch;

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nvkho_func4_qlsp_layout);

        // 1. xu ly back
        back = findViewById(R.id.back_home1);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Func_QLSPActivity.this, NvkFragHome.class);
                startActivity(i);
            }
        });
        //2. xu ly hien thi space kho
        recyPhieuSP = findViewById(R.id.recy_phieuSP_f4);
        arrP = new ArrayList<QLSP>();
        QLSP p1 = new QLSP("Sửa rửa mặt", "ML001", "100", "Đợi xuất hàng", "25/12/2030");
        QLSP p2 = new QLSP("Sửa rửa mặt2", "ML002", "200", "Đã xuất hàng", "25/12/2030");
        arrP.add(p1);
        arrP.add(p2);
        adapter = new AdapterQLSP(arrP); // Khởi tạo adapter
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyPhieuSP.setLayoutManager(layoutManager);
        recyPhieuSP.setAdapter(adapter);
        // sử lý Search
        edtSearch = findViewById(R.id.search_qlysp);
        edtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                // Khi người dùng thay đổi nội dung trong EditText, lọc danh sách người dùng theo từ khóa
                String query = charSequence.toString().toLowerCase();
                ArrayList<QLSP> filteredList = new ArrayList<>();

                for (QLSP pSP : arrP) {
                    if (pSP.getTenSP().toLowerCase().contains(query)) {
                        filteredList.add(pSP);
                    }
                }

                adapter.filterList(filteredList); // Cập nhật RecyclerView với danh sách lọc
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
    }
}
