package com.xiaoyaook.chatroom.service;

import com.xiaoyaook.chatroom.response.ResponseJson;

/**
 * created by xiaoyaook on 18-10-3
 */
public interface UserInfoService {

    ResponseJson getByUserId(String userId);
}
