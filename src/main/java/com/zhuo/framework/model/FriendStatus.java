package com.zhuo.framework.model;

/**
 * @author liuchen <liuchen03@kuaishou.com>
 * Created on 2018-12-07
 */
public enum FriendStatus {
    NOT_PASS(0),
    REQUEST(1),
    PASS(2);

    FriendStatus(int value) {
        this.value = value;
    }

    int value;

    public int getValue() {
        return value;
    }
}
