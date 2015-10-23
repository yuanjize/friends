package com.example.friends.friends.Utils;

import android.content.Context;
import android.content.Intent;

import com.example.friends.friends.activity.AddCustomActivity;

/**
 * Created by yjz on 2015/9/8.
 */
public class LoginUtils {
    public static void login(String userId, Context ctx) {

    }

    public static void login(String userId, String password, Context ctx) {
        //发送到服务器进行验证

        //跳转到AddCustomer界面
        ctx.startActivity(new Intent(ctx, AddCustomActivity.class));

    }

    //把ID发送到服务器检测是否已经注册过
    public static boolean isResgister(String userId) {
        return false;
    }
}
