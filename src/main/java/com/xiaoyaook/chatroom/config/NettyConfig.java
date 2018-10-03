package com.xiaoyaook.chatroom.config;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * created by xiaoyaook on 18-10-2
 */
@Configuration
public class NettyConfig {

    @Bean
    @Qualifier("BossGroup")
    public EventLoopGroup bossGroup() {
        final EventLoopGroup bossGroup = new NioEventLoopGroup();
        return bossGroup;
    }

    @Bean
    @Qualifier("WorkerGroup")
    public EventLoopGroup workerGroup() {
        final EventLoopGroup workerGroup = new NioEventLoopGroup();
        return workerGroup;
    }

    @Bean
    public ServerBootstrap serverBootstrap() {
        final ServerBootstrap serverBootstrap = new ServerBootstrap();
        return serverBootstrap;
    }
}
