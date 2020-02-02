package com.alan.demo.redis;

import com.alan.demo.utils.RedisUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;

/**
 * @Description 使用Jedis操作 String类型的数据
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/13
 */

public class StringRedisPrimary {

    //Redis所在的linux的IP
    final static String CONST_HOST = "192.168.1.6";

    final static int COUNT_PORT = 6379;

    public static void main(String[] args) {

        //创建Jedis对象,通过Jedis的方法,操作Redis数据
//        int port = 6379
//        Jedis jedis = new Jedis(CONST_HOST, Integer.parseInt(COUNT_PORT));

        Jedis jedis = null;
        JedisPool pool = null;

        try {
            //获取Pool,从Pool中获取Jedis对象
            pool = RedisUtils.open(CONST_HOST, COUNT_PORT);
            jedis = pool.getResource();

            //设置访问密码
            jedis.auth("123456");

            //通过jedis的方法操作Redis数据
            jedis.set("break", "豆浆和油条");


            //获取数据
            String value = jedis.get("break");
            System.out.println("break :" + value);

            //创建多个key-value
            jedis.mset("lunch", "红烧肉", "dinner", "小面");

            //获取多个key的值
            List<String> values = jedis.mget("break", "lunch", "dinner");

            values.forEach(val -> {
                System.out.println(val);
            });


            //查询id = 1 Student  key == student:1
            //及作为缓存使用
            if (jedis.exists("student:1")) {
                String student = jedis.get("student:1");
            } else {
                //访问数据库 ,Student对象
                //把Student转为json数据
                jedis.set("student:1", "{student}");
            }
        } finally {
            //把使用完毕的jedis放回Pool中,让其他的客户端使用
            if (jedis != null) {
                jedis.close();
            }
        }
    }
}
