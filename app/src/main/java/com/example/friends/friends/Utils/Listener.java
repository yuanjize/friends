package com.example.friends.friends.Utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;

import com.example.friends.friends.activity.Register1Activity;
import com.example.friends.friends.dao.User;
import com.mob.tools.utils.UIHandler;

import java.util.HashMap;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.PlatformDb;

import android.os.Handler.Callback;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by yjz on 2015/9/7.
 */
public class Listener implements PlatformActionListener, Callback {
    private Message msg = null;
    private final int ERROR = 0;
    private final int SUCCESS = 1;
    private final int CANCLE = 2;
    private Context ctx;

    public Listener(Context ctx) {
        this.ctx = ctx;
    }

    @Override
    public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
        msg = new Message();
        msg.what = SUCCESS;
        PlatformDb db = platform.getDb();
        String userId = db.getUserId();
        //如果以前登陆过，直接登录
        if (LoginUtils.isResgister(userId)) {

            LoginUtils.login(userId, ctx);

        } else { //如果没有登录过，得到信息交给UIHandler进行注册
            String userGender = db.getUserGender();
            String userIcon = db.getUserIcon();
            String userName = db.getUserName();
            User user = new User(userGender, userIcon, userId, userName);
            System.out.println(user);
            msg.obj = user;
            UIHandler.sendMessage(msg, this);
        }

    }

    @Override
    public void onError(Platform platform, int i, Throwable throwable) {
        platform.removeAccount();
        msg = new Message();
        msg.what = ERROR;
        UIHandler.sendMessage(msg, this);
    }

    @Override
    public void onCancel(Platform platform, int i) {
        platform.removeAccount();
        msg = new Message();
        msg.what = CANCLE;
        UIHandler.sendMessage(msg, this);
    }

    @Override
    public boolean handleMessage(Message msg) {
        switch (msg.what) {
            case ERROR:
                Toast.makeText(ctx, "授权失败", Toast.LENGTH_SHORT).show();
                break;
            case SUCCESS:

                User user = (User) msg.obj;
                //   Toast.makeText(ctx, user.getUserGender() + " ......", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ctx, Register1Activity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("user", user);
                intent.putExtras(bundle);
                ctx.startActivity(intent);
                break;
            case CANCLE:
                break;
        }

        return false;
    }


}
