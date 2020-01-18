package com.alan.demo.redis;

import redis.clients.jedis.Jedis;

/**
 * @Description 使用Jedis操作 String类型的数据
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/13
 */

public class StringRedisPrimary {

    //Redis所在的linux的IP
    final String CONST_HOST = "192.168.1.7";

    final String COUNT_PORT = "6379";

    public static void main(String[] args) {

        //创建Jedis对象,通过Jedis的方法,操作Redis数据
//        int port = 6379
        Jedis jedis = new Jedis();
    }
}
