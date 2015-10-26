package com.example.friends.friends.fragment;


import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.friends.friends.R;
import com.example.friends.friends.Utils.DensityUtil;
import com.example.friends.friends.Utils.SpanTextUtils;
import com.example.friends.friends.dao.SubCusotmItem;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class SubCustomFragment extends Fragment {
    private RecyclerView recyclerView;
    private List<SubCusotmItem> data;
    private Myadapter adapter;

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        if (isVisible()) {
            if (adapter == null) {
                adapter = new Myadapter();
                if (data == null) {
                    data = new ArrayList<>();
                    data.add(new SubCusotmItem("吃早饭", 12, null));
                    data.add(new SubCusotmItem("跑步", 12, null));
                    data.add(new SubCusotmItem("听音乐", 12, null));
                    data.add(new SubCusotmItem("打篮球", 12, null));
                    data.add(new SubCusotmItem("上课", 12, null));
                    data.add(new SubCusotmItem("早睡", 12, null));
                    data.add(new SubCusotmItem("早起", 12, null));
                }
            }
            recyclerView.setAdapter(adapter);
            recyclerView.invalidate();
        } else {

        }
        super.setUserVisibleHint(isVisibleToUser);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sub_custom, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.sub_custom_recycleview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return view;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView pic1;
        public ImageView pic2;
        public ImageView pic3;
        public TextView customName;
        public TextView insistDay;

        public ViewHolder(View itemView) {
            super(itemView);
            pic1 = (ImageView) itemView.findViewById(R.id.custom_pic1);
            pic2 = (ImageView) itemView.findViewById(R.id.custom_pic2);
            pic3 = (ImageView) itemView.findViewById(R.id.custom_pic3);

            customName = (TextView) itemView.findViewById(R.id.custom_name);
            insistDay = (TextView) itemView.findViewById(R.id.custom_insist_day);
        }

    }

    class Myadapter extends RecyclerView.Adapter<ViewHolder> {

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            ViewHolder viewHolder = new ViewHolder(View.inflate(getActivity(), R.layout.sub_custom_item, null));
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            int day = data.get(position).getInsistDay();
            Spannable insistDay = SpanTextUtils.getSpanText(getActivity(), "已坚持" + day + "天", DensityUtil.dip2px(getActivity(), 20), 3, 3 + String.valueOf(day).length(), Color.GREEN);
            holder.insistDay.setText(insistDay);
            holder.customName.setText(data.get(position).getCustomName());
            //===================test
            holder.pic1.setImageResource(R.mipmap.pic_dynamic_detail);
            holder.pic2.setImageResource(R.mipmap.pic_dynamic_detail);
            holder.pic3.setImageResource(R.mipmap.pic_dynamic_detail);
            //===================test
            ViewGroup.LayoutParams layoutParams = holder.pic1.getLayoutParams();
            WindowManager windowManager = (WindowManager) getActivity().getSystemService(Context.WINDOW_SERVICE);
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            int width = displayMetrics.widthPixels - DensityUtil.dip2px(getActivity(), 38);
//            System.out.println("width=" + width);
//            System.out.println("layoutParams.height=" + layoutParams.height);//            System.out.println("layoutParams.width=" + layoutParams.width);
            layoutParams.height = width / 3;
            holder.pic1.setLayoutParams(layoutParams);
            holder.pic2.setLayoutParams(layoutParams);
            holder.pic3.setLayoutParams(layoutParams);

        }

        @Override
        public int getItemCount() {
            return data.size();
        }
    }

}
