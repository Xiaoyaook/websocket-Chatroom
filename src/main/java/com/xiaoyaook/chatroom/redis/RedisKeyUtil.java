package com.xiaoyaook.chatroom.redis;

/**
 * created by xiaoyaook on 18-10-6
 *
 * redisKey设计
 */
public class RedisKeyUtil {
    /**
     * 好友关系的key
     * 形式为：
     * friends:用户id
     *
     * @param id 用户id
     * @return
     */
    public static String getFriendsKey(Long id){
        StringBuffer buffer = new StringBuffer();
        buffer.append("friends").append(":");
        buffer.append(Long.toString(id));
        return buffer.toString();
    }
    /**
     * 群组关系的key
     * 形式为：
     * groups:用户id
     *
     * @param id 用户id
     * @return
     */
    public static String getGroupsKey(Long id){
        StringBuffer buffer = new StringBuffer();
        buffer.append("groups").append(":");
        buffer.append(Long.toString(id));
        return buffer.toString();
    }

    /**
     * 群组成员的key
     * 形式为：
     * group:群组id
     *
     * @param id 用户id
     * @return
     */
    public static String getGroupKey(Long id){
        StringBuffer buffer = new StringBuffer();
        buffer.append("group").append(":");
        buffer.append(Long.toString(id));
        return buffer.toString();
    }
}
