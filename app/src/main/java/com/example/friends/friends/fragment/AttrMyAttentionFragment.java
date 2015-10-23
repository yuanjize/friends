package com.example.friends.friends.fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.friends.friends.R;
import com.example.friends.friends.dao.User;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class AttrMyAttentionFragment extends android.support.v4.app.Fragment {
    private View view;
    private ListView fans;
    private static List<User> users;
    private static MyAdapter adapter;
    private static boolean isLoaded = false;

    public AttrMyAttentionFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_attr_my_attention, container, false);
        findViewByIds();
        users = new ArrayList<User>();
        users.add(new User());
        adapter = new MyAdapter();
        fans.setAdapter(adapter);
        return view;
    }

    private void findViewByIds() {
        fans = (ListView) view.findViewById(R.id.fans);


    }

    //数据延迟加载======================================================================
/*

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            //==如果对用户可见，就加载数据
            View view = View.inflate(getActivity(), R.layout.fragment_att_fans, null);
            if (users == null) {
                users = new ArrayList<User>();
            }
            if (adapter == null) {
                adapter = new MyAdapter();
            }
            if (!isLoaded) {
                if (fans == null) {
                    fans = (ListView) view.findViewById(R.id.fans);
                }
                fans.setAdapter(adapter);
            } else {
                return;
            }
        }
    }
*/

    class MyAdapter extends BaseAdapter implements View.OnClickListener {

        @Override
        public int getCount() {
            return users.size();
        }

        @Override
        public Object getItem(int position) {
            return users.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder = null;
            if (convertView == null) {
                convertView = View.inflate(AttrMyAttentionFragment.this.getActivity(), R.layout.fans_item_layout, null);
                viewHolder = new ViewHolder();
                viewHolder.attentionCheck = (TextView) convertView.findViewById(R.id.isattention);
                viewHolder.fansName = (TextView) convertView.findViewById(R.id.fans_name);
                viewHolder.fansSign = (TextView) convertView.findViewById(R.id.fans_sign);
                viewHolder.fansHead = (ImageView) convertView.findViewById(R.id.fans_pic);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            viewHolder.attentionCheck.setOnClickListener(MyAdapter.this);

            //--------------------------------------------------------异步请求处理把结果放在List中

            viewHolder.fansHead.setImageResource(R.mipmap.pic_head4_196px);
            viewHolder.fansName.setText("抠脚大汉");
            viewHolder.fansSign.setText("今天中午吃什么.................");
            //---------------------------------------------------------------
            return convertView;
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.isattention:
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

    class ViewHolder {
        public TextView attentionCheck;
        public TextView fansName;
        public TextView fansSign;
        public ImageView fansHead;

    }
}
