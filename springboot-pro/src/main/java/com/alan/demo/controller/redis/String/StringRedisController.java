package com.alan.demo.controller.redis.String;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/3/4
 */
@Slf4j
@RequestMapping("/redis-String")
@RestController
public class StringRedisController {

    @Autowired
    private StringRedisTemplate redisTemplate;


}
