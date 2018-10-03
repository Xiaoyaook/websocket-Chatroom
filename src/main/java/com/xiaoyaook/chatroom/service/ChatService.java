package com.xiaoyaook.chatroom.service;

import com.alibaba.fastjson.JSONObject;
import io.netty.channel.ChannelHandlerContext;

/**
 * created by xiaoyaook on 18-10-2
 */
public interface ChatService {
    void register(JSONObject param, ChannelHandlerContext ctx);

    void singleSend(JSONObject param, ChannelHandlerContext ctx);

    void groupSend(JSONObject param, ChannelHandlerContext ctx);

    void FileMsgSingleSend(JSONObject param, ChannelHandlerContext ctx);

    void FileMsgGroupSend(JSONObject param, ChannelHandlerContext ctx);

    void remove(ChannelHandlerContext ctx);

    void typeError(ChannelHandlerContext ctx);
}
