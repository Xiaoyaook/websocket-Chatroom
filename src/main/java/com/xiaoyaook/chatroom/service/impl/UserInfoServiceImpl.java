package com.xiaoyaook.chatroom.service.impl;

import com.xiaoyaook.chatroom.dao.UserInfoDao;
import com.xiaoyaook.chatroom.entity.UserInfo;
import com.xiaoyaook.chatroom.response.ResponseJson;
import com.xiaoyaook.chatroom.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * created by xiaoyaook on 18-10-3
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    public ResponseJson getByUsername(String username) {
        UserInfo userInfo = userInfoDao.getByUsername(username);
        return new ResponseJson().success()
                .setData("userInfo", userInfo);
    }
}
