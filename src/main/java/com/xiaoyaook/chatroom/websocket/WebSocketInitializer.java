package com.xiaoyaook.chatroom.websocket;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.stream.ChunkedWriteHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * created by xiaoyaook on 18-10-2
 */
@Component
@Qualifier("WebSocketInitializer")
public class WebSocketInitializer extends ChannelInitializer<SocketChannel> {

    @Autowired
    @Qualifier("WebSocketServerHandler")
    private ChannelHandler webSocketServerHandler;

    @Autowired
    @Qualifier("HttpRequestHandler")
    private ChannelHandler httpRequestHandler;

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ch.pipeline().addLast("http-codec", new HttpServerCodec()) // HTTP编码解码器
            .addLast("aggregator", new HttpObjectAggregator(65536)) // 把HTTP头、HTTP体拼成完整的HTTP请求
            .addLast("http-chunked", new ChunkedWriteHandler()) // 方便大文件传输，不过实质上都是短的文本数据
            .addLast("http-handler", httpRequestHandler)
            .addLast("websocket-handler",webSocketServerHandler);
    }
}
