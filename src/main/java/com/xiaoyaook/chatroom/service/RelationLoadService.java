package com.xiaoyaook.chatroom.service;

/**
 * created by xiaoyaook on 18-10-7
 *
 * 加载关系
 */
public interface RelationLoadService {

    void loadFriendsRelationship(Long id);

    void loadGroupsRelationship(Long id);

    void loadGroupRelationship(Long id);
}
