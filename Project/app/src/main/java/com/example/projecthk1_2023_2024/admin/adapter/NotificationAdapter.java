package com.example.projecthk1_2023_2024.admin.adapter;

import android.content.Context;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projecthk1_2023_2024.R;
import com.example.projecthk1_2023_2024.model.Notification;
import com.google.firebase.Timestamp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.MyViewHolder> {
    Context context;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference collectionReference = db.collection("Notification");
    private List<Pair<String, Notification>> listNotification;

    public NotificationAdapter(Context context, List<Pair<String, Notification>> listNotification) {
        this.context = context;
        this.listNotification = listNotification;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.viewholder_notification,parent,false);
        return new MyViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Pair<String, Notification> notificationPair = listNotification.get(position);
        holder.desc.setText(notificationPair.second.getDescription());
        holder.time.setText(StampToString(notificationPair.second.getDate_Create()));
    }

    private String StampToString(Timestamp timestamp) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        Date date = timestamp.toDate();
        return dateFormat.format(date);
    }

    @Override
    public int getItemCount() {
        return listNotification.size();
    }
    public List<Pair<String, Notification>> getListDisable(){
        List<Pair<String, Notification>> res = new ArrayList<>();
        for (Pair<String, Notification> notification : listNotification){
            if (notification.second.getEnable()==false) res.add(notification);
        }
        return res;
    }
    public List<Pair<String, Notification>> getListEnable(){
        List<Pair<String, Notification>> res = new ArrayList<>();
        for (Pair<String, Notification> notification : listNotification){
            if (notification.second.getEnable()==true) res.add(notification);
        }
        return res;
    }
    public void sortStatus(){
        Collections.sort(listNotification, new Comparator<Pair<String, Notification>>() {
            @Override
            public int compare(Pair<String, Notification> pair1, Pair<String, Notification> pair2) {
                // So sánh theo trạng thái isEnable
                boolean isEnable1 = pair1.second.getEnable();
                boolean isEnable2 = pair2.second.getEnable();

                // Đẩy các phần tử có isEnable == true lên đầu tiên
                if (isEnable1 && !isEnable2) {
                    return -1;
                } else if (!isEnable1 && isEnable2) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });

    }
    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView desc, time;

        public MyViewHolder(@NonNull View itemView, Context ctx) {
            super(itemView);
            context = ctx;
            desc = itemView.findViewById(R.id.textDesc);
            time = itemView.findViewById(R.id.textDate);
        }
    }




}
