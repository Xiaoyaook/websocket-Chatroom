package com.xiaoyaook.chatroom.dao;

import com.xiaoyaook.chatroom.entity.GroupInfo;

/**
 * created by xiaoyaook on 18-10-2
 */
public interface GroupInfoDao {

    void loadGroupInfo();

    GroupInfo getByGroupId(String groupId);
}
