package com.example.friends.friends.activity;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.app.Activity;
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
import com.example.friends.friends.fragment.SubActivityFragment;
import com.example.friends.friends.fragment.SubCommunityFragment;
import com.example.friends.friends.fragment.SubCustomFragment;
import com.example.friends.friends.fragment.SubLableFragment;
import com.example.friends.friends.fragment.SublistrankFragment;

import java.util.ArrayList;
import java.util.List;

public class PersonalActivity extends BaseActivity {
    private TextView personalFansNumber;
    private TextView personalAttentionNumber;
    private ImageView personalHead;
    private TextView personalName;
    private TextView sign;
    private TextView editMyInfo;
    private TextView moreSetting;

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private static String[] tittles;
    private List<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);
        init();
    }

    private void init() {
        if (tittles == null) {
            tittles = new String[]{"习惯", "社区", "标签"};
        }
        if (fragments == null) {
            fragments = new ArrayList<>();
            fragments.add(new SubCustomFragment());
            fragments.add(new SubCommunityFragment());
            fragments.add(new SubLableFragment());
        }
        personalFansNumber = (TextView) findViewById(R.id.personal_myfans);
        personalAttentionNumber = (TextView) findViewById(R.id.personal_myattention);

        personalHead = (ImageView) findViewById(R.id.personal_head);
        personalName = (TextView) findViewById(R.id.personal_name);
        sign = (TextView) findViewById(R.id.personal_sign);
        moreSetting = (TextView) findViewById(R.id.personal_more_setting);
        editMyInfo = (TextView) findViewById(R.id.personal_edit_myinfo);

        Drawable drawable1 = ContextCompat.getDrawable(this, R.mipmap.ic_me_fans);
        drawable1.setBounds(0, 0, DensityUtil.dip2px(this, 23f), DensityUtil.dip2px(this, 23f));
        personalFansNumber.setCompoundDrawables(drawable1, null, null, null);

        Drawable drawable2 = ContextCompat.getDrawable(this, R.mipmap.ic_me_lover);
        drawable2.setBounds(0, 0, DensityUtil.dip2px(this, 23f), DensityUtil.dip2px(this, 23f));
        personalAttentionNumber.setCompoundDrawables(drawable2, null, null, null);

        tabLayout = (TabLayout) findViewById(R.id.personal_tool_bar);
        tabLayout.setTabTextColors(Color.parseColor("#6c6c6c"), Color.parseColor("#6dc396"));

        viewPager = (ViewPager) findViewById(R.id.personal_my_pager);
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
