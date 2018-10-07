package com.xiaoyaook.chatroom.dao;

import com.xiaoyaook.chatroom.entity.GroupInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * created by xiaoyaook on 18-10-2
 */
@Mapper
public interface GroupInfoDao {

    @Select("select * from group_info where id = #{id}")
    GroupInfo getById(@Param("id") Long id);
}
