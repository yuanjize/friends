package com.example.friends.friends.dao;

/**
 * Created by yjz on 2015/10/22.
 */
public class ActivityItem {

    private String userHead;
    private String activityName;
    private String userName;
    private String content;
    private String time;
    private boolean isRunning;

    public ActivityItem(String activityName, String content, boolean isRunning, String time, String userHead, String userName) {
        this.activityName = activityName;
        this.content = content;
        this.isRunning = isRunning;
        this.time = time;
        this.userHead = userHead;
        this.userName = userName;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setIsRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUserHead() {
        return userHead;
    }

    public void setUserHead(String userHead) {
        this.userHead = userHead;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
