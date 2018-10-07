package com.xiaoyaook.chatroom.service.impl;

import com.xiaoyaook.chatroom.dao.GroupInfoDao;
import com.xiaoyaook.chatroom.dao.UserInfoDao;
import com.xiaoyaook.chatroom.entity.GroupInfo;
import com.xiaoyaook.chatroom.entity.UserInfo;
import com.xiaoyaook.chatroom.redis.RedisKeyUtil;
import com.xiaoyaook.chatroom.service.RelationLoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * created by xiaoyaook on 18-10-7
 *
 * 渲染页面时加载
 * 好友关系
 * 群组关系
 * 群组成员
 */
@Service
public class RelationLoadServiceImpl implements RelationLoadService {

    @Autowired
    private SetOperations<String, Object> setOperations;

    @Autowired
    private GroupInfoDao groupInfoDao;

    @Autowired
    private UserInfoDao userInfoDao;

    /**
     * 加载好友关系
     *
     * @param id
     */
    @Override
    public void loadFriendsRelationship(Long id) {
        String key = RedisKeyUtil.getFriendsKey(id);
        Set<Object> result = setOperations.members(key);
        for (Object obj: result) {
            if (obj instanceof UserInfo) {
                System.out.println("UserInfo" + (UserInfo) obj);
            }
        }
    }

    /**
     * 加载群组关系
     *
     * @param id
     */
    @Override
    public void loadGroupsRelationship(Long id) {
        String key = RedisKeyUtil.getGroupsKey(id);
        Set<Object> result = setOperations.members(key);
        for (Object obj: result) {
            if (obj instanceof GroupInfo) {
                System.out.println("GroupInfo" + ((GroupInfo) obj).getGroupName());
            }
        }
    }

    /**
     * 加载群组成员
     *
     * @param id
     */
    @Override
    public void loadGroupRelationship(Long id) {
        String key = RedisKeyUtil.getGroupKey(id);
        Set<Object> result = setOperations.members(key);
        for (Object obj: result) {
            if (obj instanceof UserInfo) {
                System.out.println("UserInfo" + (UserInfo) obj);
            }
        }
    }
}
