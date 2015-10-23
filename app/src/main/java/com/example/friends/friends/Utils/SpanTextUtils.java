package com.example.friends.friends.Utils;

import android.content.Context;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;

/**
 * Created by yjz on 2015/10/22.
 */
public class SpanTextUtils {

    public static Spannable getSpanText(Context context, String text, int sp, int start, int end,int color) {
        Spannable span = new SpannableString(text);
        span.setSpan(new AbsoluteSizeSpan(DensityUtil.sp2px(context, 20)), start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        span.setSpan(new ForegroundColorSpan(color), start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return span;
    }
}
