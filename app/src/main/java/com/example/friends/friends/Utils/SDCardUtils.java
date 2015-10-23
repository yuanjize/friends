package com.example.friends.friends.Utils;

import android.net.Uri;
import android.os.Environment;

import java.io.File;

/**
 * Created by yjz on 2015/9/8.
 */
public class SDCardUtils {
    public static boolean isSDExist() {
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
            return true;
        } else return false;
    }

    public static String getSDpath() {
        return Environment.getExternalStorageDirectory().toString();
    }


    public static Uri getPictureSavePath(String name) {
        Uri uri = null;
        if (isSDExist()) {
            File friendsPicture = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "FriendsPictyre");
            if (!friendsPicture.exists()) {
                friendsPicture.mkdir();
            }
            File file = new File(friendsPicture.getPath() + "/" + "header" + name + ".jpg");
            uri = Uri.fromFile(file);
        }
        return uri;
    }
}
