package com.example.projecthk1_2023_2024.Admin.adapter;

import android.content.Context;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.projecthk1_2023_2024.R;
import com.example.projecthk1_2023_2024.Admin.clickhandler.ItemClick;
import com.example.projecthk1_2023_2024.model.User;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    Context context;
    ItemClick itemClick;
    private List<Pair<String, User>> listUser;

    public UserAdapter(List<Pair<String, User>> listUser,Context context) {
        this.listUser = listUser;
        this.context = context;
    }
    public void setClickListener(ItemClick itemClick){
        this.itemClick = itemClick;
    }

    public List<Pair<String, User>> getListUser() {
        return listUser;
    }

    public void setListUser(List<Pair<String, User>> listUser) {
        this.listUser = listUser;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_view_nhanvien,parent,false);
        return new UserViewHolder(itemView,context);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        Pair<String, User> user = listUser.get(position);
        holder.name.setText(user.second.getUserName());
        holder.email.setText(user.second.getEmail());
        holder.create_date.setText(user.second.StampToString(user.second.getStart_Date()));
        String imageUrl = user.second.getImage();
        /**
         *  Using Glide Library to Display the images
         * */


        Glide.with(context)
                .load(imageUrl)
                //.placeholder()
                .fitCenter()
                .into(holder.img);
        if (user.second.getEnable()==false){
            holder.disable.setVisibility(View.VISIBLE);
            holder.enable.setVisibility(View.GONE);
        }else{
            holder.disable.setVisibility(View.GONE);
            holder.enable.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return listUser.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView name, email, enable,disable, create_date;
        ImageView img;

        public UserViewHolder(@NonNull View itemView, Context cxt) {
            super(itemView);
            context = cxt;
            name = itemView.findViewById(R.id.name_nv);
            email = itemView.findViewById(R.id.email_nv);
            enable = itemView.findViewById(R.id.status_nv_enable);
            disable = itemView.findViewById(R.id.status_nv_disable);
            img = itemView.findViewById(R.id.avt_nv);
            create_date = itemView.findViewById(R.id.textDate_start);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(itemClick!=null){
                itemClick.onClick(v,getAdapterPosition());
            }
        }
    }
}
