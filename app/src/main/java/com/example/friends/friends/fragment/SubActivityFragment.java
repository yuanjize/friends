package com.example.friends.friends.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.friends.friends.R;
import com.example.friends.friends.dao.ActivityItem;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.ArrayList;
import java.util.List;


public class SubActivityFragment extends Fragment {
    private ListView listView;
    private List<ActivityItem> data;
    private MyAdapter myAdapter;
    private TextView running;
    private TextView lunchTime;

    public SubActivityFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sub_activity, container, false);
        listView = (ListView) view.findViewById(R.id.activity_list);
        return view;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        if (isVisible()) {
            if (data == null) {
                data = new ArrayList<>();
                data.add(new ActivityItem("西电大扫除", "明早九点北门集合，记得带手机", false, "1月23日", null, "西电大黄"));
                data.add(new ActivityItem("西电大扫除", "明早九点北门集合，记得带手机", true, "1月23日", null, "西电大黄"));
                data.add(new ActivityItem("西电大扫除", "明早九点北门集合，记得带手机", false, "1月23日", null, "西电大黄"));
                data.add(new ActivityItem("西电大扫除", "明早九点北门集合，记得带手机", true, "1月23日", null, "西电大黄"));
                data.add(new ActivityItem("西电大扫除", "明早九点北门集合，记得带手机", false, "1月23日", null, "西电大黄"));
                data.add(new ActivityItem("西电大扫除", "明早九点北门集合，记得带手机", true, "1月23日", null, "西电大黄"));
                data.add(new ActivityItem("西电大扫除", "明早九点北门集合，记得带手机", false, "1月23日", null, "西电大黄"));
                data.add(new ActivityItem("西电大扫除", "明早九点北门集合，记得带手机", true, "1月23日", null, "西电大黄"));
            }
            if (myAdapter == null) {
                myAdapter = new MyAdapter();
                listView.setAdapter(myAdapter);
            }
        } else {

        }
        super.setUserVisibleHint(isVisibleToUser);
    }

    class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public Object getItem(int position) {
            return data.get(position);
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
                convertView = View.inflate(getActivity(), R.layout.activity_item, null);
                viewHolder.activityName = (TextView) convertView.findViewById(R.id.activity_name);
                viewHolder.content = (TextView) convertView.findViewById(R.id.activity_content);
                viewHolder.userHead = (ImageView) convertView.findViewById(R.id.activity_user_head);
                viewHolder.userName = (TextView) convertView.findViewById(R.id.activity_user_name);
                viewHolder.launvhTime = (TextView) convertView.findViewById(R.id.activity_lunch_date);
                viewHolder.isRunning = (TextView) convertView.findViewById(R.id.running);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            viewHolder.activityName.setText(data.get(position).getActivityName());
            viewHolder.content.setText(data.get(position).getContent());
            viewHolder.userName.setText(data.get(position).getUserName());
            viewHolder.launvhTime.setText(data.get(position).getTime());
            setIsRunning(data.get(position).isRunning(), viewHolder.isRunning);

            //====================test
            DisplayImageOptions options1 = new DisplayImageOptions.Builder().showImageForEmptyUri(R.mipmap.pic_head4_196px).build();
            ImageLoader loader = ImageLoader.getInstance();
            ImageLoaderConfiguration i = ImageLoaderConfiguration.createDefault(getActivity());
            loader.init(i);
            loader.displayImage(null, viewHolder.userHead, options1);
            //====================test


            return convertView;
        }

        private void setIsRunning(boolean running, TextView isRunning) {
            if (running) {
                isRunning.setVisibility(View.VISIBLE);
            } else {
                isRunning.setVisibility(View.GONE);
            }
        }

        class ViewHolder {
            public ImageView userHead;
            public TextView userName;
            public TextView activityName;
            public TextView content;
            public TextView launvhTime;
            public TextView isRunning;
        }
    }
}
