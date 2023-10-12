package com.example.appmanager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class NoticeCusActivity extends ArrayAdapter<String> {

    private Context context;
    private ArrayList<String> items;

    public NoticeCusActivity(ArrayList<String> strings, Context context) {
        super(context,R.layout.notice_layout, strings);
    }

    //    @Override
//    public int getCount() {
//        return items.length;
//    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String s = getItem(position);
        ViewHolder viewholder;
        final View result;
        if(convertView == null){
            viewholder = new ViewHolder();
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.notice_box, parent, false);
            viewholder.textView = convertView.findViewById(R.id.noticeBox);
            convertView.setTag(viewholder);
            result = convertView;
        }
        else{
            viewholder = (ViewHolder) convertView.getTag();
            result = convertView;
        }
        viewholder.textView.setText(s);
        return result;
    }
    static class ViewHolder{
        TextView textView;
    }
}
