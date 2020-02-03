package com.alan.demo.redis;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @Description redis 事务
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/2/2
 */

public class RedisTransaction {

    //Redis所在的linux的IP
    final static String CONST_HOST = "192.168.1.6";

    final static int COUNT_PORT = 6379;

    public static void main(String[] args) {
        Jedis jedis = null;
        JedisPool pool = null;
    }

}
