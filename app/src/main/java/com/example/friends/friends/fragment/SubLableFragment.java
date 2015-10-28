package com.example.friends.friends.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import com.example.friends.friends.R;
import com.example.friends.friends.activity.ManageLabbleActivity;
import com.example.friends.friends.activity.Register2Activity;
import com.example.friends.friends.dao.Flags;

import java.util.ArrayList;
import java.util.List;

public class SubLableFragment extends Fragment {
    private ArrayList<String> labbles;
    private GridView gridView;
    private Myadapter adapter;

    private TextView manageLabbile;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        if (isVisible()) {
            if (adapter == null) {
                adapter = new Myadapter();
                if (labbles == null) {
                    labbles = new ArrayList<>();
                    labbles.add("宅男");
                    labbles.add("宅女");
                    labbles.add("怪蜀黍");
                    labbles.add("萝莉控");
                    labbles.add("鬼舞者");
                    labbles.add("神经病");
                    labbles.add("闷骚客");
                    labbles.add("怪胎");
                    labbles.add("腹肌男");
                }
            }
            gridView.setAdapter(adapter);
            gridView.invalidate();
        } else {

        }

        super.setUserVisibleHint(isVisibleToUser);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sub_lable, container, false);
        manageLabbile = (TextView) view.findViewById(R.id.manage_labble);
        manageLabbile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), ManageLabbleActivity.class);
                intent.putExtra("labbles", labbles);
                startActivityForResult(intent, Flags.MANAGELABLE);
            }
        });
        gridView = (GridView) view.findViewById(R.id.my_girdview);
        return view;
    }

    class Myadapter extends BaseAdapter {

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
                convertView = View.inflate(getActivity(), R.layout.my_labble_item, null);
                labble = (TextView) convertView.findViewById(R.id.my_labble);
                convertView.setTag(labble);
            } else {
                labble = (TextView) convertView.getTag();
            }
            labble.setText(labbles.get(position));
            return convertView;
        }
    }
}
