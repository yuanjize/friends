package com.example.friends.friends.activity;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.friends.friends.R;
import com.example.friends.friends.Utils.TextUtils;
import com.example.friends.friends.bases.BaseActivity;
import com.example.friends.friends.dao.User;
import com.example.friends.friends.views.BeautifulDialog;
import com.example.friends.friends.views.MyLinearLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Register2Activity extends BaseActivity implements View.OnClickListener {
    private MyLinearLayout upLinearLayout;
    private MyLinearLayout downLinearLayout;
    private TextView t;
    private String[] lables;
    private int ids = 0;
    private Map<String, String> tags;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);
        init();

    }

    private void init() {
        tags = new HashMap<String, String>();
        //初始标签
        lables = new String[]{"文青", "慢跑狂", "球控", "手绘", "嗜睡症", "摄影", "书法帝", "腹肌撕", "强迫症", "吃货"};
        //模板标签
        t = (TextView) findViewById(R.id.abble1);
        t.setTag("text");
        t.setClickable(true);
        t.getLayoutParams().width = displayMetrics.widthPixels / 5 + 10;
        t.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
        t.setOnClickListener(this);
        upLinearLayout = (MyLinearLayout) findViewById(R.id.raw1);
        downLinearLayout = (MyLinearLayout) findViewById(R.id.raws1);
        //开始添加
        for (String name : lables) {
            View view = upLinearLayout.getView(name);
            view.setTag("text");
            view.setClickable(true);
            view.setOnClickListener(this);
            upLinearLayout = upLinearLayout.addLabelView(view, t, upLinearLayout.getLayoutParams());
        }
        //加入添加按钮
        ImageView add = new ImageView(this);
        add.setTag("image");
        add.setBackground(ContextCompat.getDrawable(this, R.drawable.add_tag));
        add.setOnClickListener(this);
        upLinearLayout = upLinearLayout.addLabelView(add, t, upLinearLayout.getLayoutParams());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_register2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

        String tag = (String) v.getTag();
        //  Toast.makeText(Register2Activity.this, (String) v.getTag() + "..................", Toast.LENGTH_SHORT).show();

        if (tag == null) {
            //    Toast.makeText(Register2Activity.this, (String) v.getTag() + "...............", Toast.LENGTH_SHORT).show();
            return;
        }
        if (tag.contains("text")) {
            String name = ((TextView) v).getText().toString();
            if (tags.get(((TextView) v).getText().toString()) == null) {
                tags.put(((TextView) v).getText().toString(), "yes");
                View view = upLinearLayout.getView(name);
                view.setTag("added");
                view.setOnClickListener(this);
                downLinearLayout = downLinearLayout.addLabelView(view, t, downLinearLayout.getLayoutParams());
            }
            //选中标签
        } else if (tag.contains("image")) {
            final BeautifulDialog addMyLable = new BeautifulDialog(this, R.style.Translucent_NoTitle);
            View view = View.inflate(this, R.layout.addmylable_layout, null);
            addMyLable.setView(view);
            final EditText able = (EditText) view.findViewById(R.id.et_addmylable);
            Button makeSure = (Button) view.findViewById(R.id.make_sure);
            makeSure.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String ablename = able.getText().toString();
                    if (TextUtils.isEmpty(ablename)) {
                        Toast.makeText(Register2Activity.this, "输入不能为空", Toast.LENGTH_SHORT).show();
                    } else {
                        if (tags.get(ablename) == null) {
                            tags.put(((TextView) v).getText().toString(), "yes");
                            View view = upLinearLayout.getView(ablename);
                            view.setTag("added");
                            view.setOnClickListener(Register2Activity.this);
                            downLinearLayout = downLinearLayout.addLabelView(view, t, downLinearLayout.getLayoutParams());
                            addMyLable.dismiss();
                        }
                    }
                }

            });
            addMyLable.show();
            //增加标签
        } else if (tag.contains("added")) {
            //移除标签
            //Toast.makeText(Register2Activity.this, "uooo...", Toast.LENGTH_SHORT).show();
            tags.remove(((TextView) v).getText().toString());
            ((MyLinearLayout) v.getParent()).removeView(v);
            //downLinearLayout.clear();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        downLinearLayout.clear();
        tags.clear();
        this.finish();
    }

    public void next(View view) {
        //把map里面的字符串传到User并提交
        view.invalidate();
        User user = (User) getIntent().getExtras().getSerializable("user");
        List<String> list = new ArrayList<String>();
        Set<String> tagSet = tags.keySet();
        for (String tag : tagSet) {
            list.add(tags.get(tag));
        }
        user.setLabels(list);

        //--------------------------------------------------------发送请求

        //跳到下一个页面
        Intent intent = new Intent(this, AddCustomActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("user", user);
        intent.putExtras(bundle);
        startActivity(intent);
        isActivityAcahe = false;
        //finishActivitys(new String[]{"MainActivity", "Register1Activity", "Register2Activity"});
    }
}