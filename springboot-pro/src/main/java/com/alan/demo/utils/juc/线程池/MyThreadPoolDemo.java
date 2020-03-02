package com.alan.demo.utils.juc.线程池;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/3/2
 */

public class MyThreadPoolDemo {


    public static void main(String[] args) {


//        ExecutorService threadPool = Executors.newFixedThreadPool(5);  //一池五线程
//        ExecutorService threadPool = Executors.newSingleThreadExecutor(); //一池1个处理线程
        ExecutorService threadPool = Executors.newCachedThreadPool(); //一池N个处理线程


        try {
            //模拟10个用户来办理业务,每个用户就是一个来自外部的请求线程
            for (int i = 0; i < 10; i++) {
                threadPool.execute(() -> {

                    System.out.println(Thread.currentThread().getName() + "\t 办理业务");
                });
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }
}
