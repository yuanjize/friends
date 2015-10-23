package com.example.friends.friends.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.friends.friends.R;
import com.example.friends.friends.dao.Custom;

import java.util.List;

/**
 * Created by yjz on 2015/9/24.
 */
public class CustomAdapter extends BaseAdapter {
    private List<Custom> customList;
    private Context ctx;
    private LayoutInflater inflater;

    public int getLenth() {
        return lenth;
    }

    private int lenth;

    public CustomAdapter(List<Custom> customList, Context ctx) {
        this.customList = customList;
        this.ctx = ctx;
        inflater = LayoutInflater.from(ctx);
    }

    @Override
    public int getCount() {
        return customList.size();
    }

    @Override
    public Object getItem(int position) {
        return customList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.customer_simple_item, parent, false);
            viewHolder.customName = (TextView) convertView.findViewById(R.id.custom_name);
            viewHolder.customDay = (TextView) convertView.findViewById(R.id.custom_day);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.customName.setText(customList.get(position).getCustomName());
        viewHolder.customDay.setText(customList.get(position).getInsistDays());
        return convertView;
    }

    private class ViewHolder {
        public TextView customName;
        public TextView customDay;
    }
}
