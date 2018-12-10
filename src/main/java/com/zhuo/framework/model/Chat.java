package com.zhuo.framework.model;

import java.util.Date;

/**
 * @author liuchen <liuchen03@kuaishou.com>
 * Created on 2018-12-08
 */
public class Chat {

    public static Chat fromCommentAndUser(User user, Comment comment, boolean isRead) {
        Chat chat = new Chat();
        chat.setFriendId(user.getId());
        chat.setNickName(user.getNickName());
        chat.setImgIndex(user.getImgIndex());
        chat.setCreateTime(comment.getCreateTime());
        chat.setRead(isRead);
        chat.setContent(comment.getContent());
        return chat;
    }

    private long friendId;
    private String nickName;
    private int imgIndex;
    private Date createTime;
    private String content;
    private boolean isRead;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getFriendId() {
        return friendId;
    }

    public void setFriendId(long friendId) {
        this.friendId = friendId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getImgIndex() {
        return imgIndex;
    }

    public void setImgIndex(int imgIndex) {
        this.imgIndex = imgIndex;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }
}
