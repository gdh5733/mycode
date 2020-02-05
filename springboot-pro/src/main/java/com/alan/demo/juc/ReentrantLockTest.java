package com.alan.demo.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/7
 */

public class ReentrantLockTest {

    private static final Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        new Thread(() -> test(), "线程A").start();
        new Thread(() -> test(), "线程B").start();
    }

    /**
     * 简单使用作用跟synchronized一样
     */
    public static void test() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "获取了锁");
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
            System.out.println(Thread.currentThread().getName() + "释放了锁");

        }
    }

}
