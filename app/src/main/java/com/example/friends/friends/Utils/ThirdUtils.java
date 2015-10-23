package com.example.friends.friends.Utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.example.friends.friends.activity.Register1Activity;
import com.example.friends.friends.dao.User;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.tencent.qq.QQ;

public class ThirdUtils {
    private static Platform platform;
    private static Listener listener;
    private static User user;
    public static Context ctx;

    public static void login(Context ctx, String platformName) {
        init(ctx);
        platform = ShareSDK.getPlatform(ctx, platformName);
        //获取信息
        ShowUser();
    }

    private static void ShowUser() {
        platform.removeAccount();
        if (platform != null) {
            if (platform.isValid()) {
                String userId = platform.getDb().getUserId();
                //      Toast.makeText(ctx, userId, Toast.LENGTH_SHORT).show();
                if (userId != null) {
                    if (LoginUtils.isResgister(userId)) {
                        LoginUtils.login(userId, ctx);
                        ctx.startActivity(new Intent(ctx, Register1Activity.class));
                        ((Activity)ctx).finish();
                        return;
                    }
                }
            }
        }
        //Toast.makeText(ctx, "..........................", Toast.LENGTH_SHORT).show();
        platform.setPlatformActionListener(listener);
        platform.SSOSetting(true);
        platform.showUser(null);
    }
//
//    public static boolean checkPlatform(Platform platform) {
//        if (platform != null) {
//            if (platform.isValid()) {
//                String userId = platform.getDb().getUserId();
//                if (userId != null) {
//                    return true;
//                } else
//                    return false;
//            } else
//                return false;
//        } else
//            return false;
//
//    }

    private static void init(Context context) {
        ctx = context;
        ShareSDK.initSDK(ctx);
        listener = new Listener(ctx);
    }


}

