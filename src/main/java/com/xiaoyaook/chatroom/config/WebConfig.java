package com.xiaoyaook.chatroom.config;

import com.xiaoyaook.chatroom.interceptor.UserAuthInteceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * created by xiaoyaook on 18-10-3
 *
 * 解析器和拦截器在此注册
 */
@Configuration
public class WebConfig  implements WebMvcConfigurer {

    @Autowired
    UserAuthInteceptor userAuthInteceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(userAuthInteceptor).addPathPatterns("/chatroom/**");
    }
}
