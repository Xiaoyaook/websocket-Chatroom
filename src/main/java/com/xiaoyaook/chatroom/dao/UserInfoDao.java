package com.xiaoyaook.chatroom.dao;

import com.xiaoyaook.chatroom.entity.UserInfo;

/**
 * created by xiaoyaook on 18-10-2
 */
public interface UserInfoDao {
    void loadUserInfo();

    UserInfo getByUsername(String username);

    UserInfo getByUserId(String userId);
}
