package com.alan.demo.controller.redis.String;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Description String 类型的 Redis操作
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
    private RedisTemplate redisTemplate;


    @RequestMapping(value = "/demo1", method = RequestMethod.GET)
    public void demo1() {
        //设置k,v
        redisTemplate.opsForValue().set("name", "bpf");
        //取值
        System.out.println(redisTemplate.opsForValue().get("name"));
    }

    @RequestMapping(value = "/demo2", method = RequestMethod.GET)
    public void demo2() throws InterruptedException {
        //设置k,v以及有效时长，TimeUnit为单位
        redisTemplate.opsForValue().set("name", "bpf", 10, TimeUnit.SECONDS);
        Thread.sleep(11000);
        System.out.println(redisTemplate.opsForValue().get("name"));
    }

    @RequestMapping(value = "/demo3", method = RequestMethod.GET)
    public void demo3() {
        redisTemplate.opsForValue().set("key", "hello world");
        //从偏移量开始对给定key的value进行覆写，若key不存在，则前面偏移量为空
        redisTemplate.opsForValue().set("key", "redis", 6);
        System.out.println(redisTemplate.opsForValue().get("key"));
    }

    @RequestMapping(value = "/demo4", method = RequestMethod.GET)
    public void demo4() {
        redisTemplate.opsForValue().set("name", "test");
        //若key不存在，设值
        redisTemplate.opsForValue().setIfAbsent("name", "test2");
        System.out.println(redisTemplate.opsForValue().get("name"));//还是test
    }

    @RequestMapping(value = "/demo5", method = RequestMethod.GET)
    public void demo5() {
        //批量k,v设值
        Map<String, String> map = new HashMap<String, String>();
        map.put("k1", "v1");
        map.put("k2", "v2");
        map.put("k3", "v3");
        redisTemplate.opsForValue().multiSet(map);

        //批量取值
        List<String> keys = new ArrayList<String>();
        keys.add("k1");
        keys.add("k2");
        keys.add("k3");
        List<String> values = redisTemplate.opsForValue().multiGet(keys);
        System.out.println(values);

        //批量设值，若key不存在，设值
        //redisTemplate.opsForValue().multiSetIfAbsent(map);

    }

    @RequestMapping(value = "/demo6", method = RequestMethod.GET)
    public void demo6() {
        redisTemplate.opsForValue().set("name", "bpf");
        //设值并返回旧值，无旧值返回null
        System.out.println(redisTemplate.opsForValue().getAndSet("ttt", "calvin"));
    }

    @RequestMapping(value = "/demo7", method = RequestMethod.GET)
    public void demo7() {
        //自增操作，原子性。可以对long进行double自增，但不能对double进行long自增，会抛出异常
        redisTemplate.opsForValue().increment("count", 1L);//增量为long
        System.out.println(redisTemplate.opsForValue().get("count"));

        redisTemplate.opsForValue().increment("count", 1.1);//增量为double
        System.out.println(redisTemplate.opsForValue().get("count"));
    }

    @RequestMapping(value = "/demo8", method = RequestMethod.GET)
    public void demo8() {
        //key不存在，设值
        redisTemplate.opsForValue().append("str", "hello");
        System.out.println(redisTemplate.opsForValue().get("str"));
        //key存在，追加
        redisTemplate.opsForValue().append("str", " world");
        System.out.println(redisTemplate.opsForValue().get("str"));

    }

    @RequestMapping(value = "/demo9", method = RequestMethod.GET)
    public void demo9() {
        redisTemplate.opsForValue().set("key", "hello world");
        //value的长度
        System.out.println(redisTemplate.opsForValue().size("key"));//11
    }

    @RequestMapping(value = "/demo10", method = RequestMethod.GET)
    public void demo10() {
        redisTemplate.opsForValue().set("bitTest", "a");
        // 'a' 的ASCII码是 97  转换为二进制是：01100001
        // 'b' 的ASCII码是 98  转换为二进制是：01100010
        // 'c' 的ASCII码是 99  转换为二进制是：01100011

        //因为二进制只有0和1，在setbit中true为1，false为0，因此我要变为'b'的话第六位设置为1，第七位设置为0
        redisTemplate.opsForValue().setBit("bitTest", 6, true);
        redisTemplate.opsForValue().setBit("bitTest", 7, false);
        System.out.println(redisTemplate.opsForValue().get("bitTest"));

        //判断offset处是true1还是false0
        System.out.println(redisTemplate.opsForValue().getBit("bitTest", 7));
    }

}



