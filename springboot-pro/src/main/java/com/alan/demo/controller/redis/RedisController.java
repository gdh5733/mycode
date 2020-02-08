package com.alan.demo.controller.redis;

import com.alan.demo.entity.UserEntity;
import com.alan.demo.utils.RedisUtils;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;


/**
 * @Description 测试redis的使用
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2019/12/28
 */

@Slf4j
@RequestMapping("/redis")
@RestController
public class RedisController {

    private static int ExpireTime = 360;   // redis中存储的过期时间60s

    @Resource
    private RedisUtils redisUtil;

    @RequestMapping("set")
    public boolean redisset(String key, String value) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(Long.valueOf(1));
        userEntity.setGuid(String.valueOf(1));
        userEntity.setName("zhangsan");
        userEntity.setAge(String.valueOf(20));
        userEntity.setCreateTime(new Date());

        return redisUtil.set("user", userEntity);

    }

    @RequestMapping("get")
    public Object redisget(String key) {
        return redisUtil.get(key, UserEntity.class);
    }


}

