package com.zhuo.framework.model;

import java.util.Date;

/**
 * @author liuchen <liuchen03@kuaishou.com>
 * Created on 2018-12-07
 */
public class Post {

    private int id;
    private int userId;
    private String content;
    private Date createTime;
    private int imgIndex;

    public static Post fromRaw(int userId, String content, int imgIndex) {
        Post post = new Post();
        post.setUserId(userId);
        post.setContent(content);
        post.setImgIndex(imgIndex);
        return post;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
}
