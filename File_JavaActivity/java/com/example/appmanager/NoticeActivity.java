package com.example.appmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class NoticeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notice_layout);

//2. Khởi tạo ListView và tìm kiếm listView theo id

        ListView listViewNotice = (ListView)findViewById(R.id.listViewNotice);
//3. Tạo ra đối tượng chứa thông tin data cần đổ vào,LÀ KIỂU MẢNG,có thể lấy từ database qua các câu lệnh truy vấn
        ArrayList<Tbao> noticeArr = new ArrayList<Tbao>();

        //3.1.Cho đối tượng có thiết kế layout con
        NoticeCusActivity adapterNotice = new NoticeCusActivity(noticeArr, getApplicationContext());
//4. Đổ dữ liệu từ mảng vừa tạo vào thùng chứa là AdapterView: có các phương thức truyền vào là this, lớp layout đổ dữ liệu, arrdata của bạn
//        ArrayAdapter<String> adapterNotice = new ArrayAdapter<>
//                (this, android.R.layout.simple_list_item_1,
//                        noticeArr);
//5. Áp dụng phương thức cho đối tượng
        listViewNotice.setAdapter((ListAdapter) adapterNotice);

    }
}