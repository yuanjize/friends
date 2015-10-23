package com.example.friends.friends.fragment;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.friends.friends.R;
import com.example.friends.friends.Utils.DensityUtil;
import com.example.friends.friends.Utils.DrawerLayoutListener;
import com.example.friends.friends.activity.AddCustomActivity;
import com.example.friends.friends.adapter.CustomAdapter;
import com.example.friends.friends.dao.Custom;

import java.util.ArrayList;
import java.util.List;


public class CustomFragment extends Fragment implements AdapterView.OnItemClickListener {
    private FloatingActionButton addCustomer;
    private ListView notFinishList;
    private ListView finishedList;
    private List<Custom> customListNotFinish;
    //    private AddCustomActivity activity;
//    private DrawerLayout drawerLayout;
//    private ActionBarDrawerToggle actionBarDrawerToggle;
    private View view;

    public CustomFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_custom, container, false);
        addCustomer = (FloatingActionButton) view.findViewById(R.id.add_customer);
        addCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//----------------点击进入添加界面
            }
        });
        notFinishList = (ListView) view.findViewById(R.id.not_finish);
        finishedList = (ListView) view.findViewById(R.id.finished);
        //请求数据(习惯极其相关信息)


        //----------------------------
        //---------------------------------------------------------------testcode
        customListNotFinish = new ArrayList<Custom>();
        customListNotFinish.add(new Custom());
        customListNotFinish.add(new Custom());
        customListNotFinish.add(new Custom());
        customListNotFinish.add(new Custom());
        customListNotFinish.add(new Custom());
        customListNotFinish.add(new Custom());
        //--------------------------------------------------------------
        notFinishList.setAdapter(new CustomAdapter(customListNotFinish, getActivity()));
        finishedList.setAdapter(new CustomAdapter(customListNotFinish, getActivity()));
        refreshList(notFinishList);
        refreshList(finishedList);
        notFinishList.setOnItemClickListener(this);
        finishedList.setOnItemClickListener(this);
        init();
        return view;
    }

    private void init() {

    }

    private void refreshList(ListView list) {
        int count = list.getCount();
        ViewGroup.LayoutParams layoutParams = list.getLayoutParams();
        layoutParams.height = (count + 1) * DensityUtil.dip2px(getActivity(), 65f) - DensityUtil.dip2px(getActivity(), 22f);
        list.setLayoutParams(layoutParams);
    }

    //listview条目点击事件。
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //点击进入细节界面

    }

    //数据延迟加载======================================================================

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        if (isVisibleToUser) {
            //==如果对用户可见，就加载数据
        } else {

        }
        super.setUserVisibleHint(isVisibleToUser);
    }

}
