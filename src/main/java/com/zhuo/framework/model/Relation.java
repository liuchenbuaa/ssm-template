package com.zhuo.framework.model;

import java.util.Date;

/**
 * @author liuchen <liuchen03@kuaishou.com>
 * Created on 2018-12-07
 */
public class Relation {

    private int id;
    private int userId;
    private int friendId;
    private int status;
    private int requestCommentId;
    private Date createTime;

    public static Relation fromRaw(int userId, int friendId, int status, int requestCommentId) {
        Relation relation = new Relation();
        relation.setUserId(userId);
        relation.setFriendId(friendId);
        relation.setStatus(status);
        relation.setRequestCommentId(requestCommentId);
        return relation;
    }

    public int getRequestCommentId() {
        return requestCommentId;
    }

    public void setRequestCommentId(int requestCommentId) {
        this.requestCommentId = requestCommentId;
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

    public int getFriendId() {
        return friendId;
    }

    public void setFriendId(int friendId) {
        this.friendId = friendId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
