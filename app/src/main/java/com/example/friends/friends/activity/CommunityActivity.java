package com.example.friends.friends.activity;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.friends.friends.R;
import com.example.friends.friends.Utils.DensityUtil;
import com.example.friends.friends.bases.BaseActivity;
import com.example.friends.friends.fragment.DynewestFragment;
import com.example.friends.friends.fragment.SublistrankFragment;
import com.example.friends.friends.fragment.SubDynamticFragment;
import com.example.friends.friends.fragment.SubActivityFragment;

import java.util.ArrayList;
import java.util.List;

public class CommunityActivity extends BaseActivity {
    private TextView communityFansNumber;
    private TextView communityBossName;
    private ImageView groupHead;
    private TextView groupName;
    private TextView sign;
    private TextView activitySignIn;
    private TextView activityLunch;

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private static String[] tittles;
    private List<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community2);
        init();
    }

    private void init() {
        if (tittles == null) {
            tittles = new String[]{"动态", "活动", "榜单"};
        }
        if (fragments == null) {
            fragments = new ArrayList<>();
            fragments.add(new DynewestFragment());
            fragments.add(new SubActivityFragment());
            fragments.add(new SublistrankFragment());
        }
        communityFansNumber = (TextView) findViewById(R.id.community_people_number);
        communityBossName = (TextView) findViewById(R.id.community_boss_name);

        groupHead = (ImageView) findViewById(R.id.community_head);
        groupName = (TextView) findViewById(R.id.community_name);
        sign = (TextView) findViewById(R.id.community_sign);
        activitySignIn = (TextView) findViewById(R.id.activity_sign);
        activityLunch = (TextView) findViewById(R.id.lunch_activity);

        Drawable drawable1 = ContextCompat.getDrawable(this, R.mipmap.ic_fans);
        drawable1.setBounds(0, 0, DensityUtil.dip2px(this, 23f), DensityUtil.dip2px(this, 23f));
        communityFansNumber.setCompoundDrawables(drawable1, null, null, null);

        Drawable drawable2 = ContextCompat.getDrawable(this, R.mipmap.ic_person);
        drawable2.setBounds(0, 0, DensityUtil.dip2px(this, 23f), DensityUtil.dip2px(this, 23f));
        communityBossName.setCompoundDrawables(drawable2, null, null, null);

        tabLayout = (TabLayout) findViewById(R.id.tool_bar);
        tabLayout.setTabTextColors(Color.parseColor("#6c6c6c"), Color.parseColor("#6dc396"));

        viewPager = (ViewPager) findViewById(R.id.my_pager);
        viewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
        //========================================获取网络数据

        //========================================
    }

    class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tittles[position];
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }
}
