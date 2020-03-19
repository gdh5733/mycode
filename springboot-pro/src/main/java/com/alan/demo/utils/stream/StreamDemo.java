package com.alan.demo.utils.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @Description Stream 的使用
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/2/16
 */

public class StreamDemo {

    //通过数组来生成
    static void gen1() {
        String[] strs = {"a", "b", "c", "d"};

        Stream<String> strs1 = Stream.of(strs);

        strs1.forEach(System.out::println);

    }

    //通过集合来生成
    static void gen2() {
        List<String> list = Arrays.asList("1,2,3,4");
        Stream<String> stream = list.stream();
        stream.forEach(System.out::println);

    }


    public static void main(String[] args) {
//        gen1();
        gen2();

        //中间操作: 如果调用方法之后返回的结果是Stream对象就意味着是一个中间操作
        Arrays.asList(1, 2, 3, 4, 5)
                .stream()
                .filter((x) -> x % 2 == 0)
                .forEach(System.out::println);


        //求出结果集中所有偶数的个数
        long val = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9)
                .stream()
                .filter(x -> x % 2 == 0)
                .count();
        System.out.println("偶数的个数为: " + val);


        //求出结果集中所有偶数的和
        int sum = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9)
                .stream()
                .filter(x -> x % 2 == 0)
                .mapToInt(x -> x)
                .sum();
        System.out.println("偶数的和为: " + sum);


        //求集合中最大的值
        int maxval = Arrays.asList(1, 2, 3, 4, 5, 6)
                .stream()
                .max((a, b) -> a - b)
                .get();
        System.out.println("集合中的最大值为:" + maxval);


        //求集合中的最小的值
        int minval = Arrays.asList(1, 2, 3, 4, 5, 6)
                .stream()
                .max((a, b) -> b - a)
                .get();
        System.out.println("集合中的最小的值为:" + minval);

    }
}
