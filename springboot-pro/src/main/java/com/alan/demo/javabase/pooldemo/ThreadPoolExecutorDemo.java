package com.alan.demo.javabase.pooldemo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Description 一个简单的线程池demo: Runnable + ThreadPoolExecutor
 * <p>
 * 验证几个参数起作用的条件
 * <p>
 * 1.MAX_POOL_SIZE 最大线程数
 * 当任务队列满的时候 开始起作用
 * <p>
 * <p>
 * 注意:CallerRunsPolicy 这个拒绝策略能够 增加队列的大小
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/2/5
 */

public class ThreadPoolExecutorDemo {

    //核心线程数
    private static final int CORE_POOL_SIZE = 5;
    //最大线程数
    private static final int MAX_POOL_SIZE = 10;
    //队列容量
    private static final int QUEUE_CAPACITY = 100;
    //线程空闲时间
    private static final Long KEEP_ALIVE_TIME = 1L;


    public static void main(String[] args) {


        //使用阿里巴巴推荐的创建线程池的方式
        //通过ThreadPoolExecutor构造函数自定义参数创建
        ThreadPoolExecutor executor = new ThreadPoolExecutor(

                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );

        for (int i = 0; i < 120; i++) {

            //创建WorkerThread对象（WorkerThread类实现了Runnable 接口）
            Runnable worker = new MyRunnable("" + "工作任务: " + i);

            //执行Runnable
            executor.execute(worker);
            System.out.println(worker);
        }


        //终止线程池
        executor.shutdown();
        while (!executor.isTerminated()) {

        }
        System.out.println("Finished all threads");
    }
}
