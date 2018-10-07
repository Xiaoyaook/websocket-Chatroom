package com.xiaoyaook.chatroom;

import com.xiaoyaook.chatroom.dao.GroupInfoDao;
import com.xiaoyaook.chatroom.dao.UserInfoDao;
import com.xiaoyaook.chatroom.websocket.WebSocketServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PreDestroy;

@SpringBootApplication
public class ChatroomApplication implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(ChatroomApplication.class);

    @Autowired
    private WebSocketServer webSocketServer;

    public static void main(String[] args) {
        SpringApplication.run(ChatroomApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("启动Netty WebSocket服务器...");
        webSocketServer.build();
    }

    /**
     * 描述：Tomcat服务器关闭前需要手动关闭Netty Websocket相关资源，否则会造成内存泄漏。
     *      1. 释放Netty Websocket相关连接；
     *      2. 关闭Netty Websocket服务器线程。（强行关闭，是否有必要？）
     */
    @SuppressWarnings("deprecation")
    @PreDestroy
    public void close() {
        logger.info("正在释放Netty Websocket相关连接...");
        webSocketServer.close();
        logger.info("系统成功关闭！");
    }
}
