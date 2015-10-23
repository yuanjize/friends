package com.example.friends.friends.fragment;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.support.v4.app.Fragment;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.friends.friends.R;
import com.example.friends.friends.Utils.DensityUtil;
import com.example.friends.friends.dao.DynamticInfo;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.ArrayList;
import java.util.List;


public class DynewestFragment extends Fragment {


    private RecyclerView recyclerView;
    private List<DynamticInfo> info;

    public DynewestFragment() {
        // Required empty public constructor
    }

    //数据延迟加载======================================================================

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        if (isVisible()) {
            //==如果对用户可见，就加载数据
            //DynamicFragment.LoadInfo loadInfo = (DynamicFragment.LoadInfo) getActivity();
            //info=loadInfo.getDynamticInfo();

        } else {

        }
        super.setUserVisibleHint(isVisibleToUser);
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if (info == null) {
            info = new ArrayList<DynamticInfo>();
//=============================测试数据
            info.add(new DynamticInfo(R.mipmap.pic_head4_196px, R.mipmap.pic_dynamic_detail, R.mipmap.pic_head4_196px, getActivity().getPackageName()));
            info.add(new DynamticInfo(R.mipmap.pic_head4_196px, R.mipmap.pic_dynamic_detail, R.mipmap.pic_head4_196px, getActivity().getPackageName()));
            info.add(new DynamticInfo(R.mipmap.pic_head4_196px, R.mipmap.pic_dynamic_detail, R.mipmap.pic_head4_196px, getActivity().getPackageName()));
            info.add(new DynamticInfo(R.mipmap.pic_head4_196px, R.mipmap.pic_dynamic_detail, R.mipmap.pic_head4_196px, getActivity().getPackageName()));
            info.add(new DynamticInfo(R.mipmap.pic_head4_196px, R.mipmap.pic_dynamic_detail, R.mipmap.pic_head4_196px, getActivity().getPackageName()));
//=============================测试数据
        }
        View view = inflater.inflate(R.layout.fragment_newest, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.new_content);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new MyAdapter());
        return view;
    }

    class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHoler> implements View.OnClickListener {

        @Override
        public MyViewHoler onCreateViewHolder(ViewGroup parent, int viewType) {

            MyViewHoler myViewHoler = new MyViewHoler(View.inflate(getActivity(), R.layout.hot_item, null));

            return myViewHoler;
        }

        @Override
        public void onBindViewHolder(MyViewHoler holder, int position) {
            //========================处理数据

            holder.approve.setText(info.get(position).getApprove() + "");
            holder.comment.setText(info.get(position).getComment() + "");

            //=====================测试
            DisplayImageOptions options1 = new DisplayImageOptions.Builder().showImageForEmptyUri(R.mipmap.pic_head4_196px).build();
            DisplayImageOptions options2 = new DisplayImageOptions.Builder().showImageForEmptyUri(R.mipmap.pic_dynamic_detail).build();
            ImageLoader loader = ImageLoader.getInstance();
            ImageLoaderConfiguration i = ImageLoaderConfiguration.createDefault(getActivity());
            loader.init(i);
            loader.displayImage(null, holder.groupHead, options1);
            loader.displayImage(null, holder.userHead, options1);
            loader.displayImage(null, holder.descripPicture, options2);
            //=====================测试


            holder.groupName.setText(info.get(position).getGroupName());
            holder.userInsistDay.setText(info.get(position).getUserInsistDay());
            holder.userSendData.setText(info.get(position).getUserSendData());
            holder.userSignIn.setText(info.get(position).getUserSignIn());
            holder.dynamiticDescription.setText(info.get(position).getDynamiticDescription());
            holder.groupName.setText(info.get(position).getGroupName());
            holder.userName.setText(info.get(position).getUserName());


            holder.descripPicture.setOnClickListener(this);
            holder.userHead.setOnClickListener(this);
            holder.groupHead.setOnClickListener(this);
            holder.approve.setOnClickListener(this);
            holder.comment.setOnClickListener(this);
            holder.groupName.setOnClickListener(this);
            holder.userInsistDay.setOnClickListener(this);
            holder.userSendData.setOnClickListener(this);
            holder.userSignIn.setOnClickListener(this);
            holder.dynamiticDescription.setOnClickListener(this);
            holder.groupName.setOnClickListener(this);
            holder.userName.setOnClickListener(this);

        }

        @Override
        public int getItemCount() {
            return info.size();
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.hot_user_head:
                    break;
                case R.id.descrip_pic:
                    break;
                case R.id.hot_group_head:
                    break;
                case R.id.hot_username:
                    break;
                case R.id.hot_sign_in:
                    break;
                case R.id.descrip_word:
                    break;
                case R.id.insistDay:
                    break;
                case R.id.hot_date:
                    break;
                case R.id.hot_group_name:
                    break;
                case R.id.hot_approve:
                    break;
                case R.id.hot_comment:
                    break;
            }
        }

        class MyViewHoler extends RecyclerView.ViewHolder {
            public ImageView userHead;
            public TextView userName;
            public TextView userSignIn;
            public TextView dynamiticDescription;
            public TextView userInsistDay;
            public TextView userSendData;
            public ImageView descripPicture;
            public ImageView groupHead;
            public TextView groupName;
            public TextView approve;
            public TextView comment;

            public MyViewHoler(View itemView) {
                super(itemView);
                userHead = (ImageView) itemView.findViewById(R.id.hot_user_head);
                descripPicture = (ImageView) itemView.findViewById(R.id.descrip_pic);
                groupHead = (ImageView) itemView.findViewById(R.id.hot_group_head);
                userName = (TextView) itemView.findViewById(R.id.hot_username);
                userSignIn = (TextView) itemView.findViewById(R.id.hot_sign_in);
                dynamiticDescription = (TextView) itemView.findViewById(R.id.descrip_word);
                userInsistDay = (TextView) itemView.findViewById(R.id.insistDay);
                userSendData = (TextView) itemView.findViewById(R.id.hot_date);
                groupName = (TextView) itemView.findViewById(R.id.hot_group_name);
                approve = (TextView) itemView.findViewById(R.id.hot_approve);
                comment = (TextView) itemView.findViewById(R.id.hot_comment);

                Drawable drawable = ContextCompat.getDrawable(getActivity(), R.mipmap.ic_custom_card_zan);
                drawable.setBounds(0, 0, DensityUtil.dip2px(getActivity(), 30f), DensityUtil.dip2px(getActivity(), 30f));
                approve.setCompoundDrawables(drawable, null, null, null);
                approve.setCompoundDrawablePadding(DensityUtil.dip2px(getActivity(), 3f));

                Drawable drawable2 = ContextCompat.getDrawable(getActivity(), R.mipmap.ic_custom_card_comment);
                drawable2.setBounds(0, 0, DensityUtil.dip2px(getActivity(), 30f), DensityUtil.dip2px(getActivity(), 30f));
                comment.setCompoundDrawables(drawable2, null, null, null);
                comment.setCompoundDrawablePadding(DensityUtil.dip2px(getActivity(), 3f));
            }
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


}
