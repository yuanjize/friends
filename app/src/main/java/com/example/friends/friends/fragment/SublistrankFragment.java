package com.example.friends.friends.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Spannable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.friends.friends.R;
import com.example.friends.friends.Utils.SpanTextUtils;
import com.example.friends.friends.dao.RankItem;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.ArrayList;
import java.util.List;


public class SublistrankFragment extends Fragment {
    private ListView rankList;
    private TextView insistDay;
    private TextView rank;
    private List<RankItem> list;
    private MyAdapter adapter;
    private int day = 0;
    private int ranknumber = 1;

    public SublistrankFragment() {

    }

    //===========================加载数据
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        if (isVisible()) {
            if (list == null) {
                list = new ArrayList<>();
                //=====================test
                list.add(new RankItem(null, "我是第一"));
                list.add(new RankItem(null, "我是第一"));
                list.add(new RankItem(null, "我是第一"));
                list.add(new RankItem(null, "我是第一"));
                list.add(new RankItem(null, "我是第一"));
                list.add(new RankItem(null, "我是第一"));
                list.add(new RankItem(null, "我是第一"));
                list.add(new RankItem(null, "我是第一"));
                //======================test
            }
            if (adapter == null) {
                adapter = new MyAdapter();
            }
            rankList.setAdapter(adapter);

/*            System.out.println(list.size());
            adapter.notifyDataSetChanged();*/
        } else {

        }
        super.setUserVisibleHint(isVisibleToUser);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sub_mylist, container, false);
        rankList = (ListView) view.findViewById(R.id.rank_list);
        insistDay = (TextView) view.findViewById(R.id.insist_day);
        rank = (TextView) view.findViewById(R.id.rank);
        //设置中间使用绿色的大字体
        Spannable insistDayspan = SpanTextUtils.getSpanText(getActivity(), "已坚持" + day + "天", 20, 3, 3 + String.valueOf(day).length(), Color.parseColor("#6ec497"));
        insistDay.setText(insistDayspan);
        Spannable rankSpan = SpanTextUtils.getSpanText(getActivity(), "我在第" + ranknumber + "名", 20, 3, 3 + String.valueOf(ranknumber).length(), Color.parseColor("#6ec497"));
        rank.setText(rankSpan);

        return view;
    }

    class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
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
                convertView = View.inflate(getActivity(), R.layout.rank_item, null);
                viewHolder.groupName = (TextView) convertView.findViewById(R.id.group_name);
                viewHolder.groupHead = (ImageView) convertView.findViewById(R.id.group_head);
                viewHolder.number = (TextView) convertView.findViewById(R.id.rank_number);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            //=========================test......
            ImageLoader loader = ImageLoader.getInstance();
            DisplayImageOptions options1 = new DisplayImageOptions.Builder().showImageForEmptyUri(R.mipmap.pic_head4_196px).build();
            ImageLoaderConfiguration i = ImageLoaderConfiguration.createDefault(getActivity());
            loader.init(i);
            loader.displayImage(null, viewHolder.groupHead, options1);
            int s = 0;
            viewHolder.groupName.setText(list.get(position).getGroupNmae());
            viewHolder.number.setText(++s + ".");
            //=========================test.......
            return convertView;
        }

        class ViewHolder {
            public ImageView groupHead;
            public TextView number;
            public TextView groupName;
        }
    }
}
