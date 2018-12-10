package com.zhuo.framework.model;

import java.util.Date;

/**
 * @author liuchen <liuchen03@kuaishou.com>
 * Created on 2018-12-07
 */
public class Comment {

    private int id;
    private int authorId;
    private int postId;
    private int userId;
    private String content;
    private Date createTime;
    private boolean isRead = false;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static Comment fromRaw(int authorId, int postId, int userId, String content) {
        Comment comment = new Comment();
        comment.setAuthorId(authorId);
        comment.setPostId(postId);
        comment.setUserId(userId);
        comment.setContent(content);
        return comment;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
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
}
