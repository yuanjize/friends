package com.example.friends.friends.activity;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.friends.friends.R;
import com.example.friends.friends.Utils.ThirdUtils;
import com.example.friends.friends.bases.BaseActivity;

import cn.sharesdk.sina.weibo.SinaWeibo;
import cn.sharesdk.tencent.qq.QQ;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    private ImageView QQLogin;

    private ImageView WeiBoLogin;

    private TextView register;

    private TextView login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        init();
    }


    private void init() {
        QQLogin = (ImageView) findViewById(R.id.qq_login);
        WeiBoLogin = (ImageView) findViewById(R.id.weibo_login);
        register = (TextView) findViewById(R.id.register);
        login = (TextView) findViewById(R.id.login);
        register.setOnClickListener(this);
        login.setOnClickListener(this);
        QQLogin.setOnClickListener(this);
        WeiBoLogin.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_splash, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login:
                //startActivity(new Intent(this, LoginActivity.class));
                startActivity(new Intent(this, AddCustomActivity.class));
                break;
            case R.id.register:
                startActivity(new Intent(this, Register1Activity.class));
                break;
            case R.id.qq_login:
                ThirdUtils.login(this, QQ.NAME);
                break;
            case R.id.weibo_login:
                ThirdUtils.login(this, SinaWeibo.NAME);
                break;
        }

    }
}
