package com.xiaoyaook.chatroom.controller;

import com.xiaoyaook.chatroom.dao.GroupInfoDao;
import com.xiaoyaook.chatroom.dao.UserInfoDao;
import com.xiaoyaook.chatroom.service.RelationLoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * created by xiaoyaook on 18-10-7
 */
@RestController
@RequestMapping("/load")
public class RelationLoadController {
    @Autowired
    private UserInfoDao userInfoDao;
    @Autowired
    private GroupInfoDao groupInfoDao;
    @Autowired
    private RelationLoadService relationLoadService;

    @GetMapping("/friends/{id}")
    public void loadFriendsRelationship(@PathVariable Long id) {
        relationLoadService.loadFriendsRelationship(id);
    }

    @GetMapping("/groups/{id}")
    public void loadGroupsRelationship(@PathVariable Long id) {
        relationLoadService.loadGroupsRelationship(id);
    }

    @GetMapping("/group/{id}")
    public void loadGroupRelationship(@PathVariable Long id) {
        relationLoadService.loadGroupRelationship(id);
    }
}
