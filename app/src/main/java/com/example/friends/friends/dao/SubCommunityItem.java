package com.example.friends.friends.dao;

/**
 * Created by yjz on 2015/10/24.
 */
public class SubCommunityItem {

    private String groupHead;
    private String groupname;

    public String getGroupHead() {
        return groupHead;
    }

    public void setGroupHead(String groupHead) {
        this.groupHead = groupHead;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public String getGroupSign() {
        return groupSign;
    }

    public void setGroupSign(String groupSign) {
        this.groupSign = groupSign;
    }

    public SubCommunityItem(String groupHead, String groupname, String groupSign) {

        this.groupHead = groupHead;
        this.groupname = groupname;
        this.groupSign = groupSign;
    }

    private String groupSign;


}
