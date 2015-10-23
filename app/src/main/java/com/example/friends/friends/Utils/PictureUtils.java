package com.example.friends.friends.Utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.PrivateKey;

/**
 * Created by yjz on 2015/9/13.
 */
public class PictureUtils {
    private static final int CROP_PICTURE = 96;
    private static FileOutputStream out;

    public static void crop(Activity activity, Uri uri, View view) {
        int scale = Math.min(view.getWidth(), view.getHeight());
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        intent.putExtra("crop", "true");
        intent.putExtra("outputX", scale);
        intent.putExtra("outputY", scale);
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        intent.putExtra("scale", true);
        intent.putExtra("return-data", true);
        activity.startActivityForResult(intent, CROP_PICTURE);
    }

    public static void savePicture(Uri uri, Bitmap bitmap) {
        File file = new File(uri.getPath());
        try {
            if (!file.exists()) {
                file.delete();
            }
            out = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}