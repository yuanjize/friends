package com.example.friends.friends.activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.friends.friends.R;
import com.example.friends.friends.Utils.LoginUtils;
import com.example.friends.friends.Utils.TextUtils;
import com.example.friends.friends.bases.BaseActivity;
import com.example.friends.friends.dao.User;

public class LoginActivity extends BaseActivity implements View.OnClickListener {
    private EditText password;
    private EditText username;
    //private ImageView forgetPassword;
    private TextView login;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();

    }

    private void init() {
        password = (EditText) findViewById(R.id.user_password);
        username = (EditText) findViewById(R.id.user_name);
        login = (TextView) findViewById(R.id.log_in);
        //    forgetPassword = (ImageView) findViewById(R.id.forget_password);
        //forgetPassword.setOnClickListener(this);
        username.setOnClickListener(this);
        login.setOnClickListener(this);
        password.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_login, menu);
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
            case R.id.log_in:
                String passwd = password.getText().toString();
                String userName = username.getText().toString();
                if (TextUtils.isEmpty(userName)) {
                    Toast.makeText(LoginActivity.this, "用户名不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(passwd)) {
                    Toast.makeText(LoginActivity.this, "密码不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                //将信息发送到服务器进行登录
                LoginUtils.login(userName, passwd, this);
                break;
        }
    }
}
