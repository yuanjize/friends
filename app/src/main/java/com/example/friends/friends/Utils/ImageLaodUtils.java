package com.example.friends.friends.Utils;

import android.content.ContentResolver;
import android.net.Uri;

import com.example.friends.friends.R;

/**
 * Created by yjz on 2015/9/23.
 */
public class ImageLaodUtils {
    public static String getResourceUri(int resId, String packageName) {
        return Uri.parse("android.resource://" + packageName + "/" + resId).getPath();
    }

}
