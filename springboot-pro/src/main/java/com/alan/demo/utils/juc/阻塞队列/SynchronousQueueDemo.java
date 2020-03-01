package com.alan.demo.utils.juc.阻塞队列;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @Description 同步阻塞队列SynchronousQueue  生产一个 消费一个 才能继续生产
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/2/5
 */

public class SynchronousQueueDemo {


    public static void main(String[] args) throws InterruptedException {

        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();

        BlockingQueue<String> blockingQueue = new SynchronousQueue<>();

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2,
                3,
                1L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10),
                threadFactory,
                new ThreadPoolExecutor.CallerRunsPolicy()
        );

        executor.execute(() -> {

            try {
                System.out.println(Thread.currentThread().getName() + "\t put 1");
                blockingQueue.put("1");
                System.out.println(Thread.currentThread().getName() + "\t put 2");
                blockingQueue.put("2");
                System.out.println(Thread.currentThread().getName() + "\t put 3");
                blockingQueue.put("3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "\t ");
        });


        executor.execute(() -> {

            try {

                TimeUnit.SECONDS.sleep(5);
                System.out.println("取出: " + blockingQueue.take());
                TimeUnit.SECONDS.sleep(5);
                System.out.println("取出: " + blockingQueue.take());
                TimeUnit.SECONDS.sleep(5);
                System.out.println("取出: " + blockingQueue.take());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "\t ");
        });

        executor.shutdown();
    }

}
