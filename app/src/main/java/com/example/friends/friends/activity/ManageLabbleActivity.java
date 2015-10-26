package com.example.friends.friends.activity;

import android.os.Bundle;
import android.app.Activity;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.friends.friends.R;
import com.example.friends.friends.dao.Flags;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ManageLabbleActivity extends Activity implements View.OnClickListener {
    private GridView abbleView;
    private GridView addedAbbleView;
    private List<String> abbleName;
    private ArrayList<String> addedAbbleName;
    private MyAdapter abbleViewAdapter;
    private MyAdapter addedViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_labble);
        init();
    }

    private void init() {
        abbleView = (GridView) findViewById(R.id.labble_name);
        addedAbbleView = (GridView) findViewById(R.id.labble_added);
        if (abbleName == null) {
            abbleName = Arrays.asList("文青", "慢跑狂", "球控", "手绘", "嗜睡症", "摄影", "书法帝", "腹肌撕", "强迫症", "吃货");
            if (addedAbbleName == null) {
                addedAbbleName = (ArrayList<String>) getIntent().getSerializableExtra("labbles");
                if (addedAbbleName == null) {
                    Toast.makeText(ManageLabbleActivity.this, "网络错误", Toast.LENGTH_SHORT).show();
                    addedAbbleName = new ArrayList<>();
                }
            }
        }
        if (abbleViewAdapter == null) {
            abbleViewAdapter = new MyAdapter(Flags.LABBLELIST);
        }
        if (addedViewAdapter == null) {
            addedViewAdapter = new MyAdapter(Flags.ADDEDLABBLELIST);
        }

        abbleView.setAdapter(abbleViewAdapter);
        addedAbbleView.setAdapter(addedViewAdapter);
    }

    @Override
    public void onClick(View v) {
        TextView text = (TextView) v;
        String content = text.getText().toString();
        switch (v.getId()) {
            case R.id.my_labble:
                if (!addedAbbleName.contains(content)) {
                    addedAbbleName.add(content);
                    addedViewAdapter.notifyDataSetInvalidated();
                }
                break;
            case R.id.my_add_labble:
                addedAbbleName.remove(content);
                addedViewAdapter.notifyDataSetInvalidated();
                break;
        }
    }

    class MyAdapter extends BaseAdapter {
        List<String> labbles;
        private int flage;

        public MyAdapter(int flage) {
            this.flage = flage;
            if (flage == Flags.LABBLELIST) {
                this.labbles = abbleName;
            } else {
                this.labbles = addedAbbleName;
            }
        }

        @Override
        public int getCount() {
            return labbles.size();
        }

        @Override
        public Object getItem(int position) {
            return labbles.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView labble = null;
            if (convertView == null) {
                if (flage == Flags.LABBLELIST) {
                    convertView = View.inflate(getApplicationContext(), R.layout.my_labble_item, null);
                    labble = (TextView) convertView.findViewById(R.id.my_labble);
                    convertView.setTag(labble);
                } else {
                    convertView = View.inflate(getApplicationContext(), R.layout.my_added_labble_item, null);
                    labble = (TextView) convertView.findViewById(R.id.my_add_labble);
                    convertView.setTag(labble);
                }
            } else {
                labble = (TextView) convertView.getTag();
            }
            labble.setText(labbles.get(position));
            labble.setOnClickListener(ManageLabbleActivity.this);
            return convertView;
        }
    }
}
