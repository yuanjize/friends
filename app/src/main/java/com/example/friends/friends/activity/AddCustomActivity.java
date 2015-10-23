package com.example.friends.friends.activity;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.example.friends.friends.R;
import com.example.friends.friends.Utils.DrawerLayoutListener;
import com.example.friends.friends.bases.BaseActivity;
import com.example.friends.friends.dao.DynamticInfo;
import com.example.friends.friends.fragment.AttractionFragment;
import com.example.friends.friends.fragment.CustomFragment;
import com.example.friends.friends.fragment.DynamicFragment;
import com.example.friends.friends.views.MyViewPager;

import java.util.ArrayList;
import java.util.List;

public class AddCustomActivity extends BaseActivity implements View.OnClickListener, DynamicFragment.LoadInfo {
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private DrawerLayout drawerLayout;
    private MyViewPager viewPager;
    private List<Fragment> fragmentList;
    private LinearLayout sildCommunity;
    private LinearLayout sildAttraction;
    private LinearLayout sildDynamtic;
    private LinearLayout sildCustom;
    private Toolbar toolbar;
    private MenuItem attractionAddItem;
    private MenuItem customMessage;
    private MenuItem customMore;
    private static boolean hasLoad = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_custom);
        toolbar = (Toolbar) findViewById(R.id.bar1);
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.setDrawerListener(new DrawerLayoutListener(actionBarDrawerToggle));
        actionBarDrawerToggle.syncState();
        toolbar.hideOverflowMenu();
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        initViews();
    }

    private void initViews() {
        sildCommunity = (LinearLayout) findViewById(R.id.sild_community);
        sildAttraction = (LinearLayout) findViewById(R.id.sild_attraction);
        sildDynamtic = (LinearLayout) findViewById(R.id.sild_dynamtic);
        sildCustom = (LinearLayout) findViewById(R.id.sild_custom);

        sildCommunity.setOnClickListener(this);
        sildAttraction.setOnClickListener(this);
        sildCustom.setOnClickListener(this);
        sildDynamtic.setOnClickListener(this);

        fragmentList = new ArrayList<Fragment>();
        fragmentList.add(new CustomFragment());
        fragmentList.add(new DynamicFragment());
        fragmentList.add(new AttractionFragment());
        viewPager = (MyViewPager) findViewById(R.id.pages);
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_custom, menu);
        attractionAddItem = menu.findItem(R.id.attraction_add);
        customMessage = menu.findItem(R.id.custom_message);
        customMore = menu.findItem(R.id.custom_more);
        attractionAddItem.setVisible(false);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sild_attraction:
                viewPager.setCurrentItem(2);
                drawerLayout.closeDrawers();
                toolbar.setTitle("关注");
                attractionAddItem.setVisible(true);
                break;
            case R.id.sild_community:
                //       viewPager.setCurrentItem(3);
                drawerLayout.closeDrawers();
                toolbar.setTitle("社区");
                attractionAddItem.setVisible(false);
                startActivity(new Intent(this, AddCommunityActivity.class));
                break;
            case R.id.sild_custom:
                viewPager.setCurrentItem(0);
                drawerLayout.closeDrawers();
                toolbar.setTitle("");
                attractionAddItem.setVisible(false);
                break;
            case R.id.sild_dynamtic:
                viewPager.setCurrentItem(1);
                drawerLayout.closeDrawers();
                toolbar.setTitle("动态");
                attractionAddItem.setVisible(false);
                break;
        }

    }

    //===============================================进行网络请求并且传到动态页面
    @Override
    public List<DynamticInfo> getDynamticInfo() {
        if (hasLoad) {
            //==========================进行加载

            //=============================加载结束
            hasLoad = false;
        } else {
            //不用加载直接返回上次的数据
        }

        return null;
    }

    //================================================
    class FragmentPagerAdapter extends android.support.v4.app.FragmentPagerAdapter {

        public FragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }
    }
}