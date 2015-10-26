package com.example.friends.friends.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.friends.friends.R;
import com.example.friends.friends.bases.BaseActivity;
import com.example.friends.friends.dao.SubCommunityItem;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class SubCommunityFragment extends Fragment {
    private List<SubCommunityItem> data;
    private MyAdapter adapter;
    private ListView listView;

    public SubCommunityFragment() {
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {

        if (isVisible()) {
            if (adapter == null) {
                adapter = new MyAdapter();
                if (data == null) {
                    data = new ArrayList<>();
                    ///===============================test
                    data.add(new SubCommunityItem(null, "有朋1号", "今天工作不努力，每天努力找工作。"));
                    data.add(new SubCommunityItem(null, "有朋2号", "今天学习不努力，每天努力找工作。"));
                    data.add(new SubCommunityItem(null, "有朋3号", "今天编码不努力，每天努力找工作。。。。。。。。。。。。"));
                    data.add(new SubCommunityItem(null, "有朋4号", "今天干活不努力，每天努力找工作。"));
                    data.add(new SubCommunityItem(null, "有朋5号", "今天上班不努力，每天努力找工作。"));
                    //=======================
                }
            }
            listView.setAdapter(adapter);
        } else {

        }


        super.setUserVisibleHint(isVisibleToUser);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sub_community, container, false);
        listView = (ListView) view.findViewById(R.id.mylist);
        return view;
    }

    class ViewHolder {
        public ImageView groupHead;
        public TextView groupName;
        public TextView groupSign;
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
                convertView = View.inflate(getActivity(), R.layout.sub_community_item, null);
                viewHolder.groupHead = (ImageView) convertView.findViewById(R.id.sub_community_item_group_head);
                viewHolder.groupName = (TextView) convertView.findViewById(R.id.sub_community_item_group_name);
                viewHolder.groupSign = (TextView) convertView.findViewById(R.id.sub_community_item_group_sign);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }


            viewHolder.groupName.setText(data.get(position).getGroupname());
            viewHolder.groupSign.setText(data.get(position).getGroupSign());
//==================================test
            DisplayImageOptions options1 = new DisplayImageOptions.Builder().showImageForEmptyUri(R.mipmap.pic_head4_196px).build();
            ImageLoader loader = ImageLoader.getInstance();
            ImageLoaderConfiguration i = ImageLoaderConfiguration.createDefault(getActivity());
            loader.init(i);
            loader.displayImage(null, viewHolder.groupHead, options1);
//==================================test
            return convertView;
        }
    }


}
