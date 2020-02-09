package com.alan.demo.utils.redis;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

/**
 * @Description 布隆过滤器  guava自带的
 * 缺点: 只支持单机
 * <p>
 * 现在一般都是分布式场景 所以推荐使用Redis自带的布隆过滤器
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/2/3
 */

public class BloomFilterDemo {


    public static void main(String[] args) {

        //创建布隆过滤器对象
        BloomFilter<Integer> filter = BloomFilter.create(
                Funnels.integerFunnel(),
                1500,
                0.01
        );

        //判断指定元素是否存在
        System.out.println(filter.mightContain(1));
        System.out.println(filter.mightContain(2));

        //将元素添加进布隆过滤器
        filter.put(1);
        filter.put(2);
        System.out.println(filter.mightContain(1));
        System.out.println(filter.mightContain(2));
    }

}
