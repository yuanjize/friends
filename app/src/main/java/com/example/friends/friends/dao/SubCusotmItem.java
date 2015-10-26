package com.example.friends.friends.dao;

import java.util.List;

/**
 * Created by yjz on 2015/10/25.
 */
public class SubCusotmItem {
    private String customName;
    private int insistDay;
    private List<String> pictures;

    public String getCustomName() {
        return customName;
    }

    public void setCustomName(String customName) {
        this.customName = customName;
    }

    public int getInsistDay() {
        return insistDay;
    }

    public void setInsistDay(int insistDay) {
        this.insistDay = insistDay;
    }

    public List<String> getPictures() {
        return pictures;
    }

    public void setPictures(List<String> pictures) {
        this.pictures = pictures;
    }

    public SubCusotmItem(String customName, int insistDay, List<String> pictures) {

        this.customName = customName;
        this.insistDay = insistDay;
        this.pictures = pictures;
    }
}
