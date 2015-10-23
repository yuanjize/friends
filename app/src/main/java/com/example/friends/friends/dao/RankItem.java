package com.example.friends.friends.dao;

/**
 * Created by yjz on 2015/10/22.
 */
public class RankItem {
    private String groupHead;
    private String groupNmae;

    public RankItem(String groupHead, String groupNmae) {
        this.groupHead = groupHead;
        this.groupNmae = groupNmae;
    }

    public String getGroupHead() {
        return groupHead;
    }

    public void setGroupHead(String groupHead) {
        this.groupHead = groupHead;
    }

    public String getGroupNmae() {
        return groupNmae;
    }

    public void setGroupNmae(String groupNmae) {
        this.groupNmae = groupNmae;
    }
}
