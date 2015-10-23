package com.example.friends.friends.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.friends.friends.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yjz on 2015/9/28.
 */
public class AttractionFragment extends Fragment {
    private TabLayout tabLayout;
    private ViewPager viewpager;
    private List<Fragment> fragments;
    private static final String[] tittle = new String[]{"特别关注", "粉丝", "我的关注"};

    //数据延迟加载======================================================================

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        if (isVisibleToUser) {
            //==如果对用户可见，就加载数据
        } else {

        }
        super.setUserVisibleHint(isVisibleToUser);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_attraction, container, false);
        fragments = new ArrayList<Fragment>();
        fragments.add(new AttSpecialAttractionFragment());
        fragments.add(new AttFansFragment());
        fragments.add(new AttrMyAttentionFragment());
        tabLayout = (TabLayout) view.findViewById(R.id.attraction_tablayout);
        viewpager = (ViewPager) view.findViewById(R.id.attraction_pager);
        MyPagerAdapter adapter = new MyPagerAdapter(this);
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewpager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.setTabsFromPagerAdapter(adapter);
        viewpager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        viewpager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewpager);
        return view;
    }

    class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(Fragment f) {
            super(f.getChildFragmentManager());
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tittle[position];
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

    }

}
