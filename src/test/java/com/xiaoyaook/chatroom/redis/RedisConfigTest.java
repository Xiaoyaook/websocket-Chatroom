package com.xiaoyaook.chatroom.redis;

import com.xiaoyaook.chatroom.dao.GroupInfoDao;
import com.xiaoyaook.chatroom.dao.UserInfoDao;
import com.xiaoyaook.chatroom.entity.GroupInfo;
import com.xiaoyaook.chatroom.entity.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 * created by xiaoyaook on 18-10-6
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisConfigTest {

    @Autowired
    private UserInfoDao userInfoDao;

    @Autowired
    private GroupInfoDao groupInfoDao;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Resource
    private ValueOperations<String,Object> valueOperations;

    @Autowired
    private HashOperations<String, String, Object> hashOperations;

    @Autowired
    private ListOperations<String, Object> listOperations;

    @Autowired
    private SetOperations<String, Object> setOperations;

    @Autowired
    private ZSetOperations<String, Object> zSetOperations;

    @Resource
    private RedisService redisService;

    @Test
    public void MemberInit() throws Exception {
        // 初始化用户关系函数，暂时放在这里
        UserInfo Member1 = userInfoDao.getByUsername("Member001");
        UserInfo Member2 = userInfoDao.getByUsername("Member002");
        UserInfo Member3 = userInfoDao.getByUsername("Member003");
        // 现在存放数据有些冗余，但是这样省得只存放id，还需要从数据库再取一边数据的消耗
        setOperations.add(RedisKeyUtil.getFriendsKey(Member1.getId()), Member2,Member3);

        GroupInfo Group1 = groupInfoDao.getById(1L);
        setOperations.add(RedisKeyUtil.getGroupsKey(Member1.getId()), Group1);

        setOperations.add(RedisKeyUtil.getGroupKey(1L), Member1, Member2,Member3);
    }

    @Test
    public void testValueOption( )throws  Exception{
        UserVo userVo = new UserVo();
        userVo.setAddress("上海");
        userVo.setName("jantent");
        userVo.setAge(23);
        valueOperations.set("test",userVo);

        System.out.println(valueOperations.get("test"));
    }

    @Test
    public void testSetOperation() throws Exception{
        UserVo userVo = new UserVo();
        userVo.setAddress("北京");
        userVo.setName("jantent");
        userVo.setAge(23);
        UserVo auserVo = new UserVo();
        auserVo.setAddress("n柜昂周");
        auserVo.setName("antent");
        auserVo.setAge(23);
        setOperations.add("user:test",userVo,auserVo);
        Set<Object> result = setOperations.members("user:test");
        System.out.println(result);
    }

    @Test
    public void HashOperations() throws Exception{
        UserVo userVo = new UserVo();
        userVo.setAddress("北京");
        userVo.setName("jantent");
        userVo.setAge(23);
        hashOperations.put("hash:user",userVo.hashCode()+"",userVo);
        System.out.println(hashOperations.get("hash:user",userVo.hashCode()+""));
    }

    @Test
    public void  ListOperations() throws Exception{
        UserVo userVo = new UserVo();
        userVo.setAddress("北京");
        userVo.setName("jantent");
        userVo.setAge(23);
        listOperations.leftPush("list:user",userVo);
//        System.out.println(listOperations.leftPop("list:user"));
        // pop之后 值会消失
        //System.out.println(listOperations.leftPop("list:user"));
    }
}