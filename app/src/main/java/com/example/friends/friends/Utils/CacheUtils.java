package com.example.friends.friends.Utils;

import android.content.Context;
import android.os.Environment;

import java.io.File;

/**
 * Created by yjz on 2015/9/8.
 */
public class CacheUtils {
    public static String getCachePath() {
        if (SDCardUtils.isSDExist()) {
            File file = new File(SDCardUtils.getSDpath() + "/friendsCache");
            if (!file.exists()) {
                file.mkdir();
            }
            return SDCardUtils.getSDpath() + "/friendsCache";

        } else {
            File file = new File(Environment.getDownloadCacheDirectory().getPath() + "/friendsCache");
            if (!file.exists()) {
                file.mkdir();
            }
            return Environment.getDownloadCacheDirectory().getPath() + "/friendsCache";
        }

    }

}
