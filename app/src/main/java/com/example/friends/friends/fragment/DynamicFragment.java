package com.example.friends.friends.fragment;


import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.friends.friends.R;
import com.example.friends.friends.dao.DynamticInfo;

import java.util.ArrayList;
import java.util.List;


public class DynamicFragment extends Fragment {
    private boolean isSetView = false;
    private TabLayout tabLayout;
    private ViewPager viewpager;
    private List<Fragment> fragments;
    private static final String[] tittles = new String[]{"最热", "最新", "社区"};

    public DynamicFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    //数据延迟加载======================================================================

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            //==如果对用户可见，就加载数据
        } else {
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        fragments = new ArrayList<Fragment>();
        fragments.add(new DyhostFragment());
        fragments.add(new DynewestFragment());
        fragments.add(new DyCommutityFragment());
        FragmentPagerAdapter adapter = new MyPagerAdapter(this);
        View view = inflater.inflate(R.layout.fragment_dynamic, container, false);

        tabLayout = (TabLayout) view.findViewById(R.id.dynamic_tablayout);
        viewpager = (ViewPager) view.findViewById(R.id.dynamic_pager);
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
        viewpager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewpager);
        return view;
    }

    class MyPagerAdapter extends FragmentPagerAdapter {
        @Override
        public CharSequence getPageTitle(int position) {
            return tittles[position];
        }

        public MyPagerAdapter(Fragment f) {
            super(f.getChildFragmentManager());
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

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    public interface LoadInfo {
        List<DynamticInfo> getDynamticInfo();
    }
}
