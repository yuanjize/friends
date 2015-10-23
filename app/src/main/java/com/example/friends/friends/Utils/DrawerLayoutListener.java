package com.example.friends.friends.Utils;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.View;

/**
 * Created by yjz on 2015/9/23.
 */
public class DrawerLayoutListener implements DrawerLayout.DrawerListener {
    private ActionBarDrawerToggle actionBarDrawerToggle;

    public DrawerLayoutListener(ActionBarDrawerToggle actionBarDrawerToggle) {
        this.actionBarDrawerToggle = actionBarDrawerToggle;
    }

    @Override
    public void onDrawerSlide(View drawerView, float slideOffset) {
        actionBarDrawerToggle.onDrawerSlide(drawerView, slideOffset);
    }

    @Override
    public void onDrawerOpened(View drawerView) {
        actionBarDrawerToggle.onDrawerOpened(drawerView);
    }

    @Override
    public void onDrawerClosed(View drawerView) {
        actionBarDrawerToggle.onDrawerClosed(drawerView);
    }

    @Override
    public void onDrawerStateChanged(int newState) {
        actionBarDrawerToggle.onDrawerStateChanged(newState);
    }
}
