package com.zhuo.framework.model;

import java.util.Date;

/**
 * Created by liuchen on 18/2/24.
 */
public class User {

    public User() {
    }

    private int id;

    private String nickName;

    private boolean gender;

    private Date createTime;
    private int imgIndex;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getImgIndex() {
        return imgIndex;
    }

    public void setImgIndex(int imgIndex) {
        this.imgIndex = imgIndex;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nickName='" + nickName + '\'' +
                ", gender=" + gender +
                ", createTime=" + createTime +
                ", imgIndex=" + imgIndex +
                '}';
    }
}
