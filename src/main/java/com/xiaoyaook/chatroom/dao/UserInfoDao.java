package com.xiaoyaook.chatroom.dao;

import com.xiaoyaook.chatroom.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * created by xiaoyaook on 18-10-2
 */
@Mapper
public interface UserInfoDao {

    @Select("select * from user_info where username = #{username}")
    UserInfo getByUsername(@Param("username") String username);

    @Select("select * from user_info where id = #{id}")
    UserInfo getById(@Param("id") Long id);
}
