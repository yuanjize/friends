package com.example.friends.friends.dao;

/**
 * Created by yjz on 2015/9/24.
 */
public class Custom {
    private String customName;
    private String insistDays;

    public Custom() {
        this.customName = "跑步";
        this.insistDays = "坚持23天";
    }

    public String getCustomName() {
        return customName;
    }

    public void setCustomName(String customName) {
        this.customName = customName;
    }

    public String getInsistDays() {
        return insistDays;
    }

    public void setInsistDays(String insistDays) {
        this.insistDays = insistDays;
    }
}
