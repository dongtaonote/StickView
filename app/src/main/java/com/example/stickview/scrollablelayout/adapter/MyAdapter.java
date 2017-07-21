package com.example.stickview.scrollablelayout.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.stickview.R;
import com.example.stickview.scrollablelayout.constant.ColorsConstant;

import java.util.List;

public class MyAdapter extends BaseAdapter {

    private List<String> strList;
    private Context mContext;

    public MyAdapter(Context mContext, List<String> strList) {
        this.strList = strList;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return strList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(mContext).inflate(R.layout.list_item, null, false);
        convertView.setBackgroundColor(mContext.getResources().getColor(ColorsConstant.colors[position % ColorsConstant.colors.length]));
        TextView tv = (TextView) convertView.findViewById(R.id.tv);
        tv.setText(strList.get(position));
        return convertView;
    }
}
