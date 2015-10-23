package com.example.friends.friends.activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.friends.friends.R;
import com.example.friends.friends.Utils.PictureUtils;
import com.example.friends.friends.Utils.SDCardUtils;
import com.example.friends.friends.Utils.TextUtils;
import com.example.friends.friends.bases.BaseActivity;
import com.example.friends.friends.dao.User;
import com.example.friends.friends.views.BeautifulDialog;

import java.io.File;


public class Register1Activity extends BaseActivity implements View.OnClickListener {
    private static final int CROP_PICTURE = 96;
    private static boolean isBackFromPicture = false;

    private TextView birthday;
    private EditText name;
    private StringBuffer birthdaydate;
    private String sex;
    private String emotion;
    private ImageView headImage;
    private FloatingActionButton picHead;
    private TextView next;
    private EditText password;
    private EditText mysign;

    private CheckBox man;
    private CheckBox woman;
    private CheckBox hotlove;
    private CheckBox singal;
    private CheckBox secret;
    private User user;


    private String userName;
    private String userPassword;
    private String userSign;
    private String userBirthday;
    private String userIcon;
    private final static int PICK_PICTURE_CAMERA = 33;
    private final static int PICK_PICTURE_KU = 38;
    private Uri file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register1);
        init();
        getData();
    }

    @Override
    protected boolean saveInfo() {
        userName = name.getText().toString();
        userIcon = user.getUserIcon();
        userSign = mysign.getText().toString();
        userPassword = password.getText().toString();
        userBirthday = birthday.getText().toString();
        if (!TextUtils.isEmpty(new String[]{userIcon, userName, sex, emotion, userBirthday, userSign, userPassword})) {
            user.setMysign(userSign);
            user.setUserName(userName);
            user.setPassword(userPassword);
            user.setUserGender(sex);
            user.setBirthday(userBirthday);
            user.setEmotion(emotion);
            user.setUserIcon(userIcon);
            return true;
        }

        Toast.makeText(Register1Activity.this, "请把信息(包括头像)填写完整", Toast.LENGTH_SHORT).show();
        return false;
    }


    //从选择标签返回时，读取已经写过的信息
    @Override
    protected void onRestart() {
        super.onRestart();
        if (!isBackFromPicture) {
            recoverUserInfor();
        }


    }

    private void recoverUserInfor() {
        name.setText(user.getUserName());
        birthday.setText(user.getBirthday());
        if (user.getUserGender().trim().equals("m")) {
            man.setChecked(true);
        } else {
            woman.setChecked(true);
        }
        if (user.getEmotion().trim().equals("热恋")) {
            hotlove.setChecked(true);
        } else if (user.getEmotion().trim().equals("秘密")) {
            secret.setChecked(true);
        } else {
            singal.setChecked(true);
        }

        password.setText(user.getPassword());
        mysign.setText(user.getMysign());
        bitmapUtils.display(headImage, user.getUserIcon());
    }

    private void getData() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            user = (User) bundle.get("user");
            if (user != null) {
                if (user.getUserGender().trim().equals("m")) {
                    man.setChecked(true);
                    sex = "m";
                } else {
                    woman.setChecked(true);
                    sex = "w";
                }
                name.setText(user.getUserName());
                bitmapUtils.display(headImage, user.getUserIcon());
            }
        } else {
            user = new User();
        }


        //获取图片

    }

    private CheckBox getCheckedBox(CheckBox[] boxs) {
        for (CheckBox box : boxs) {
            if (box.isChecked()) {
                return box;
            }
        }
        return null;
    }

    private void init() {
        picHead = (FloatingActionButton) findViewById(R.id.pick_photo);
        headImage = (ImageView) findViewById(R.id.head);
        next = (TextView) findViewById(R.id.next);

        man = (CheckBox) findViewById(R.id.man);
        woman = (CheckBox) findViewById(R.id.woman);
        hotlove = (CheckBox) findViewById(R.id.hotlove);
        singal = (CheckBox) findViewById(R.id.single);
        secret = (CheckBox) findViewById(R.id.secret);
        birthday = (TextView) findViewById(R.id.birthday);
        name = (EditText) findViewById(R.id.name);
        password = (EditText) findViewById(R.id.password);
        mysign = (EditText) findViewById(R.id.mysign);

        birthday.setOnClickListener(this);
        man.setOnClickListener(this);
        woman.setOnClickListener(this);
        singal.setOnClickListener(this);
        secret.setOnClickListener(this);
        hotlove.setOnClickListener(this);
        picHead.setOnClickListener(this);
        headImage.setOnClickListener(this);
        next.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_register1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        switch (id) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.birthday:
                chooseDate();
                break;
            case R.id.man:
                clearSexAndCheck(v);
                sex = "m";
                break;
            case R.id.woman:
                clearSexAndCheck(v);
                sex = "w";
                break;
            case R.id.single:
                clearEmotionAndCheck(v);
                emotion = "单身";
                break;
            case R.id.secret:
                clearEmotionAndCheck(v);
                emotion = "秘密";
                break;
            case R.id.hotlove:
                clearEmotionAndCheck(v);
                emotion = "热恋";
                break;
            case R.id.next:
                if (saveInfo()) {
                    isBackFromPicture = false;
                    Intent intent = new Intent(this, Register2Activity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("user", user);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
                break;
            case R.id.pick_photo:
                getPicture();
                break;
        }

    }


    private void getPicture() {
        View view = View.inflate(this, R.layout.dialog_pic_layout, null);
        final BeautifulDialog dialog = new BeautifulDialog(this, R.style.MyDialog);
        dialog.setView(view);
        //从照相机选取
        view.findViewById(R.id.camera_pick).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                file = SDCardUtils.getPictureSavePath(user.getUserId());
                intent.putExtra(MediaStore.EXTRA_OUTPUT, file);
                user.setUserIcon(file.getPath());
                isBackFromPicture = true;
                startActivityForResult(intent, PICK_PICTURE_CAMERA);
                dialog.dismiss();
            }
        });
        //从图库选取
        view.findViewById(R.id.image_pick).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                file = SDCardUtils.getPictureSavePath(user.getUserId());
                user.setUserIcon(file.getPath());
                Intent albumIntent = new Intent(Intent.ACTION_PICK, null);
                albumIntent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                isBackFromPicture = true;
                startActivityForResult(albumIntent, PICK_PICTURE_KU);
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        System.out.println(requestCode + "......." + requestCode + data + "................");

        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case PICK_PICTURE_CAMERA:
                if (resultCode == RESULT_OK) {
                    if (file != null) {
                        PictureUtils.crop(this, file, headImage);
                    }
                }
                break;
            case PICK_PICTURE_KU:
                if (data.getData() != null) {
                    PictureUtils.crop(this, data.getData(), headImage);
                }
                break;
            case CROP_PICTURE:
                Bitmap bit = null;
                if (data != null) {
                    bit = data.getExtras().getParcelable("data");
                    if (bit != null) {
                        new File(file.getPath()).delete();
                        PictureUtils.savePicture(file, bit);
                        bitmapUtils.clearCache(file.getPath());
                        bitmapUtils.display(headImage, file.getPath());
                    }
                }
                break;
        }
    }

    private void clearEmotionAndCheck(View v) {
        hotlove.setChecked(false);
        singal.setChecked(false);
        secret.setChecked(false);
        ((CheckBox) v).setChecked(true);
    }

    private void clearSexAndCheck(View v) {
        man.setChecked(false);
        woman.setChecked(false);
        ((CheckBox) v).setChecked(true);
    }


    private void chooseDate() {
        new DatePickerDialog(this, android.R.style.Theme_Holo_Dialog, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                String Year = Integer.toString(view.getYear());
                String Month = Integer.toString(view.getMonth());
                String Day = Integer.toString(view.getDayOfMonth());
                if (Month.length() < 2) {
                    Month = "0" + Month;
                }
                if (Day.length() < 2) {
                    Day = "0" + Day;
                }
                if (birthdaydate == null) {
                    birthdaydate = new StringBuffer();
                }
                String date = birthdaydate.append(Year).append("年 ").append(Month).append("月 ").append(Day).append("日 ").toString();
                birthdaydate.replace(0, birthdaydate.length(), "");
                birthday.setText(date);

            }

        }, 2000, 1, 1).show();
    }
}

