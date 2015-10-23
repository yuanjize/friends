package com.example.friends.friends.adapter;

import android.view.View;

import cn.sharesdk.framework.authorize.AuthorizeAdapter;

/**
 * Created by yjz on 2015/9/7.
 */
public class MyAdapter extends AuthorizeAdapter {
    @Override
    public void onCreate() {
        super.onCreate();
        hideShareSDKLogo();
        disablePopUpAnimation();
        getTitleLayout().setVisibility(View.GONE);
    }
}
