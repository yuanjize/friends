package com.example.friends.friends.Utils;

/**
 * Created by yjz on 2015/9/11.
 */
public class TextUtils {
    public static boolean isEmpty(String[] texts) {

        for (String text : texts) {
            if (text != null && !text.trim().equals("")) ;
            else return true;
        }
        return false;
    }

    public static boolean isEmpty(String text) {
        if (text != null && !text.trim().equals("")) {
            return false;
        } else {
            return true;
        }

    }
}
