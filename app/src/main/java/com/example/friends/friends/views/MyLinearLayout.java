package com.example.friends.friends.views;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.friends.friends.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yjz on 2015/9/14.
 */
public class MyLinearLayout extends LinearLayout {
    private static int count = 0;
    private int width;
    private int height;
    private Context ctx;
    private MyLinearLayout linearLayout;
    private static int textTags;
    private static int addedTags;
    private static List<MyLinearLayout> linearLayouts;

    public void clear() {
        textTags = 0;
        addedTags = 0;
        linearLayouts.clear();
    }

    public MyLinearLayout(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        this.ctx = context;
        if (linearLayouts == null)
            linearLayouts = new ArrayList<MyLinearLayout>();

    }

    public MyLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);

    }

    public MyLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);

    }

    public void setSampleLabel(View view) {
        width = view.getWidth();
        height = view.getHeight();
    }

    public View getView(String text) {
        TextView t = new TextView(ctx);
        t.setText(text);
        t.setGravity(Gravity.CENTER_VERTICAL | Gravity.RIGHT);
        t.setTextColor(Color.parseColor("#878787"));
        return t;
    }

    public boolean isFull() {
        int childCount = this.getChildCount();
        if (childCount >= 4) {
            return true;
        } else return false;
    }

    public MyLinearLayout addLabelView(View add, View view, ViewGroup.LayoutParams Params) {
        String tag = ((String) add.getTag());
        if (tag.contains("text") || tag.contains("image")) {
            if (!isFull()) {
                //如果是文字标签
                if (tag.contains("text")) {
                    ((TextView) add).setBackground(ContextCompat.getDrawable(ctx, R.drawable.bk_able));
                    ((TextView) add).setTextSize(TypedValue.COMPLEX_UNIT_PX, ((TextView) view).getTextSize());
                    add.setTag("text" + ++textTags);
                    ((TextView) add).setPadding(0, 0, ((TextView) view).getPaddingRight(), 0);

                } else {
                    ((ImageView) add).setBackground(ContextCompat.getDrawable(ctx, R.drawable.add_tag));
                    ((ImageView) add).setPadding(0, 0, ((TextView) view).getPaddingRight(), 0);

                }

                this.addView(add, view.getLayoutParams());
                return this;
            } else {
                linearLayout = new MyLinearLayout(ctx);
                ((LinearLayout) this.getParent()).addView(linearLayout, Params);
                linearLayout.addLabelView(add, view, Params);
                return linearLayout;
            }
        }
        //如果不是
        else if (tag.contains("added")) {
            addLinearlayouts(this);
            for (MyLinearLayout layout : linearLayouts) {
                if (!layout.isFull()) {
                    ((TextView) add).setBackground(ContextCompat.getDrawable(ctx, R.drawable.delete_tag));
                    add.setTag("added" + addedTags++);
                    ((TextView) add).setTextSize(TypedValue.COMPLEX_UNIT_PX, ((TextView) view).getTextSize());
                    ((TextView) add).setPadding(0, 0, ((TextView) view).getPaddingRight(), 0);
                    layout.addView(add, view.getLayoutParams());
                    return this;
                }
            }
            linearLayout = new MyLinearLayout(ctx);
            ((LinearLayout) this.getParent()).addView(linearLayout, Params);
            linearLayout.setPadding(0, this.getPaddingRight(), 0, 0);
            linearLayout.addLabelView(add, view, Params);
            return linearLayout;
        }
        return null;
    }

    private void addLinearlayouts(MyLinearLayout linearLayout) {
        if (!linearLayouts.contains(linearLayout))
            linearLayouts.add(linearLayout);
    }

/*    public void clear() {
        for (MyLinearLayout layout : linearLayouts) {
            if (layout != null) {
                if (layout.getChildCount() == 0)
                    ((LinearLayout) layout.getParent()).removeView(layout);
                Toast.makeText(ctx, "hello " + count++, Toast.LENGTH_SHORT).show();
            }
        }
    }*/
}