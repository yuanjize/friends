package com.example.friends.friends.views;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.friends.friends.R;

/**
 * Created by yjz on 2015/9/9.
 */
public class MyTittle extends LinearLayout implements View.OnClickListener {
    private View view;
    private Context ctx;
    private ImageView back;
    private TextView tittle;
    //当前ACTIVITY
    private Activity activity;

    public MyTittle(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        this.ctx = context;
        view = View.inflate(ctx, R.layout.actionbar_layout, this);
        back = (ImageView) view.findViewById(R.id.back);
        tittle = (TextView) view.findViewById(R.id.mytitle);
        back.setImageResource(R.drawable.bar_back);
        back.setOnClickListener(this);
    }

    public MyTittle(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyTittle);
        String tittletext = typedArray.getString(R.styleable.MyTittle_tittle);
        tittle.setText(tittletext);
        typedArray.recycle();
    }

    public void setParentActivity(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void onClick(View v) {
        ((Activity) ctx).finish();
    }
}
