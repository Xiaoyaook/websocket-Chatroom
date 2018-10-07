package com.xiaoyaook.chatroom.service.impl;

import com.xiaoyaook.chatroom.dao.GroupInfoDao;
import com.xiaoyaook.chatroom.dao.UserInfoDao;
import com.xiaoyaook.chatroom.service.RelationLoadService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * created by xiaoyaook on 18-10-7
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RelationLoadServiceImplTest {

    @Autowired
    private UserInfoDao userInfoDao;

    @Autowired
    private GroupInfoDao groupInfoDao;

    @Autowired
    private RelationLoadService relationLoadService;

    @Test
    public void testloadFriendsRelationship() {
        relationLoadService.loadFriendsRelationship(1L);
    }

    @Test
    public void testloadGroupsRelationship() {
        relationLoadService.loadGroupsRelationship(1L);
    }

    @Test
    public void testloadGroupRelationship() {
        relationLoadService.loadGroupRelationship(1L);
    }
}