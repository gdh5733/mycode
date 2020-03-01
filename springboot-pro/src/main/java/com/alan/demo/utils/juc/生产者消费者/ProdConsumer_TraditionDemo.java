package com.alan.demo.utils.juc.生产者消费者;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//资源类
class ShareData {

    private int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();


    /**
     * 加
     *
     * @throws Exception
     */
    public void increment() throws Exception {

        lock.lock();
        try {
            //1 判断
            while (number != 0) {
                //等待,不能生产
                condition.await();
            }

            //2 干活
            number++;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            //3 通知唤醒
            condition.signal();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    /**
     * 减
     *
     * @throws Exception
     */
    public void decrement() throws Exception {

        lock.lock();
        try {
            //1 判断
            while (number == 0) {
                //等待,不能生产
                condition.await();
            }

            //2 干活
            number--;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            //3 通知唤醒
            condition.signal();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
}


/**
 * @Description 题目: 一个初始值为零的变量,两个线程对其交替操作,一个加1 一个减1 来五轮
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/18
 */

public class ProdConsumer_TraditionDemo {

    //核心线程数
    private static final int CORE_POOL_SIZE = 2;
    //最大线程数
    private static final int MAX_POOL_SIZE = 2;

    //线程空闲时间
    private static final Long KEEP_ALIVE_TIME = 1L;
    //队列容量
    private static final int QUEUE_CAPACITY = 500;


    public static void main(String[] args) {
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();
        ShareData shareData = new ShareData();


        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                threadFactory,
                new ThreadPoolExecutor.CallerRunsPolicy()
        );
        executor.execute(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    shareData.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });



        executor.execute(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    shareData.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        executor.shutdown();
    }

}
