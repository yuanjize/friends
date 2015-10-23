package com.example.friends.friends.dao;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.List;

/**
 * Created by yjz on 2015/9/7.
 */
public class User implements Serializable {
    private String userGender = null;
    private String userIcon = null;
    private String userId = null;
    private String userName = null;
    private String password = null;
    private String mysign = null;
    private String emotion = null;
    private List<Custom> customs;

    public List<Custom> getCustoms() {
        return customs;
    }

    public void setCustoms(List<Custom> customs) {
        this.customs = customs;
    }

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    private List<String> labels = null;

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmotion() {
        return emotion;
    }

    public void setEmotion(String emotion) {
        this.emotion = emotion;
    }

    private String birthday;


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMysign() {
        return mysign;
    }

    public void setMysign(String mysign) {
        this.mysign = mysign;
    }

    public User() {
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public String getUserIcon() {
        return userIcon;
    }

    public void setUserIcon(String userIcon) {
        this.userIcon = userIcon;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public User(String userGender, String userIcon, String userId, String userName) {
        this.userGender = userGender;
        this.userIcon = userIcon;
        this.userId = userId;
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "User{" +
                "birthday='" + birthday + '\'' +
                ", userGender='" + userGender + '\'' +
                ", userIcon='" + userIcon + '\'' +
                ", userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", mysign='" + mysign + '\'' +
                ", emotion='" + emotion + '\'' +
                '}';
    }
}
