package com.alan.demo.controller.redis.Set;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Set;

/**
 * @Description Set 类型操作
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/3/4
 */
@Slf4j
@RequestMapping("/redis-Set")
@RestController
public class SetRedisController {

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping(value = "/demo1", method = RequestMethod.GET)
    public void demo1() {
        //集合中添加元素，返回添加个数
        redisTemplate.opsForSet().add("games", "鬼泣", "古墓丽影", "仙剑奇侠传", "LOL", "DOTA自走棋");
        printSet("games");
    }

    @RequestMapping(value = "/demo2", method = RequestMethod.GET)
    public void demo2() {
        //从集合中删除指定元素
        redisTemplate.opsForSet().remove("games", "鬼泣");
        printSet("games");
    }

    @RequestMapping(value = "/demo3", method = RequestMethod.GET)
    public void demo3() {
        //从集合中随机删除一个元素，并返回该元素
        String item = (String) redisTemplate.opsForSet().pop("games");
        System.out.println(item);
        printSet("games");
    }

    @RequestMapping(value = "/demo4", method = RequestMethod.GET)
    public void demo4() {
        //将集合1中的指定元素移到集合2
        redisTemplate.opsForSet().move("games", "仙剑奇侠传", "chinese-games");
        //打印集合1
        printSet("games");
        //打印集合2
        printSet("chinese-games");
    }

    @RequestMapping(value = "/demo5", method = RequestMethod.GET)
    public void demo5() {
        //获得集合大小
        Long size = redisTemplate.opsForSet().size("games");
        printSet("games");
        System.out.println(size);
    }

    @RequestMapping(value = "/demo6", method = RequestMethod.GET)
    public void demo6() {
        //判断集合中是否存在某元素
        Boolean ifExist = redisTemplate.opsForSet().isMember("games", "LOL");
        System.out.println(ifExist);
    }

    @RequestMapping(value = "/demo7", method = RequestMethod.GET)
    public void demo7() {
        //添加集合a
        redisTemplate.opsForSet().add("set-a", "a", "b", "c", "d");
        //添加集合b
        redisTemplate.opsForSet().add("set-b", "a", "b");
        //求交集
        Set<String> intersection = redisTemplate.opsForSet().intersect("set-a", "set-b");
        //也可以和多个key对应的集合求交集                  Set<V> intersect(K key, K otherKey);
        System.out.println(intersection);
    }

    @RequestMapping(value = "/demo8", method = RequestMethod.GET)
    public void demo8() {
        //添加集合a
        redisTemplate.opsForSet().add("set-a", "a", "b", "c", "d");
        //添加集合b
        redisTemplate.opsForSet().add("set-b", "a", "b");
        //求交集并放入集合c
        redisTemplate.opsForSet().intersectAndStore("set-a", "set-b", "set-c");
        //也可以和多个key对应的集合求交集                 Long intersectAndStore(K key, Collection<K> otherKeys, K destKey);
        //打印集合c
        printSet("set-c");
    }

    @RequestMapping(value = "/demo9", method = RequestMethod.GET)
    public void demo9() {
        //添加集合m
        redisTemplate.opsForSet().add("set-m", "a", "b", "c", "d");
        //添加集合n
        redisTemplate.opsForSet().add("set-n", "c", "d", "e", "f");
        //求并集
        Set<String> union = redisTemplate.opsForSet().union("set-m", "set-n");
        System.out.println(union);

        //其他操作与intersect类似 如和多个key求并集，求并集并放入集合等
    }

    @RequestMapping(value = "/demo10", method = RequestMethod.GET)
    public void demo10() {
        //添加集合d
        redisTemplate.opsForSet().add("set-d", "a", "b", "c", "d");
        //添加集合e
        redisTemplate.opsForSet().add("set-e", "c", "d", "e", "f");
        //添加集合f
        redisTemplate.opsForSet().add("set-f", "e", "f", "g", "h");

        //求差集(属于d不属于e和f)
        Set<String> difference = redisTemplate.opsForSet().difference("set-d", Arrays.asList("set-e", "set-f"));
        System.out.println(difference);
        //其他操作与交集并集类似
    }

    @RequestMapping(value = "/demo11", method = RequestMethod.GET)
    public void demo11() {
        //随机获取集合中的一个元素
        System.out.println(redisTemplate.opsForSet().randomMember("games"));

        //随机获取集合中指定个数的元素（有可能重复）
        System.out.println(redisTemplate.opsForSet().randomMembers("games", 10));

        //随机获取集合中指定个数的元素（不重复）
        System.out.println(redisTemplate.opsForSet().distinctRandomMembers("games", 10));


    }

    /**
     * 打印集合
     *
     * @param key
     * @date 2019年2月12日
     * @author gaodehan
     */
    @RequestMapping(value = "/demo12", method = RequestMethod.GET)
    private void printSet(String key) {
        //获取所有成员
        Set<String> members = redisTemplate.opsForSet().members(key);
        System.out.println(members);
    }


}
