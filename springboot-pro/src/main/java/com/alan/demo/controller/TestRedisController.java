//package com.alan.demo.controller;
//
//import com.alan.demo.service.TestRedisService;
//import com.alan.demo.utils.RedisUtils;
//import io.swagger.annotations.Api;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//
//import java.util.concurrent.TimeUnit;
//
///**
// * @Description 测试redis的使用
// * @Author gaodehan
// * @Version V1.0.0
// * @Since 1.0
// * @Date 2019/12/28
// */
//
//@Api(description = "测试")
//@RestController
//@Slf4j
//public class TestRedisController {
//    @Autowired
//    TestRedisService testService;
//
//    @Autowired
//    private RedisUtils redisUtils;
//
//    @RequestMapping(value = "/hello/{id}")
//    public String hello(@PathVariable(value = "id") String id) {
//        //查询缓存中是否存在
//        boolean hasKey = redisUtils.exists(id);
//        String str = "";
//        if (hasKey) {
//            //获取缓存
//            Object object = redisUtils.get(id);
//            log.info("从缓存获取的数据" + object);
//            str = object.toString();
//        } else {
//            //从数据库中获取信息
//            log.info("从数据库中获取数据");
//            str = testService.test();
//            //数据插入缓存（set中的参数含义：key值，user对象，缓存存在时间10（long类型），时间单位）
//            redisUtils.set(id, "ceshi", 10L, TimeUnit.MINUTES);
//            log.info("数据插入缓存" + str);
//        }
//        return str;
//    }
//
//
//}
