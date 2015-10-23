package com.example.friends.friends.fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.friends.friends.R;
import com.example.friends.friends.Utils.DensityUtil;
import com.example.friends.friends.adapter.CustomAdapter;
import com.example.friends.friends.dao.Custom;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class AttSpecialAttractionFragment extends android.support.v4.app.Fragment implements View.OnClickListener {
    private ListView finishedList;
    private ListView notFinishedList;
    private ImageView notification;
    private ImageView encourage;
    private ImageView fansHead;
    private TextView fansSign;
    private TextView fansName;
    private TextView attentionCheck;
    private List<Custom> customListNotFinish;

    public AttSpecialAttractionFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_att_special_attraction, container, false);
        finishedList = (ListView) view.findViewById(R.id.lover_finished);
        notFinishedList = (ListView) view.findViewById(R.id.lover_not_finish);
        notification = (ImageView) view.findViewById(R.id.notification);
        encourage = (ImageView) view.findViewById(R.id.encourage);
        attentionCheck = (TextView) view.findViewById(R.id.lover_isattention);
        fansName = (TextView) view.findViewById(R.id.lover_name);
        fansSign = (TextView) view.findViewById(R.id.lover_sign);
        fansHead = (ImageView) view.findViewById(R.id.lover_pic);


        attentionCheck.setOnClickListener(this);
        //==================================测试数据
        customListNotFinish = new ArrayList<Custom>();
        customListNotFinish.add(new Custom());
        customListNotFinish.add(new Custom());
        customListNotFinish.add(new Custom());
        customListNotFinish.add(new Custom());
        customListNotFinish.add(new Custom());
        customListNotFinish.add(new Custom());
        //==================================
        notFinishedList.setAdapter(new CustomAdapter(customListNotFinish, getActivity()));
        finishedList.setAdapter(new CustomAdapter(customListNotFinish, getActivity()));
        refreshList(notFinishedList);
        refreshList(finishedList);
        return view;
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

    private void refreshList(ListView list) {
        int count = list.getCount();
        ViewGroup.LayoutParams layoutParams = list.getLayoutParams();
        layoutParams.height = (count + 1) * DensityUtil.dip2px(getActivity(), 65f) - DensityUtil.dip2px(getActivity(), 22f);
        list.setLayoutParams(layoutParams);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.lover_isattention:
                TextView t = (TextView) v;
                if (((TextView) v).getText().toString().equals("关注")) {
                    v.setBackgroundResource(R.drawable.bg_btn_attraction_fans_n);
                    ((TextView) v).setText("取消关注");
                    //========================================需要设置为关注
                } else {
                    v.setBackgroundResource(R.drawable.bg_btn_attraction_fans_h);
                    ((TextView) v).setText("关注");
                    //========================================已经不关注
                }
                break;
        }
    }
}

