package com.alan.demo.controller.redis.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Description List 类型的操作
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/3/4
 */
@Slf4j
@RequestMapping("/redis-List")
@RestController
public class ListRedisController {

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping(value = "/demo1", method = RequestMethod.GET)
    public void demo1() {
        //从左边插入，即插入到列表头部
        redisTemplate.opsForList().leftPush("product:list", "iphone xs max");
        redisTemplate.opsForList().leftPush("product:list", "thinkpad x1 carbon");
        redisTemplate.opsForList().leftPush("product:list", "mackBook pro13");
        redisTemplate.opsForList().leftPush("product:list", "HuaWei Mate20 pro");
    }

    @RequestMapping(value = "/demo2", method = RequestMethod.GET)
    public void demo2() {
        //从左边插入一个数组
        String[] books = new String[]{"java编程思想", "springboot从入门到精通"};
        redisTemplate.opsForList().leftPushAll("book:list", books);
    }

    @RequestMapping(value = "/demo3", method = RequestMethod.GET)
    public void demo3() {
        //从左边插入一个集合
        List<String> list = new ArrayList<String>();
        list.add("鬼泣5");
        list.add("荒野大镖客2");
        list.add("仙剑奇侠传7");
        redisTemplate.opsForList().leftPushAll("game:list", list);
    }

    @RequestMapping(value = "/demo4", method = RequestMethod.GET)
    public void demo4() {
        //如果存在key对应的列表，则从左插入，不存在不做操作
        redisTemplate.opsForList().leftPushIfPresent("fruit:list", "1");
    }

    @RequestMapping(value = "/demo5", method = RequestMethod.GET)
    public void demo5() {
        //在key对应的列表中从左边开始找，找到第一个pivot，然后把value插到pivot左边，没有不做操作
        redisTemplate.opsForList().leftPush("product:list", "HuaWei Mate20X", "xiaomi mix");
    }

    //也可以从右边插入，把上面的left改为right即可

    @RequestMapping(value = "/demo6", method = RequestMethod.GET)
    public void demo6() {
        //指定位置重新设置指定值
        redisTemplate.opsForList().set("product:list", 1, "dell xps13");
    }

    @RequestMapping(value = "/demo7", method = RequestMethod.GET)
    public void demo7() {
        //删除和value相同的count个元素，count < 0，从右开始,count > 0，从左开始,count = 0，全部
        redisTemplate.opsForList().remove("product:list", -1, "HuaWei Mate20 pro");
    }

    @RequestMapping(value = "/demo8", method = RequestMethod.GET)
    public void demo8() {
        //获取制定下标对应的值 index,从0开始，有正负两套下标
        //[a,b,c,d] 下标有[0,1,2,3]和[0,-3,-2,-1];
        String value = (String) redisTemplate.opsForList().index("product:list", 1);
        System.out.println(value);
    }

    @RequestMapping(value = "/demo9", method = RequestMethod.GET)
    public void demo9() {
        //查询list中指定范围的内容
        List<String> list = redisTemplate.opsForList().range("product:list", 0, -1);
        System.out.println(list);

        //修剪列表，使其只包含指定范围内的元素
        redisTemplate.opsForList().trim("product:list", 0, 2);

        //查询列表长度
        System.out.println(redisTemplate.opsForList().size("product:list"));
    }

    @RequestMapping(value = "/demo10", method = RequestMethod.GET)
    public void demo10() {
        //弹出最左边元素
        redisTemplate.opsForList().leftPop("product:list");
        //移出并获取列表的第一个元素， 如果列表没有元素会阻塞列表直到等待超时。
        redisTemplate.opsForList().leftPop("k1", 10, TimeUnit.SECONDS);


        //弹出最右边元素
        redisTemplate.opsForList().rightPop("product:list");

        //弹出k1最右边元素并放入k2最左边
        redisTemplate.opsForList().rightPopAndLeftPush("product:list", "game:list");
    }


}
