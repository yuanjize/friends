package com.example.friends.friends.dao;

import com.example.friends.friends.Utils.ImageLaodUtils;

/**
 * Created by yjz on 2015/10/11.
 */
public class DynamticInfo {
    private String userHead;
    private String userName;
    private String userSignIn;
    private String dynamiticDescription;
    private String userInsistDay;
    private String userSendData;
    private String descripPicture;
    private String groupHead;
    private String groupName;
    private int approve;
    private int comment;

    public String getDynamiticDescription() {
        return dynamiticDescription;
    }

    public DynamticInfo(int id1, int id2, int id3, String pagename) {
        userHead = ImageLaodUtils.getResourceUri(id1, pagename);
        descripPicture = ImageLaodUtils.getResourceUri(id2, pagename);
        groupHead = ImageLaodUtils.getResourceUri(id3, pagename);
        userName = "特拉法尔加$Luo";
        userInsistDay = "5";
        userSignIn = "#今日长跑#";
        dynamiticDescription = "今天了死了 ^_^";
        userSendData = "3月5日";
        groupName = "悦跑团";
        approve = 46;
        comment = 39;
    }

    public void setDynamiticDescription(String dynamiticDescription) {
        this.dynamiticDescription = dynamiticDescription;
    }

    public int getApprove() {
        return approve;
    }

    public void setApprove(int approve) {
        this.approve = approve;
    }

    public int getComment() {
        return comment;
    }

    public void setComment(int comment) {
        this.comment = comment;
    }

    public String getDescripPicture() {
        return descripPicture;
    }

    public void setDescripPicture(String descripPicture) {
        this.descripPicture = descripPicture;
    }

    public String getGroupHead() {
        return groupHead;
    }

    public void setGroupHead(String groupHead) {
        this.groupHead = groupHead;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getUserHead() {
        return userHead;
    }

    public void setUserHead(String userHead) {
        this.userHead = userHead;
    }

    public String getUserInsistDay() {
        return userInsistDay;
    }

    public void setUserInsistDay(String userInsistDay) {
        this.userInsistDay = userInsistDay;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSendData() {
        return userSendData;
    }

    public void setUserSendData(String userSendData) {
        this.userSendData = userSendData;
    }

    public String getUserSignIn() {
        return userSignIn;
    }

    public void setUserSignIn(String userSignIn) {
        this.userSignIn = userSignIn;
    }
}
