package com.xiaoyaook.chatroom.service;

import com.xiaoyaook.chatroom.response.ResponseJson;

import javax.servlet.http.HttpSession;

/**
 * created by xiaoyaook on 18-10-3
 */
public interface SecurityService {

    ResponseJson login(String username, String password, HttpSession session);

    ResponseJson logout(HttpSession session);
}
