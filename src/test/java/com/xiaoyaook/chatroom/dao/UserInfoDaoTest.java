package com.xiaoyaook.chatroom.dao;

import com.xiaoyaook.chatroom.ChatroomApplication;
import com.xiaoyaook.chatroom.entity.UserInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * created by xiaoyaook on 18-10-6
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ChatroomApplication.class)
public class UserInfoDaoTest {

    @Autowired
    UserInfoDao userInfoDao;

    @Test
    public void getByUsernameTest() {
        UserInfo userInfo = userInfoDao.getByUsername("member001");
        Assert.assertEquals(userInfo.getPassword(), "001");
    }
}