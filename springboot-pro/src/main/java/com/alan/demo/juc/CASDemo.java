package com.alan.demo.juc;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description 1. CAS 是什么? ===>compareAndSet
 * 比较并交换
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/19
 */

public class CASDemo {


    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);

        atomicInteger.getAndIncrement();

        System.out.println(atomicInteger.compareAndSet(5, 2019) + "\t current data" + atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(6, 2020) + "\t current data" + atomicInteger.get());


    }
}
