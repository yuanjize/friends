package com.example.friends.friends.bases;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import com.example.friends.friends.Utils.CacheUtils;
import com.lidroid.xutils.BitmapUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yjz on 2015/9/7.
 */
public class BaseActivity extends AppCompatActivity {
    protected static boolean isActivityAcahe = true;
    public static BitmapUtils bitmapUtils;
    protected final int ERROR = 0;
    protected final int SUCCESS = 1;
    protected final int CANCLE = 2;
    protected static SharedPreferences sharedPreferences;
    protected static Map<String, Activity> activities;
    protected static WindowManager windowManager;
    protected static DisplayMetrics displayMetrics;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (activities == null) {
            activities = new HashMap<String, Activity>();
        }
        if (bitmapUtils == null) {
            bitmapUtils = new BitmapUtils(this, CacheUtils.getCachePath());
        }
        if (sharedPreferences == null)
            sharedPreferences = getSharedPreferences("inputInfo", MODE_PRIVATE);
        if (displayMetrics == null) {
            displayMetrics = new DisplayMetrics();
        }
        if (windowManager == null) {
            windowManager = getWindowManager();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        }
//        if (isActivityAcahe) {
//            addActivity(this.getClass().getName());
//        }
    }

  /*  protected void addActivity(String activityName) {
        activities.put(activityName, this);
    }

    protected void finishActivitys(String[] activityNames) {
        for (String name : activityNames) {
            Activity activity = activities.get(name);
            if (activity != null) {
                activity.finish();
                activity = null;
            }
        }

    }*/

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    protected boolean saveInfo() {
        return false;
    }

    ;
}
