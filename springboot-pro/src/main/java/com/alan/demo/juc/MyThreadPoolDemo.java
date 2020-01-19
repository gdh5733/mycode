package com.alan.demo.juc;

import java.util.concurrent.*;

/**
 * @Description 第四种获取多线程的方式  线程池
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/19
 */

public class MyThreadPoolDemo {


    public static void main(String[] args) {

        //查看是几核的CPU
        System.out.println(Runtime.getRuntime().availableProcessors());

//        ExecutorService threadPool = Executors.newFixedThreadPool(5);//一池五个处理线程(固定)
//        ExecutorService threadPool = Executors.newSingleThreadExecutor();//一池1线程(单一)
        ExecutorService threadPool = Executors.newCachedThreadPool();//一池n线程(多个线程)


        //注意 最大线程池数(maximumPoolSize) 和 队列的长度
        //最终能处理的任务数量为 最大线程池数 + 队列的长度
        //最大线程池的值的确定分为两种情况 CPU密集型  和 IO密集型

        //CPU 应该根据cpu的核数加上一个线程
        //IO  参考公式 CPU核数/1-阻塞系数     阻塞系数一般为0.9   比如8核CPU 8/1-0.9=80个线程数

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,
                5,
                2L,
                TimeUnit.SECONDS, new LinkedBlockingDeque<>(5),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy());

        //模拟有20个用户来办理业务
        for (int i = 0; i < 20; i++) {

            //线程池(银行)中有五个窗口干活
            threadPool.execute(() -> {
                System.out.println(Thread.currentThread().getName() + "\t 办理业务");
            });
        }

        threadPool.shutdown();
    }
}
