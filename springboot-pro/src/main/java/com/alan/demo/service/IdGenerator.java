package com.alan.demo.service;

/**
 * @Description ID生成工具类
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/2/7
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
public class IdGenerator {


    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private static final String ID_KEY = "id:generator:cart";

    /**
     * 生成全区唯一id
     *
     * @return
     */
    public Long incrementId() {

        long n = this.stringRedisTemplate.opsForValue().increment(ID_KEY);

        return n;

    }

}