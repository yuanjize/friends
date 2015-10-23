package com.example.friends.friends.views;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;

/**
 * Created by yjz on 2015/9/17.
 */
public class BeautifulDialog extends AlertDialog {
    public BeautifulDialog(Context context) {
        super(context);
    }

    protected BeautifulDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    public BeautifulDialog(Context context, int theme) {
        super(context, theme);
    }
}
